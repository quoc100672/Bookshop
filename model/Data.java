package com.example.bookstore.bookstore.model;

import com.example.bookstore.bookstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Data implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) { // Mở lại điều kiện
            Product product1 = new Product();
            product1.setName("Travel Suitcase");
            product1.setDescription("Durable and spacious suitcase for travel");
            product1.setPrice(250.00);
            product1.setQuantity(10);
            product1.setImageUrl("/images/1984.jpg");
            product1.setCategory(Product.ProductCategory.CATEGORY1);
            productRepository.save(product1);

            Product product2 = new Product();
            product2.setName("Travel Backpack");
            product2.setDescription("Lightweight backpack for everyday travel");
            product2.setPrice(150.00);
            product2.setQuantity(20);
            product2.setImageUrl("images/1984.jpg");
            product2.setCategory(Product.ProductCategory.CATEGORY1);
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("Camping Tent");
            product3.setDescription("Weather-resistant tent for outdoor camping");
            product3.setPrice(300.00);
            product3.setQuantity(15);
            product3.setImageUrl("images/1984.jpg");
            product3.setCategory(Product.ProductCategory.CATE2);
            productRepository.save(product3);

            Product product4 = new Product();
            product4.setName("Portable Grill");
            product4.setDescription("Compact grill for outdoor cooking");
            product4.setPrice(120.00);
            product4.setQuantity(25);
            product4.setImageUrl("images/1984.jpg");
            product4.setCategory(Product.ProductCategory.CATE2);
            productRepository.save(product4);

            Product product5 = new Product();
            product5.setName("Travel Pillow");
            product5.setDescription("Ergonomic pillow for comfortable travel");
            product5.setPrice(40.00);
            product5.setQuantity(30);
            product5.setImageUrl("images/1984.jpg");
            product5.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product5);

            Product product6 = new Product();
            product6.setName("Sleep Mask");
            product6.setDescription("Comfortable sleep mask for better rest");
            product6.setPrice(20.00);
            product6.setQuantity(50);
            product6.setImageUrl("images/1984.jpg");
            product6.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product6);

            Product product7 = new Product();
            product7.setName("Bluetooth Speaker");
            product7.setDescription("Wireless speaker for music on the go");
            product7.setPrice(80.00);
            product7.setQuantity(40);
            product7.setImageUrl("images/1984.jpg");
            product7.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product7);

            Product product8 = new Product();
            product8.setName("Power Bank");
            product8.setDescription("High-capacity power bank for charging devices");
            product8.setPrice(60.00);
            product8.setQuantity(35);
            product8.setImageUrl("images/1984.jpg");
            product8.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product8);

            Product product9 = new Product();
            product9.setName("Travel Shoes");
            product9.setDescription("Comfortable shoes for long walks");
            product9.setPrice(70.00);
            product9.setQuantity(40);
            product9.setImageUrl("images/1984.jpg");
            product9.setCategory(Product.ProductCategory.CATE2);
            productRepository.save(product9);

            Product product10 = new Product();
            product10.setName("Suitcase Organizer");
            product10.setDescription("Packing cubes to organize your suitcase");
            product10.setPrice(30.00);
            product10.setQuantity(45);
            product10.setImageUrl("images/1984.jpg");
            product10.setCategory(Product.ProductCategory.CATEGORY1);
            productRepository.save(product10);

            Product product11 = new Product();
            product11.setName("Travel Mug");
            product11.setDescription("Stainless steel mug for keeping drinks hot");
            product11.setPrice(25.00);
            product11.setQuantity(60);
            product11.setImageUrl("images/1984.jpg");
            product11.setCategory(Product.ProductCategory.CATE2);
            productRepository.save(product11);

            Product product12 = new Product();
            product12.setName("Sunscreen Lotion");
            product12.setDescription("Protect your skin with this sunscreen");
            product12.setPrice(15.00);
            product12.setQuantity(70);
            product12.setImageUrl("images/1984.jpg");
            product12.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product12);

            Product product13 = new Product();
            product13.setName("Camera Tripod");
            product13.setDescription("Stable tripod for professional photography");
            product13.setPrice(120.00);
            product13.setQuantity(25);
            product13.setImageUrl("images/1984.jpg");
            product13.setCategory(Product.ProductCategory.CATE2);
            productRepository.save(product13);

            Product product14 = new Product();
            product14.setName("Waterproof Bag");
            product14.setDescription("Keep your valuables safe and dry");
            product14.setPrice(40.00);
            product14.setQuantity(30);
            product14.setImageUrl("images/1984.jpg");
            product14.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product14);

            Product product15 = new Product();
            product15.setName("Travel Wallet");
            product15.setDescription("Compact wallet for your travel essentials");
            product15.setPrice(50.00);
            product15.setQuantity(40);
            product15.setImageUrl("images/1984.jpg");
            product15.setCategory(Product.ProductCategory.GORY3);
            productRepository.save(product15);

            productRepository.saveAll(Arrays.asList(
                    product1,
                    product2, product3, product4, product5,
                    product6, product7, product8, product9, product10,
                    product11, product12, product13, product14, product15
            ));
        }
    }
}
