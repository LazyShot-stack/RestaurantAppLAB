package org.dhruvik.restaurant.service;

import org.dhruvik.restaurant.dto.CustomerRequest;
import org.dhruvik.restaurant.dto.CustomerResponse;
import org.dhruvik.restaurant.entity.Customer;
import org.dhruvik.restaurant.mapper.CustomerMapper;
import org.dhruvik.restaurant.repo.CustomerRepo;
import org.dhruvik.restaurant.helper.EncryptionService;
import org.dhruvik.restaurant.helper.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.dhruvik.restaurant.dto.LoginRequest;

@Service
@RequiredArgsConstructor

public class CustomerService {
 private final CustomerRepo repo;
 private final CustomerMapper mapper;
    private final JWTHelper jwtHelper;
    private final EncryptionService encryptionService;

 public String createCustomer(CustomerRequest request){
     Customer customer=mapper.toEntity(request);
     customer.setPassword(encryptionService.encode(request.password()));
     repo.save(customer);
     return "Created";
 }
 public Customer getCustomer(String email){
     return repo.findByEmail(email).orElseThrow(()->new RuntimeException("Customer not found"));
 }

    public String loginCustomer(LoginRequest loginRequest) {
        Customer customer = getCustomer(loginRequest.email());
        if (encryptionService.validates(loginRequest.password(), customer.getPassword())) {
            return jwtHelper.generateToken(customer.getEmail());
        }
        return "Wrong password or Email";
    }

    public String updateCustomer(String email, CustomerRequest updatedRequest) {
        Customer existingCustomer = getCustomer(email);

        existingCustomer.setFirstName(updatedRequest.firstName());
        existingCustomer.setLastName(updatedRequest.lastName());
        existingCustomer.setCity(updatedRequest.city());
        existingCustomer.setAddress(updatedRequest.Address());
        existingCustomer.setPincode(updatedRequest.pincode());

        if (updatedRequest.password() != null && !updatedRequest.password().isEmpty()) {
            existingCustomer.setPassword(encryptionService.encode(updatedRequest.password()));
        }
        repo.save(existingCustomer);
        return "Customer updated successfully";
    }

    public CustomerResponse deleteCustomer(String email) {
        Customer customer = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapper.toResponse(customer);
    }
    public CustomerResponse getCustomerResponseByEmail(String email) {
        Customer customer = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapper.toResponse(customer);
    }



}
