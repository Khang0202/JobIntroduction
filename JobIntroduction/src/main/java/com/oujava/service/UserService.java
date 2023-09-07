/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author trann
 */
public interface UserService {
    List<User> getAllUsers();
    List<Permission> getAllPermissionByUserId(int userId);
    void editRoleByUserId(int userId, int roleId); 
    User getUserByUsername(String username);
    void editActiveByUserId(int userId, boolean active); 
    User login(String username,String password);
    
    User register(Map<String, String> params, MultipartFile avatar);
    
    void registerCandidate(User user);
    void registerCustomer(User user);
    Role getUserRoleByUserId(int id);
    
}
