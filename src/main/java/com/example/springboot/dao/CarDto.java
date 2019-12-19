package com.example.springboot.dao;

import com.example.springboot.mapper.CarMapper;
import com.example.springboot.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDto {

    @Autowired
    private CarMapper carMapper;

    List<Car> selectByOwner(long ownerId){

        return carMapper.selectByOwner(ownerId);
    }



}
