package com.personal.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.personal.springcloud"})  //使用feign
public class DeptConsumerFeignApp {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumerFeignApp.class,args);
    }
}
