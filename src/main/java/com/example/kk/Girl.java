package com.example.kk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Girl {
    @Id
    @GeneratedValue // 配置id自增
    private Integer id;
    private String cupSize;
    private Integer age;

    // alt + insert 添加构造方法，必须选择无参的
    public Girl() {
    }

    // alt + insert 生成get set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
