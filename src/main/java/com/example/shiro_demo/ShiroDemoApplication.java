package com.example.shiro_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 10322
 */
@SpringBootApplication
@MapperScan("com.example.shiro_demo.mapper")
@ComponentScan(basePackages = "com.example.shiro_demo.*")
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }

}
