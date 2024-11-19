package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public User getUser() {
//        return userService.getUser();
//    }

//    @GetMapping("/hello")
//    public String hello() {
//        return userService.hello();
//    }

//    @GetMapping("/multiple-users")
//    public List multipleUsers() {
//        return userService.multipleUsers();
//    }

//    @GetMapping("/multiple-users2")
//    public User[] multipleUsers2() {
//        return userService.multipleUsers2();
//    }

    //PathVariable
    //Endpoint to get a user by their ID

//    @GetMapping("/user/{id}")
//    public String getUserById(@PathVariable("id") int userId) {
//        return userService.getUserById(userId);
//    }

    @GetMapping("/{name}")
    public String greetName(@PathVariable("name") String userName) {
        return userService.greetName(userName);
    }

    @GetMapping("/square/{nr}")
    public String square(@PathVariable("nr") int userNr) {
        return userService.square(userNr);
    }

//    @GetMapping("userbyid/{id}")
//    public User getUserById2(@PathVariable("id") Long id) {
//        return userService.getUserById2(id);
//    }

    @GetMapping("user/{userId}/order/{orderId}")
    public String getOrderById(@PathVariable("userId") String userId,
                               @PathVariable("orderId") String orderId) {
        return userService.getOrderById(userId, orderId);
    }

    @GetMapping("/fullname")
    public String fullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return userService.fullname(firstName, lastName);
    }

    @GetMapping("/greeting")
    public String greetingLanguage(@RequestParam(name = "name", defaultValue = "World") String name,
                                   @RequestParam("language") String language) {
  return userService.greetingLanguage(name, language);
    }

    @GetMapping("/listofusers")
    public List<User> printUsers() {
        return userService.printUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId) {
        return userService.deleteUser(userId);
    }
    @PostMapping("/add-users")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PutMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Long userId, @RequestBody User incomeinfUserData) {
        return userService.updateUser(userId, incomeinfUserData);
    }

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}



