// 接口类：使用jpa操作数据库
package com.example.kk;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> { // 这里要写上<类名, id类型>
    // 通过年龄查询数据
    public List<Girl> findByAge(Integer age);
}
