// 使用@Entity注解将girl对应数据库里的一张表
package com.example.kk.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {
    @Id
    @GeneratedValue // 配置id自增
    private Integer id;

    @NotBlank(message = "cupSize字段不能为空")
    private String cupSize;

    @Min(value = 18, message = "未成年少女")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

    @NotNull(message = "金额不能为空")
    private Double money;


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

    public Double getMoney() { return money; }

    public void setMoney() { this.money = money; }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
