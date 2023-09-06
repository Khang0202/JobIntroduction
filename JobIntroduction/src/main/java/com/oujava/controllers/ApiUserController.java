/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.User;
import com.oujava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerCandidate")
    public ResponseEntity<String> registerCandidate(@RequestBody User user) {
        userService.registerCandidate(user);
        return new ResponseEntity<>("register success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String input, String password) {

        User user = userService.login(input, password);

         if (user != null) {
        return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Đăng nhập thất bại", HttpStatus.UNAUTHORIZED);
    }  
    }

}
