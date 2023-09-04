/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.DTO.CandidateDTO;
import com.oujava.DTO.CustomerDTO;
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
    public void login(String username, String password) {
    }

    @Override
    public void registerCandidate(CandidateDTO candidate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registerCustomer(CustomerDTO customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
}
