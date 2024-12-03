package com.example.bookstore.bookstore.service;


import com.example.bookstore.bookstore.model.Order;
import com.example.bookstore.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    public Order placeOrder(String customerName, String customerEmail, String shippingAddress) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setShippingAddress(shippingAddress);
        order.setItems(new ArrayList<>(cartService.getCartItems()));
        order.setTotalAmount(cartService.getTotalAmount());

        Order savedOrder = orderRepository.save(order);
        cartService.clearCart();
        return savedOrder;
    }
}
