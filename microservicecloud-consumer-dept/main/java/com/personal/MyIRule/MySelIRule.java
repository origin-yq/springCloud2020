package com.personal.MyIRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的ribbon规则配置类不能放在@ComponentScan注解所扫描的当前包下及子包，否则该规则将被所有的ribbon客户端所共享，也就达不到我们特所化目的了
 */
@Configuration
public class MySelIRule {

    @Bean
    public IRule myRule(){
        //return new RandomRule();   //负载均衡的又一种算法：随机
        //return new RetryRule();   //重试算法：当服务的实例都正常，那么该算法和轮询算法一样，每个实例服务依次调用；当某一个实例宕机，那么它会重试，重试几次后，如果还是宕机状态，那么它就会在存活的正常实例中依次调用
        //new RandomRule();  //官方轮询算法：每个服务调用一次
        return new RandomRule_YQ();  //自定义的轮询算法
    }
}
