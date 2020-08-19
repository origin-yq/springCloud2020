package com.personal.springcloud.cfgBeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   // 客户端的负载均衡,我们使用RestTemplate调用服务，通过@LoadBalanced注解[负载均衡]实现RestTemplate算法调用服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
