package com.example.springboot.dao;

import com.example.springboot.config.DataBaseType;
import com.example.springboot.config.DatabaseContextHolder;
import com.example.springboot.mapper.CarMapper;
import com.example.springboot.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDto {

    @Autowired
    private CarMapper carMapper;

    public List<Car> selectByOwner(long ownerId){

        DatabaseContextHolder.setDataBaseType(DataBaseType.microservicedb2);
        return carMapper.selectByOwner(ownerId);
    }



}
