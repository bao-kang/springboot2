/*
package com.example.springboot.config;


import com.example.springboot.dao.CarDto;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    @Before("execution(* com.example.springboot.dao.*.*(..))")
    public void setDataSourceKey(Joinpoint joinpoint){
        if(joinpoint instanceof CarDto){
            DatabaseContextHolder.setDataBaseType(DataBaseType.microservicedb2);

        }
    }

}
*/
