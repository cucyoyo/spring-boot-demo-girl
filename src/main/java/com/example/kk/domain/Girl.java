// 使用@Entity注解将girl对应数据库里的一张表
package com.example.kk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Girl {
    @Id
    @GeneratedValue // 配置id自增
    private Integer id;
    private String cupSize;

    @Min(value = 18, message = "未成年少女")
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
