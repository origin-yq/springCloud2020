package com.personal.springcloud.service;

import com.personal.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * //一旦调用服务方法失败并抛出错误信息后，会自动调用 @HystrixCommand 注解标注好的 fallbackMethod 调用类中的指定方法
 *     @HystrixCommand(fallbackMethod = "processHystrix_Get")
 *     在provider服务提供者使用@HystrixCommand熔断机制有一个弊端，就是每个方法都需要定义一个异常处理方法：比如processHystrix_Get，不仅代码冗余，而且异常处理模块和业务模块耦合性太高
 *     consumer客户端提供服务降级
 */
@Component  //该注解必须有，否则熔断异常处理不生效
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {

        return new DeptClientService(){

            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(Long id) {
                return new Dept().setDeptNo(id).setDeptName("该id：" + id + "没有对应的信息,consumer客户端提供的服务降级，此刻provider服务已关闭").setDb_source("no this database in MySQL");
            }

            public List<Dept> list() {
                return null;
            }
        };

    }
}
