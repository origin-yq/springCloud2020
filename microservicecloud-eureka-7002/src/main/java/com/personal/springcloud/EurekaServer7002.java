package com.personal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //开启 eureka-server
public class EurekaServer7002 {

    public static void main(String[] args){
        SpringApplication.run(EurekaServer7002.class,args);
    }
}
