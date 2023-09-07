/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.EmploymentType;
import com.oujava.pojo.User;
import com.oujava.service.EmploymentTypeService;
import com.oujava.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/employmentTypes")
public class ApiEmploymentTypeController {
    
    @Autowired
    private EmploymentTypeService employmentTypeService;
    @Autowired
    private UserService userService;

    @GetMapping("/getAllEmploymentType")
    @CrossOrigin
    public List<EmploymentType> getAllEmploymentTypes() {
        return employmentTypeService.getAllEmType();
    }

    @PostMapping("/addEmploymentType")
    @CrossOrigin
    public void addEmploymentType(@RequestBody EmploymentType employmentType) {
        employmentTypeService.addEmType(employmentType);
    }

    @PutMapping("/editEmploymentTyoeById/{id}")
    @CrossOrigin
    public void editEmploymentType(@PathVariable int id, @RequestBody String updatedEmploymentType) {
        employmentTypeService.editEmTypeById(id, updatedEmploymentType);
    }

    @DeleteMapping("/deleteEmTypeById/{id}")
    @CrossOrigin
    public void deleteEmploymentType(@PathVariable int id) {
        employmentTypeService.deleteEmTypeById(id);
    }
    
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(String input, String password) {

        User user = userService.login(input, password);

        if (user != null) {
            return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Đăng nhập thất bại", HttpStatus.UNAUTHORIZED);
        }
    }
}