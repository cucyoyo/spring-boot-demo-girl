// 调用数据库里的girl的jpa接口类，通过网络请求controller展示调用jpa接口的效果
package com.example.kk.controller;

import com.example.kk.domain.Girl;
import com.example.kk.domain.Result;
import com.example.kk.repository.GirlRepository;
import com.example.kk.service.GirlService;
import com.example.kk.utils.ResultUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class GirlController {
    // 做数据库操作，要新建一个接口类，并调用它
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    // 查询女生列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        System.out.println("2222");
        return girlRepository.findAll();
    }

    // 添加女生 + 进阶篇（表单验证）
    @PostMapping(value = "/girl")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                          @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }

    // 以下是可以简化获取参数的写法
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) { // valid注解用于表单验证, BindingResult用于获取验证的结果
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println("2222");
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    // 更新一个女生
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    // 删除一个女生
    @DeleteMapping(value = "/girl/{id}")
    public String girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
        return "delete done!";
    }

    // 通过年龄查询女生
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlsByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    // 插入两个女生
    @PostMapping(value = "/girl/two")
    public String girlTwo() {
        girlService.insertTwo();
        return "插入两条数据";
    }

    // 统一异常处理
    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
