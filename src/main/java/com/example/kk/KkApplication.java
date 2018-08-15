// 项目启动入口类，对于spring boot项目，应该使用@SpringBootApplication注解
package com.example.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KkApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkApplication.class, args);
    }
}
