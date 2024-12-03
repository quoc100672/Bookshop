package com.example.bookstore.bookstore.controller;


import com.example.bookstore.bookstore.model.Product;
import com.example.bookstore.bookstore.repository.ProductRepository;
import com.example.bookstore.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repo;

    // Endpoint trả về JSON cho tất cả sản phẩm
    @GetMapping("/api")
    @ResponseBody
    public List<Product> getAllProductsApi() {
        return productService.getAllProducts();
    }

    // Endpoint trả về JSON cho sản phẩm theo id
    @GetMapping("/api/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Endpoint mới: Lấy sản phẩm theo category dạng JSON
    @GetMapping("/api/category/{category}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable Product.ProductCategory category) {
        return repo.findByCategory(category);
    }

    // Hiển thị tất cả sản phẩm
    @GetMapping
    public String ShowProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        // Thêm danh sách categories để hiển thị trong view
        model.addAttribute("categories", Product.ProductCategory.values());
        return "products";
    }

    // Hiển thị sản phẩm theo category
    @GetMapping("/category/{category}")
    public String showProductsByCategory(@PathVariable Product.ProductCategory category, Model model) {
        List<Product> products = repo.findByCategory(category);
        model.addAttribute("products", products);
        model.addAttribute("categories", Product.ProductCategory.values());
        model.addAttribute("currentCategory", category);
        return "products";
    }
}