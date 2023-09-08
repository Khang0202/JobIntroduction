/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface UserRepository {
    List<User> getAllUsers(); 
    List<Permission> getAllPermissionByUserId(int userId);
    User getUserByUsername(String username);
    User login(String username,String password);
    boolean register(User user);
    void editRoleByUserId(int userId, int roleId); 
    Role getUserRoleByUserId(int id);
    void editActiveByUserId(int userId, boolean active); 
    boolean checkUserAndMail(String input);
}
