/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.DTO.CandidateDTO;
import com.oujava.DTO.CustomerDTO;
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
    void login(String username,String password);
    void registerCandidate(CandidateDTO candidate);
    void registerCustomer(CustomerDTO customer);
    void editRoleByUserId(int userId, int roleId); 

    void editActiveByUserId(int userId, boolean active); 
}
