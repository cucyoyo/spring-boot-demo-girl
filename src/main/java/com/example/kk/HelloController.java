package com.example.kk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    两种接收请求的方法二选一
    @GetMapping(value = "/hello")
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "hello nimeide spring boot!";
    }
}
