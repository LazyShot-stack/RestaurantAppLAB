package org.dhruvik.restaurant.entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name="product_name",nullable = false)
    private String productName;

    @Column(name="product_price",nullable = false)
    private double productPrice;
}
