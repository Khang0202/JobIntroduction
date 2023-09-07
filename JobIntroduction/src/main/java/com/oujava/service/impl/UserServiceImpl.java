/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.oujava.format.GetDate;
import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import com.oujava.repository.UserRepository;
import com.oujava.service.UserService;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author trann
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;
    
    private Cloudinary cloudinary;
    
//    @Autowired
    //    private BCryptPasswordEncoder passEncoder;
    
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
    public List<Permission> getAllPermissionByUserId(int userId) {
        return userRepo.getAllPermissionByUserId(userId);
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }

    @Override
    public Role getUserRoleByUserId(int id) {
        return userRepo.getUserRoleByUserId(id);
    }

    @Override
    public void registerCandidate(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registerCustomer(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public User register(Map<String, String> params, MultipartFile avatar) {
//        User u = new User();
//        u.setFirstName(params.get("firstName"));
//        u.setLastName(params.get("lastName"));
//        u.setPhone(params.get("phone"));
//        u.setEmail(params.get("email"));
//        u.setUsername(params.get("username"));
//        u.setPassword(this.passEncoder.encode(params.get("password")));
//        try {
//            u.setBirth(GetDate.getDateFromString(params.get("birth")));
//        } catch (ParseException ex) {
//            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        u.setSex(params.get("sex"));
//        u.setRoleId(new Role(Integer.valueOf( params.get("roleId"))));
//        if (!avatar.isEmpty()) {
//                try {
//                    Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
//                            ObjectUtils.asMap("resource_type", "auto"));
//                    u.setImage(res.get("secure_url").toString());
//                } catch (IOException ex) {
//                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        return null;
//    }
}
