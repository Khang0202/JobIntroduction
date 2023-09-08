/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Job;
import com.oujava.pojo.User;
import com.oujava.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nguye
 */
@Controller
public class RegisterController {
    private UserService userService;
    @PostMapping(value = "/register") 
    public String register(@ModelAttribute (value = "user") User u){
        if (userService.register(u) == true)
                return "redirect:/";
        return "register";
    }
    
}
