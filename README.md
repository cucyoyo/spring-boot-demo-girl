## spring boot 入门示例
- 参考：[慕课网：2小时学会Spring Boot](https://www.imooc.com/learn/767)
- 编辑器：IDEA （可以直接生成boot框架代码）
- demo主要内容：http请求方法(几种注解方法) + 数据库基本增删改查

- 进入目录后先把`mvn`相关的文件删掉


## 基础知识
### @value注解 - 从配置文件传值





## 踩坑 + 埋坑
- 以下横线之间的这些坑，都是因为java版本选错了导致的（注意java版本选择本地的java10，boot版本选择1.5.x，2.0.x还没试），否则直接就可以右键运行不报错了

---------------------
### 在IDEA中修改了pom.xml不能生效
在文件名称或文件打开内容上`右键->maven->reimport`

### 设置pom.xml自动reimport
![截图](./imgs/pom-auto-reimport.png)

### 可视化查看依赖关系
`窗口右侧->maven Project->右键 show dependencies`（这里可以查看依赖冲突）
或`View -> Tool Windows -> maven projects` 找到工具窗口

### logback 和 log4j 依赖冲突
去掉一个依赖
```$xslt
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

```
### log4j初始化错误
在resources目录下添加`log4j.properties`文件，内容如下
```
log4j.rootLogger=INFO, Console
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.layout=org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=(%r ms) [%t] %-5p: %c#%M %x: %m%n
```
-----------------------------