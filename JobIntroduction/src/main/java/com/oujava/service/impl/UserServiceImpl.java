/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import com.oujava.repository.UserRepository;
import com.oujava.service.UserService;
import java.util.List;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.oujava.format.GetDate;
import com.oujava.pojo.StaticClass;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @Override
    public void editRoleByUserId(int userId, int roleId) {
        this.userRepo.editRoleByUserId(userId, roleId);
    }

    @Override
    public boolean editActiveByUserId(int userId, boolean active) {
        return this.userRepo.editActiveByUserId(userId, active);
    }

    @Override
    public boolean login(String usernameOrEmail, String password) {
        return this.userRepo.login(usernameOrEmail, password);
    }

    @Override
    public List<Permission> getAllPermissionByUserId(int userId) {
        return this.userRepo.getAllPermissionByUserId(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public Role getUserRoleByUserId(int id) {
        return this.userRepo.getUserRoleByUserId(id);
    }
    
    @Override
    public boolean register(User user) {
        user.setPassword(passEncoder.encode(user.getPassword()));
        try {
            user.setBirth(GetDate.getDateFromString(user.getBirthform()));
        } catch (ParseException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setActive(Boolean.TRUE);
        if (!user.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.userRepo.register(user);
    }
    
    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User users = this.userRepo.getUserByUsername(string);
        StaticClass.user = users;
        if (users == null) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(users.getRoleId().getRole()));
        return new org.springframework.security.core.userdetails.User(
                users.getUsername(), users.getPassword(), authorities);
    }
     
    

    @Override
    public boolean updateUserInfo(String username) {
        return this.userRepo.updateUserInfo(username);
    }
}
