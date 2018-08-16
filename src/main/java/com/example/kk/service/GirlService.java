// 事务
package com.example.kk.service;

import com.example.kk.domain.Girl;
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
}
