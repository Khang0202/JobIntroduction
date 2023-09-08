/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;


import com.oujava.pojo.Permission;
import com.oujava.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
public interface UserRepository {
    List<User> getAllUsers(); 
    List<Permission> getAllPermissionById(int userId);
    User getUserByUsername(String username);
<<<<<<< Updated upstream
     User  login(String username,String password);
    void registerCandidate(User user);
    void registerCustomer(User user);
=======
    User login(String usernameOrEmail,String password);
    User register(User user);
  
>>>>>>> Stashed changes
    void editRoleByUserId(int userId, int roleId); 

    void editActiveByUserId(int userId, boolean active); 
    
    
    boolean checkUserAndMail(String input);
}
