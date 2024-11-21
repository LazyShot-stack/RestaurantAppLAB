package org.dhruvik.restaurant.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")

public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 @Column(name = "first_name",nullable = false)
 private String firstName;

 @Column(name = "last_name")
 private String lastName;

 @Column(name = "email",nullable = false,unique = true)
 private String email;

 @Column(name = "password",nullable = false)
 private String password;

 @Column(name = "pincode",nullable = false)
 private String pincode;

 @Column(name = "address",nullable = false)
 private String address;

 @Column(name = "city" ,nullable = false)
 private String city;
}
