package com.personal.springcloud.dao;

import com.personal.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
@Repository   //@Mapper 这两个注解作用一样，想要生效，能够被注入为bean，需要在启动类添加@MapperScan注解
public interface DeptDao{
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
