package com.example.springboot.dao;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDto  {

    @Autowired
    private UserMapper userMapper;

    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

}
