/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.User;
import com.oujava.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String input = loginRequest.get("input");
        String password = loginRequest.get("password");
        User user = userService.login(input, password);
        
        if (user != null) {
            return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Đăng nhập thất bại", HttpStatus.UNAUTHORIZED);
        }
    }

}
