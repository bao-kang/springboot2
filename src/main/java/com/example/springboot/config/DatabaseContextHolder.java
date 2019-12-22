package com.example.springboot.config;

public class DatabaseContextHolder {
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();

    public static void setDataBaseType(DataBaseType type){
        contextHolder.set(type);
    }

    public static DataBaseType getDataBaseType(){
        return contextHolder.get();
    }
}
