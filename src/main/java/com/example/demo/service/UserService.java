package com.example.demo.service;

import com.example.demo.model.Fruit;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    private List<User> users = new ArrayList<>( List.of(
//            new User(1L, "Mari Mets", "mari@mets.com"),
//            new User(2L, "Paul Ploom", "paul@ploom.com"),
//            new User(3L, "Kalle Kask", "kalle@kask.com")));




//    public User[] multipleUsers2() {
//        User user1 = new User(1L, "Mari Mets", "mari@mets.com");
//        User user2 = new User(2L, "Paul Ploom", "paul@ploom.com");
//        User user3 = new User(3L, "Kalle Kask", "kalle@kask.com");
//        User[] arrayOfUsers = {user1, user2, user3};
//
//        return arrayOfUsers;
//    }

//    public List multipleUsers() {
//        User user1 = new User(1L, "Mari Mets", "mari@mets.com");
//        User user2 = new User(2L, "Paul Ploom", "paul@ploom.com");
//        User user3 = new User(3L, "Kalle Kasl", "kalle@lasl.com");
//        List<User> listOfUsers = new ArrayList<>();
//        listOfUsers.add(user1);
//        listOfUsers.add(user2);
//        listOfUsers.add(user3);
//
//        return listOfUsers;
//
//    }

//    public User getUser() {
//       User user = new User(1L, "John Doe", "john@doe.com");
//        return user;
//    }

//    public String hello() {
//        return "Hello " + getUser().getName();
//    }

    public String getUserById(int userId) {
        return "User ID: " + userId;
    }

    public String greetName(String userName) {
        return "Hello " + userName;
    }

    public Map<Long, String> getFruits() {
        Fruit fruit1 = new Fruit(1L, "Apple");
        Fruit fruit2 = new Fruit(2L, "Banana");
        Fruit fruit3 = new Fruit(3L, "Cherry");
        Map<Long, String> fruits = new HashMap<>();
        fruits.put(1L, "Apple");
        fruits.put(2L, "Banana");
        fruits.put(3L, "Cherry");
        return fruits;

    }

    public String square(int userNr) {
        return "Square of " + userNr + " is " + userNr * userNr;
    }

//    public User getUserById2(Long id) {
//
//        List<User> listOfUsers = List.of(
//                new User(1L, "Mari Mets", "mari@mets.com"),
//                new User(2L, "Paul Ploom", "paul@ploom.com"),
//                new User(3L, "Kalle Kask", "kalle@kask.com"));
//
//
//        for (User user : listOfUsers) {
//            if (user.getId().equals(id)) {
//                return user;
//            }
//        }
//        return null;
//
//    }

    public String getOrderById(String userId,
                               String orderId) {
        return "User ID: " + userId + " Order ID: " + orderId;
    }

    public String fullname(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String greetingLanguage(String name,
                                   String language) {
        switch (language) {
            case "eng":
                return "Hi, " + name;

            case "fr":
                return "Bonjour,  " + name;
            case "es":
                return "Hola,  " + name;
        }
        return "Hello, " + name;
    }

    public String deleteUser(Long id) {
        for (User user : getAllUsers()) {
            if (user.getId().equals(id)) {
                userRepository.delete(user);
                return "User " + id + " has been deleted";
            }

        }
        printUsers();
        return "User " + id + " not found";
    }
    public List printUsers(){
        List<User>listOfUsers = getAllUsers();
        return listOfUsers;
    }

public String addUser(User user) {
        userRepository.save(user);

        return "User " + user.getId() + " has been added";
}

    public String updateUser(Long id, User updatedUser) {
     for (User existingUser : getAllUsers()) {
         if (existingUser.getId().equals(id)) {
             existingUser.setFirstName(updatedUser.getFirstName());
             existingUser.setLastName(updatedUser.getLastName());
//             existingUser.setName(updatedUser.getName());
             existingUser.setEmail(updatedUser.getEmail());
             userRepository.save(existingUser);
             return  "User with id " + id + " has been updated";
         }
     }
     return "User with id " + id + " not found";
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public int getUsersCount() {
        return getAllUsers().size();
    }



}
