/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;


import com.oujava.pojo.Permission;
import com.oujava.pojo.User;
import com.oujava.repository.UserRepository;
import com.oujava.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;
    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void editRoleByUserId(int userId, int roleId) {
        userRepo.editRoleByUserId(userId, roleId);
    }

    @Override
    public void editActiveByUserId(int userId, boolean active) {
        userRepo.editActiveByUserId(userId, active);
    }

     @Override
    public User login(String usernameOrEmail, String password) {
        return userRepo.login(usernameOrEmail, password);
}

    @Override
    public void registerCandidate(User user) {
        userRepo.registerCandidate(user);
    }

    @Override
    public void registerCustomer(User user) {
        userRepo.registerCustomer(user);
    }

    @Override
    public List<Permission> getAllPermissionById(int userId) {
        return userRepo.getAllPermissionById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }


    
    
}
