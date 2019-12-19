package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Api("用户相关Api")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    @ApiOperation("一个测试接口")
    public void test(){
        System.out.println("Test get request!");
    }

/*    @ApiOperation("打印一个User对象")
    @PostMapping("printUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "userName",dataType = "string",required = true,value = "用户名")
    })
    @ApiResponses({
            @ApiResponse(code = 400,message = "参数错误")
    })
    public User printUser(@RequestBody User user){
        return user;
    }*/

    @ApiOperation("打印一个User对象")
    @PostMapping("selectUserById")
    @ApiResponses({
            @ApiResponse(code = 400,message = "参数错误")
    })
    public User selectUserById(@RequestBody User user){
        return userService.selectByPrimaryKey(user.getId());
    }

}
