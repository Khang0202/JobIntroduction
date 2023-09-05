/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.DTO.CandidateDTO;
import com.oujava.DTO.CustomerDTO;
import com.oujava.pojo.Permission;
import com.oujava.pojo.User;
import java.util.List;

/**
 *
 * @author trann
 */
public interface UserService {
    List<User> getAllUsers(); 
    List<Permission> getAllPermissionById(int userId);
    void editRoleByUserId(int userId, int roleId); 

    void editActiveByUserId(int userId, boolean active); 
    void login(String username,String password);
    void registerCandidate(CandidateDTO candidate);
    void registerCustomer(CustomerDTO customer);

    
}
