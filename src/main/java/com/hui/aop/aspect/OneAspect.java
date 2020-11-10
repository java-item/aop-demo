package com.hui.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // 定义切面顺序
public class OneAspect {
    @Pointcut("execution(* com.hui.aop.service.Impl.HelloServiceImpl.hello(..))")
    public void point(){}

    @Before("point()")
    public void before(){
        System.out.println("OneAspect --> Before");
    }

    @After("point()")
    public void after(){
        System.out.println("OneAspect --> after");
    }
}
