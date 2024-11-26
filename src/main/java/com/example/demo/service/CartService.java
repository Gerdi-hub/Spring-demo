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

    public double calculateTax(){
        List<Product> products = getAllProducts();
        double total = calculateCartTotal() * 0.22;
        System.out.println(total);
        return total;
    }

    public double applyDiscount(boolean isMember) {
        double discount = 0;
        if (isMember) {
            double totalSum = calculateCartTotal() + calculateTax();
            discount = totalSum * 0.1;
        }
        return discount;
    }

    public double calculateTotalWithTax (){
        return calculateCartTotal() + calculateTax();
    }

}

