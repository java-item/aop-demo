package com.hui.aop.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 定义切面类
 */
@Aspect
@Component
public class MyAspect {
    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.hui.aop.service.Impl.HelloServiceImpl.hello(..))")
    public void pointCut(){}

    /**
     * 前置通知
     */
    @Before("pointCut()")
    public void before(){
        System.out.println("MyAspect --> before");
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String argsString = Arrays.toString(proceedingJoinPoint.getArgs());
        System.out.println("MyAspect --> around-before " + argsString);
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("MyAspect --> around-after ");
        return  proceed;
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("MyAspect --> after");
    }


    /**
     * 事后返回
     * @param joinPoint
     */
    @AfterReturning("pointCut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("MyAspect --> afterReturning");
    }

    /**
     * 异常
     * @param joinPoint
     */
    @AfterThrowing("pointCut()")
    public void afterThrow(JoinPoint joinPoint){
        System.out.println("MyAspect --> afterThrow");
    }

}
