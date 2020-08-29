package com.personal.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.personal.springcloud.entities.Dept;
import com.personal.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    //一旦调用服务方法失败并抛出错误信息后，会自动调用 @HystrixCommand 注解标注好的 fallbackMethod 调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable(value = "id") Long id) {
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("该id：" + id + "没有对应的信息");
        }
        return dept;
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    public Dept processHystrix_Get(@PathVariable(value = "id") Long id){
        return new Dept().setDeptNo(id).setDeptName("该id：" + id + "没有对应的信息,null --->@HystrixCommand").setDb_source("no this database in MySQL");
    }
}
