///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.oujava.controllers;
//
//import com.oujava.pojo.Job;
//import com.oujava.pojo.User;
//import com.oujava.service.UserService;
//import java.util.Map;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author nguye
// */
//@Controller
//public class RegisterController {
//    private UserService userService;
//    @PutMapping(value = "/register") 
//    public String register(@ModelAttribute (value = "user") User u,@RequestBody Map<String, String> params,MultipartFile avatar){
//        if (userService.register(params, avatar) == true)
//                return "redirect:/";
//        return "register";
//    }
//    
//}