package com.example.springboot.controller;

import com.example.springboot.model.UserAndCar;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("db")
@RestController
public class DbAndCacheController {

    @Resource
    private UserService userService;

    @PostMapping("getUserAndCar")
    public UserAndCar getUserAndCar(@RequestParam("id") long id){
        return userService.getUserAndCar(id);
    }

}
