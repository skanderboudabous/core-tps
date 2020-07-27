package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping(value = "/user")
@RestController
public class UserController {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    User register(@RequestBody User user) {
        if (userRepository.existsByEmail (user.getEmail ()))
            return null;
        user.setPassword (passwordEncoder.encode (user.getPassword ()));
        return userRepository.save (user);
    }


    @GetMapping("/login")
    User login(@RequestParam Map<String, String> userInfo) {
        if (userInfo.containsKey ("email") && userInfo.containsKey ("password")) {
            if (userRepository.existsByEmail (userInfo.get ("email")))
                return userRepository.findByEmailAndPassword (userInfo.get ("email"),
                        passwordEncoder.encode (userInfo.get ("password")));
            return null;
        }
        return null;
    }

}
