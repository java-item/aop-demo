package com.hui.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // 定义切面顺序
public class TwoAspect {
    @Pointcut("execution(* com.hui.aop.service.Impl.HelloServiceImpl.hello(..))")
    public void point(){}


    @Before("point()")
    public void before(){
        System.out.println("TwoAspect --> Before");
    }

    @After("point()")
    public void after(){
        System.out.println("TwoAspect --> after");
    }
}
