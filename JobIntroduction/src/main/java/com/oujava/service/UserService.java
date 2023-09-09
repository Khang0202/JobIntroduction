/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import java.util.List;

/**
 *
 * @author trann
 */
public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    List<Permission> getAllPermissionByUserId(int userId);

    User getUserByUsername(String username);

    boolean login(String username, String password);

    boolean register(User user);

    void editRoleByUserId(int userId, int roleId);

    Role getUserRoleByUserId(int id);

    boolean editActiveByUserId(int userId, boolean active);

    boolean authUser(String username, String password);
}
