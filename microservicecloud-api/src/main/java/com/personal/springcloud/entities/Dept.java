package com.personal.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@SuppressWarnings("serial")  //忽略警告
@NoArgsConstructor   //无参构造函数
@AllArgsConstructor  //全参构造
@Data //set**/get**方法   //想要生效，必须安装lombok插件
@Accessors(chain = true)  //列式访问
public class Dept implements Serializable {

    private Long deptNo;   //主键
    private String deptName; // 部门名称
    private String db_source; //来自于哪一个数据库，微服务中同一个信息可能被储存到不同数据库中
    /*public void test(){
        Dept dept = new Dept();
        dept.setDeptName("").setDeptNo(1L).setDb_source("");   //这就是所谓的列式访问
    }*/
}
