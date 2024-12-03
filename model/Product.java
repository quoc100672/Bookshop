package com.example.bookstore.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    // Định nghĩa Enum cho category
    public enum ProductCategory {
        CATEGORY1,
        CATE2,
        GORY3,// Phụ kiện
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    private int quantity;

    private String imageUrl;

    // Thêm trường category
    @Enumerated(EnumType.STRING)

    @Column(nullable = false)
    private ProductCategory category;

    // Thêm getter và setter cho category
    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    // Các getter và setter khác giữ nguyên
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}