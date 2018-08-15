// @Controller + @ResponseBody 结合使用的一个demo，这两个注解结合相当于RestController
package com.example.kk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
public class ControllerDemo {
    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/helloC", "/hiC"})
    public String helloC() {
        return girlProperties.getCupSize();
//        return "index";
    }
}
