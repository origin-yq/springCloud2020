package com.personal.springcloud.cfgBeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   // 客户端的负载均衡[默认是轮询RoundRobinRule()],我们使用RestTemplate调用服务，通过@LoadBalanced注解[负载均衡]实现RestTemplate算法调用服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //当我们显示申明了负载均衡的算法，则会覆盖掉默认的轮询算法
    @Bean
    public IRule myRule(){
        return new RandomRule();   //负载均衡的又一种算法：随机
    }
}
