// controller的hello world Demo
package com.example.kk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // = Controller + ResponseBody
@RequestMapping(value = "/hello") // 整个类的url加一个前缀
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}") // 从配置文件中注入值
    private String content;

    @Autowired //对@Value注解的优化
    private GirlProperties girlProperties;

    // 两种接收请求的方法二选一
//    @PostMapping(value = "/say")
    @GetMapping(value = "/say")
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return content;
    }

    @GetMapping(value = "/say1/{id}")
    public String say1(@PathVariable("id") Integer id) {
        return "id:" + id;
    }
    @GetMapping(value = "/{id}/say2")
    public String say2(@PathVariable("id") Integer id) {
        return "id:" + id;
    }
    @GetMapping(value = "/say3") // 处理这样的参数 /say3?id=2
    public String say3(@RequestParam("id") Integer sayid) {
        return "id:" + sayid;
    }

    @GetMapping(value = "/say4") // 处理这样的参数 /say3?id=2
    public String say4(@RequestParam(value = "id", required = false, defaultValue = "0") Integer sayid) {
        return "id:" + sayid;
    }

    @GetMapping(value = "/autogirl")
    public String autogril() {
        return girlProperties.getCupSize();
    }
}
