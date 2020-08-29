package com.personal.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value ="com.personal.springcloud.dao" )
@EnableEurekaClient //服务启动后注册到eureka服务中[相当于客户端连接到服务端即C/S架构]
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker  //对hystrix熔断机制的支持
public class DeptProviderHystrix8081App {
    public static void main(String[] args){
        SpringApplication.run(DeptProviderHystrix8081App.class,args);
    }
}
