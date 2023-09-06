/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;


import com.oujava.pojo.Permission;
import com.oujava.pojo.User;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface UserRepository {
    List<User> getAllUsers(); 
    List<Permission> getAllPermissionById(int userId);
    User getUserByUsername(String username);
     User  login(String username,String password);
    void registerCandidate(User user);
    void registerCustomer(User user);
    void editRoleByUserId(int userId, int roleId); 

    void editActiveByUserId(int userId, boolean active); 
}
