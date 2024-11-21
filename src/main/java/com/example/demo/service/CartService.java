package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {


    private final SpringDataWebAutoConfiguration springDataWebAutoConfiguration;
    private ProductRepository productRepository;

    public CartService(ProductRepository productRepository, SpringDataWebAutoConfiguration springDataWebAutoConfiguration) {
        this.productRepository = productRepository;
        this.springDataWebAutoConfiguration = springDataWebAutoConfiguration;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String deleteProduct(String name) {
        productRepository.deleteByName(name);
        return "Product deleted";
    }

    public double calculateCartTotal() {
        List<Product> products = getAllProducts();
       double total = 0.0;
        for (Product product : products) {
            total += product.totalPrice();
        }
        System.out.println(total);
        return total;

    }

}

