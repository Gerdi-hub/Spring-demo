package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")


public class CartController {
    private final CartService cartService;
    private final ProductRepository productRepository;

    public CartController(CartService cartService, ProductRepository productRepository) {
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @GetMapping ("/all-products")
    public List <Product> getAllProducts() {
        return cartService.getAllProducts();
    }

    @PostMapping ("/post")
    public Product addProduct(@RequestBody Product product) {
        return cartService.addProduct(product);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteProduct(@PathVariable ("name") String name ) {
        return cartService.deleteProduct(name);
    }


    @GetMapping("/total-cost")
    public double calculateTotalCost() {
      return  cartService.calculateCartTotal();

    }

}
