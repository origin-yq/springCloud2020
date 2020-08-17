package com.personal.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value ="com.personal.springcloud.dao" )
public class DeptConsumer80App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80App.class,args);
    }
}
