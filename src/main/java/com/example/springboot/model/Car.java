package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {
    private Long id;

    private String name;

    private String color;

    private Long owner;

}