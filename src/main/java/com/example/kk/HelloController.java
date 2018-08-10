package com.example.kk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;

//    两种接收请求的方法二选一
    @GetMapping(value = "/hello")
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return content;
    }

    @GetMapping(value = "/kk")
    public String kk() {
        return cupSize + "dasdfsddfgfdsdfad";
    }
}
