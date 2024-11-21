package org.dhruvik.restaurant.mapper;

import org.dhruvik.restaurant.dto.CustomerResponse;
import org.dhruvik.restaurant.entity.Customer;
import org.dhruvik.restaurant.dto.CustomerRequest;
import org.springframework.stereotype.Service;
@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request)
    {
      return Customer.builder()
              .firstName(request.firstName())
              .lastName(request.lastName())
              .email(request.email())
              .password(request.password())
              .city(request.city())
              .address(request.Address())
              .pincode(request.pincode())
              .build();
    }

    public CustomerResponse toResponse(Customer customer){
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail(), "****", customer.getCity(), customer.getAddress(), customer.getPincode());
    }

}
