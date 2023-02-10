package com.example.vaultcloud.controller;

import com.example.vaultcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private TestService testService;

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String getSecret() {

//        return "Done, user: " + testService.getUserName() + ", password: " + testService.getPassword();
       return "Done, userName: " + environment.getProperty("userName") + ", password: " + environment.getProperty("password");
    }

}
