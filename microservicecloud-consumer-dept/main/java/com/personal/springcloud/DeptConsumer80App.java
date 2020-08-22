package com.personal.springcloud;

import com.personal.MyIRule.MySelIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务的时候去加载我们自定义的Ribbon配置类，从而使配置生效，即 该注解会使用自定义的ribbon算法实现负载均衡
//name 表示针对哪个微服务使用自定义ribbon算法， configuration 表示自定义ribbon规则配置类
@RibbonClient(name="microservicecloud-dept",configuration = MySelIRule.class)
public class DeptConsumer80App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80App.class,args);
    }
}
