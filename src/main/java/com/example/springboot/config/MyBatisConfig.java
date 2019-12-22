package com.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment evn;

    @Bean
    public DataSource microservicedb1DataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName",evn.getProperty("db.jdbc.driverClassName"));
        props.put("url",evn.getProperty("db.jdbc.url"));
        props.put("username",evn.getProperty("db.jdbc.username"));
        props.put("password",evn.getProperty("db.jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource microservicedb2DataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName",evn.getProperty("db2.jdbc.driverClassName"));
        props.put("url",evn.getProperty("db2.jdbc.url"));
        props.put("username",evn.getProperty("db2.jdbc.username"));
        props.put("password",evn.getProperty("db2.jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("microservicedb1DataSource") DataSource microservicedb1DataSource,
                                        @Qualifier("microservicedb2DataSource") DataSource microservicedb2DataSource){
        Map<Object,Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataBaseType.microservicedb1,microservicedb1DataSource);
        targetDataSources.put(DataBaseType.microservicedb2,microservicedb2DataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(microservicedb1DataSource);

        return dataSource;

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
