package com.example.bookstore.bookstore.repository;

import com.example.bookstore.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

