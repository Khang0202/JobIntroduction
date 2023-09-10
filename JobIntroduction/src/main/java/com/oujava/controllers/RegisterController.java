/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.format.GetDate;
import com.oujava.pojo.Role;
import com.oujava.pojo.StaticClass;
import com.oujava.pojo.User;
import com.oujava.service.RoleService;
import com.oujava.service.UserService;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nguye
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute
    public void commonAttr(Model model) {

    }

    @GetMapping("/register")
    public String register(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.getAllRole(params));
        return "register";
    }

    @PostMapping("/register")
    public String add(@ModelAttribute(value = "user") User user) {
        
        Role role = new Role(); 
        role.setId(1); 
        user.setRoleId(role);

        if (userService.register(user)) {
            return "redirect:/login";
        }
        
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        return "redirect:/";
    }
    
    @GetMapping(value = "/register/{username}") 
    public String update (@PathVariable(value = "username") String username){
        StaticClass.user.setUsername(username);
        User u = this.userService.getUserByUsername(StaticClass.user.getUsername());
        StaticClass.user = u;
        return "register";
    }
}
