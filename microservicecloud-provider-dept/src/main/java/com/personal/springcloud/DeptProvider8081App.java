package com.personal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Description:
 *
 * Cannot determine embedded database driver class for database type NONE
 *
 * Action:
 *
 * If you want an embedded database please put a supported one on the classpath.
 * If you have database settings to be loaded from a particular profile you may need to active it (no profiles are currently active).
 * 解决该报错是排除默认的数据源配置 exclude = {DataSourceAutoConfiguration.class}
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DeptProvider8081App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8081App.class,args);
    }
}
