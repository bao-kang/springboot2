package com.example.springboot.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserAndCar extends User{

    @ApiModelProperty("车")
    private List<Car> carList;


}
