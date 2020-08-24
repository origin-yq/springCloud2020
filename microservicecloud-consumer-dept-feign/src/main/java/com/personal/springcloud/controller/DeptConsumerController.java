package com.personal.springcloud.controller;

import com.personal.springcloud.entities.Dept;
import com.personal.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    public DeptClientService deptClientService;

    @PostMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable(value = "id") Long id) {
        return deptClientService.get(id);
    }

    @GetMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.list();
    }
}
