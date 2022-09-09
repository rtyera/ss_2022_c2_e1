package com.example.ss_2022_c2_e1.controllers;

import com.example.ss_2022_c2_e1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/demo")
    public String demo(){
        var u= SecurityContextHolder.getContext().getAuthentication();
        //u.getAuthorities().forEach(a-> System.out.println(a.getAuthority()));
        System.out.println(u.getPrincipal().toString());
        return "Hello!";
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDetailsManager.createUser(user);
    }
}
