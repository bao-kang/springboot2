package com.example.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("用户")
public class User {


    @ApiModelProperty("用户ID")
    private Long id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("手机号")
    private String phone;

}