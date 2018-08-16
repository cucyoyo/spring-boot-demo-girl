// 事务
package com.example.kk.service;

import com.example.kk.domain.Girl;
import com.example.kk.enums.ResultEnum;
import com.example.kk.exception.GirlException;
import com.example.kk.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional // 数据库事务的注解，要么全部执行，要么全部不执行（遇到错误以后回滚）
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(22);
        girlA.setCupSize("C");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(22);
        girlB.setCupSize("Cc");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 12) {
//            throw  new Exception("可能在上小学"); // 捕获到的异常在"/handler/ExceptionHandler中处理"
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);

        } else if (age >= 12 && age < 16) {
//            throw new Exception("可能在上初中");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    // 用于单元测试，在方法名上右键，goto->test->create
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id); // 注意这里是findOne而不是getOne,总写错
    }
}
