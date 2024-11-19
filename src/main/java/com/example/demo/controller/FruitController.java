package com.example.demo.controller;


import com.example.demo.model.Fruit;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fruits")


public class FruitController {

    private final UserService userService;

    public FruitController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/fruits")
    public Map<Long, String> getFruits() {

        return userService.getFruits();

    }
}
