/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;


import com.oujava.pojo.Permission;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
<<<<<<< Updated upstream
=======

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Cloudinary cloudinary;

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
}
=======
    }
>>>>>>> Stashed changes

    @Override
    public void registerCandidate(User user) {
        userRepo.registerCandidate(user);
    }

<<<<<<< Updated upstream
    @Override
    public void registerCustomer(User user) {
        userRepo.registerCustomer(user);
    }

    @Override
    public List<Permission> getAllPermissionById(int userId) {
        return userRepo.getAllPermissionById(userId);
    }

=======
>>>>>>> Stashed changes
    @Override
    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }


<<<<<<< Updated upstream
    
    
=======
    @Override
    public User register(Map<String, String> params, MultipartFile avatar) {
        User user = new User();
        user.setFirstName(params.get("firstName"));
        user.setLastName(params.get("lastName"));
        user.setPhone(params.get("phone"));
        user.setEmail(params.get("email"));
        user.setUsername(params.get("username"));
        user.setPassword(this.passwordEncoder.encode(params.get("password")));

        try {
            user.setBirth(GetDate.getDateFromString(params.get("birth")));
        } catch (ParseException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        user.setSex(params.get("sex"));

       
        String roleIdStr = params.get("roleId");
        if (roleIdStr != null && !roleIdStr.isEmpty()) {
            try {
                user.setRoleId(new Role(Integer.valueOf(roleIdStr)));
            } catch (NumberFormatException ex) {
                
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, "Invalid roleId format", ex);
            }
        }
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        user.setAddress(params.get("address"));
        user.setExperience(Integer.parseInt(params.get("experience")));
        user.setFilecv(params.get("filecv"));
        user.setCurentposition(params.get("currentposition"));
        user.setEducation(params.get("education"));
        user.setCountry(params.get("country"));
        user.setUrlinfo(params.get("urlinfo"));

       
        this.userRepo.register(user);

        return user;
    }

>>>>>>> Stashed changes
}
