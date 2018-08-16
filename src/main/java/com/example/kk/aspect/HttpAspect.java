package com.example.kk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Aspect
@Component // 把文件引入spring容器中去
public class HttpAspect {
//    @Before("execution(public * com.example.kk.controller.GirlController.*(..))") // 所有方法 请求前 拦截
//    public void doBefore() {
//        System.out.println("111111");
//    }
//
//    @After("execution(public * com.example.kk.controller.GirlController.*(..))") // 所有方法 请求后 拦截
//    public void doAfter() {
//        System.out.println("333");
//    }

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class); // 注意这里的logger别选错了 4j啥啥的

    // 以下代码等同于上面注释的代码，避免重复
    @Pointcut("execution(public * com.example.kk.controller.GirlController.*(..))") // 切点
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("1111");
//        logger.info("1111"); // erro

        // 获取请求的一些属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        System.out.println("333");
    }

    // 获取请求方法返回的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString()); // 注意使用tostring方法要在Girl类中添加toString方法,实际上这里不加.toString,由于Girl对象有了这个方法，在控制台也可以自动打出字符串格式
    }
}
