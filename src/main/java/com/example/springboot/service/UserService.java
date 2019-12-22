package com.example.springboot.service;

import com.example.springboot.dao.CarDto;
import com.example.springboot.dao.UserDto;
import com.example.springboot.model.Car;
import com.example.springboot.model.User;
import com.example.springboot.model.UserAndCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserDto userDto;

    @Autowired
    private CarDto carDto;

    public User selectByPrimaryKey(Long id){
        return userDto.selectByPrimaryKey(id);
    }

    public UserAndCar getUserAndCar(Long userId){

        UserAndCar userAndCar = new UserAndCar();
        User user = userDto.selectByPrimaryKey(userId);
        if(user != null){
            List<Car> cars = carDto.selectByOwner(userId);
            userAndCar.setId(user.getId());
            userAndCar.setName(user.getName());
            userAndCar.setPhone(user.getPhone());
            userAndCar.setCarList(cars);
        }
        return userAndCar;
    }

}
