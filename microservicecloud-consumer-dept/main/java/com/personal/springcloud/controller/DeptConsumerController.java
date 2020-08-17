package com.personal.springcloud.controller;

import com.personal.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    private static final String REST_URL_PREFIX = "http://localhost:8081/";
    /**
     * url , 请求参数 ，返回封装类
     * postForObject(URI var1, Object var2, Class<T> var3)
     */
    @Autowired
    public RestTemplate restTemplate;

    @PostMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add" , dept , Boolean.class);
    }

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id , Dept.class);
    }

    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list" , List.class);
    }
}
