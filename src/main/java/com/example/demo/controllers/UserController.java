package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RequestMapping(value = "/user")
@RestController
public class UserController {
    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    User register(@RequestBody User user) {
        if (userRepository.existsByEmail (user.getEmail ()))
            return null;
        return userRepository.save (user);
    }


    @GetMapping("/login")
    User login(@RequestParam Map<String, String> userInfo) {
        if (userInfo.containsKey ("email") && userInfo.containsKey ("password")) {
            if (userRepository.existsByEmail (userInfo.get ("email")))
                return userRepository.findByEmailAndPassword (userInfo.get ("email"),
                        userInfo.get ("password"));
            return null;
        }
        return null;
    }

}
