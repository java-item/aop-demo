package com.hui.aop.interceptor.Impl;

import com.hui.aop.interceptor.Interceptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实现拦截器
 */
public class MyInterceptorIml implements Interceptor {
    @Override
    public boolean before() {
        System.out.println(" 执行拦截器方法-> before() ");
        return false;
    }

    @Override
    public void after() {
        System.out.println(" 执行拦截器方法-> after() ");
    }

    @Override
    public Object around(Object target, Method method, Object[] params) throws InvocationTargetException, IllegalAccessException {
        Object invoke = method.invoke(target, params);
        return " 结果二次处理--> " + invoke + " is good";
    }

    @Override
    public void afterReturning() {
        System.out.println(" 执行拦截器方法-> afterReturning()");
    }

    @Override
    public void afterThrowing() {
        System.out.println(" 执行拦截器方法-> afterThrowing()");
    }

    @Override
    public boolean useAround() {
        boolean d =  true;
        System.out.println(" 执行拦截器方法-> useAround(): "+ d);
        return d;
    }
}
