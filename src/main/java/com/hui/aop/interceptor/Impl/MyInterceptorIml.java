package com.hui.aop.interceptor.Impl;

import com.hui.aop.interceptor.Interceptor;
import com.hui.aop.invocation.MyInvocation;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * 实现拦截器
 */
public class MyInterceptorIml implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("拦截器->方法执行前.....");
        return false;
    }

    @Override
    public void after() {
        System.out.println("拦截器->方法执行后.....");
    }

    @Override
    public Object around(MyInvocation invocation) throws InvocationTargetException, IllegalAccessError,Exception
    {
        System.out.println("拦截器->around 执行前.... ");
        Object process = "拦截器处理后结果 + " + invocation.process();
        System.out.println("拦截器->around 执行后.... ");
        return process;
    }

    @Override
    public void afterReturning() {
        System.out.println("拦截器->afterReturning .... ");
    }

    @Override
    public void afterThrowing() {
        System.out.println("拦截器->afterThrowing .... ");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
