package com.example.springboot.service;

import com.example.springboot.dao.UserDto;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserDto userDto;

    public User selectByPrimaryKey(Long id){
        return userDto.selectByPrimaryKey(id);
    }

}
