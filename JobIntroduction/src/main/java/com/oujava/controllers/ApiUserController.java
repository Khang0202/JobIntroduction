/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.components.JwtService;
import com.oujava.pojo.Rating;
import com.oujava.pojo.User;
import com.oujava.service.RatingService;
import com.oujava.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nguye
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private JwtService JwtService;
    
    
    
    @GetMapping("/{userId}/rating")
    @CrossOrigin
    public ResponseEntity<List<Rating>> listrating(@PathVariable(value = "userId") int id) {
        try {
            return new ResponseEntity<>(ratingService.getRatingOfCusId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            String usernameOrEmail = user.getUsername();
            if (!userService.authUser(usernameOrEmail, user.getPassword())) {
                usernameOrEmail = user.getEmail();
                if (!userService.authUser(usernameOrEmail, user.getPassword())) {
                    return ResponseEntity.ok("{\"login\":\"failed\"}");
                }
            }
            String token = JwtService.generateTokenLogin(usernameOrEmail);
            return ResponseEntity.ok("{\"login\":\"success\", \"token\":\"" + token + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            if (userService.register(user)) {
                return ResponseEntity.ok("{\"register\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"register\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }

    }
    
    @PostMapping("/updateUserInfo/{username}")
    @CrossOrigin
    public ResponseEntity<String> updateUserInfo(@PathVariable String username, @RequestBody User updatedUser){
     try {
            if (userService.updateUserInfo(username)) {
                return ResponseEntity.ok("{\"message\":\"Update success\"}");
            } else {
                return ResponseEntity.badRequest().body("{\"message\":\"Update failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\":\"Error Server\"}");
        }
    }
}
