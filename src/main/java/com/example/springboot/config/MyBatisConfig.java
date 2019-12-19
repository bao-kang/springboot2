package com.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment evn;

    @Bean
    public DataSource microservicedbDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName",evn.getProperty("db.jdbc.driverClassName"));
        props.put("url",evn.getProperty("db.jdbc.url"));
        props.put("username",evn.getProperty("db.jdbc.username"));
        props.put("password",evn.getProperty("db.jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {

        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);//指定数据源
        fb.setTypeAliasesPackage("com.example.springboot.model");//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));//指定xml位置
        return fb.getObject();
    }



}
