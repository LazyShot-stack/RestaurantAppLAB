package org.dhruvik.restaurant.repo;

import org.dhruvik.restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.productPrice BETWEEN :min AND :max ORDER BY p.productPrice desc limit 2")
    List<Product> findTop2ProductsByPriceRange(Double min, Double max);

}

