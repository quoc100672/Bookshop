package com.example.bookstore.bookstore.repository;

import com.example.bookstore.bookstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Product.ProductCategory category);
}