package com.personal.springcloud.service;

import com.personal.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
//@FeignClient(value = "microservicecloud-dept")   //开启Feign
@FeignClient(value = "microservicecloud-dept",fallbackFactory = DeptClientServiceFallBackFactory.class)   //当该接口的某一个方法服务异常使用DeptClientServiceFallBackFactory进行返回处理
public interface DeptClientService {
    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept);

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();
}
