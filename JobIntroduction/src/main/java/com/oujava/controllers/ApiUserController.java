/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.components.JwtService;
import com.oujava.pojo.Rating;
import com.oujava.pojo.StaticClass;
import com.oujava.pojo.User;
import com.oujava.service.RatingService;
import com.oujava.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
            StaticClass.user = userService.getUserByUsername(usernameOrEmail);
            String token = JwtService.generateTokenLogin(usernameOrEmail);
            return ResponseEntity.ok("{\"login\":\"success\", \"token\":\"" + token + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> register(@RequestBody User user, @RequestPart MultipartFile file) {
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
    
    @PostMapping("/updateUserInfo/{id}")
    @CrossOrigin
    public ResponseEntity<String> updateUserInfo(@PathVariable int id, @RequestBody User updatedUser){
     try {
            if (userService.updateUserInfo(id)) {
                return ResponseEntity.ok("{\"message\":\"Update success\"}");
            } else {
                return ResponseEntity.badRequest().body("{\"message\":\"Update failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\":\"Error Server\"}");
        }
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Authentication authentication) {
        return new ResponseEntity<>(StaticClass.user, HttpStatus.OK);
    }
    
//        @PostMapping(path = "/users/", 
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
//        User user = this.userService.addUser(params, avatar);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
}
