/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.User;
import com.oujava.service.UserService;
<<<<<<< Updated upstream
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerCandidate")
    public ResponseEntity<String> registerCandidate(@RequestBody User user) {
        userService.registerCandidate(user);
        return new ResponseEntity<>("register success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String input, String password) {

        User user = userService.login(input, password);

<<<<<<< Updated upstream
         if (user != null) {
        return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Đăng nhập thất bại", HttpStatus.UNAUTHORIZED);
    }  
=======
        if (user != null) {
            return new ResponseEntity<>("login success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("login fail", HttpStatus.UNAUTHORIZED);
        }
>>>>>>> Stashed changes
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<String> register(@RequestBody Map<String, String> params,MultipartFile avatar) {
        
       
        User u =  userService.register(params, avatar);

        if (u != null) {
            // Đăng ký thành công, bạn có thể trả về thông báo hoặc thông tin người dùng đã đăng ký
            return new ResponseEntity<>("Đăng ký thành công", HttpStatus.OK);
        } else {
            // Đăng ký không thành công, bạn có thể trả về thông báo lỗi hoặc mã lỗi tùy ý
            return new ResponseEntity<>("Đăng ký thất bại", HttpStatus.BAD_REQUEST);
        }
    }
   
}
