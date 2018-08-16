// 单元测试，右键run test运行
package com.example.kk.service;

import com.example.kk.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {


    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(14);
        Assert.assertEquals(new Integer(22), girl.getAge());

    }
}