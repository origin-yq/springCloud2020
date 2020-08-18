package com.personal.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * springboot启动时会自动注入数据源和配置jpa,如果spring配置文件没有添加数据库连接信息的配置会发生下面的报错信息
 *
 * Description:
 *
 * Cannot determine embedded database driver class for database type NONE
 *
 * Action:
 *
 * If you want an embedded database please put a supported one on the classpath.
 * If you have database settings to be loaded from a particular profile you may need to active it (no profiles are currently active).
 * 解决办法：在@SpringBootApplication中排除其注入
 * @SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
 *
 * 但是如果配置了数据库连接信息，去掉@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})，还是会报上面的错
 * 解决方法：pom依赖里加上即可，原理为止
 * <dependency>
 *             <groupId>com.h2database</groupId>
 *             <artifactId>h2</artifactId>
 *             <scope>runtime</scope>
 *  </dependency>
 */
@SpringBootApplication
@MapperScan(value ="com.personal.springcloud.dao" )
@EnableEurekaClient //服务启动后注册到eureka服务中[相当于客户端连接到服务端即C/S架构]
@EnableDiscoveryClient //服务发现
public class DeptProvider8081App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8081App.class,args);
    }
}
