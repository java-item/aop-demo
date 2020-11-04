package com.hui.aop.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 定义拦截器
 */
public interface Interceptor {
    /**
     * 前置方法
     */
    boolean before();

    /**
     * 后置方法
     */
    void after();

    /**
     * 代理原有方法
     * @param target
     * @param method
     * @param params
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Object target, Method method, Object[] params) throws InvocationTargetException, IllegalAccessException;

    /**
     * 方法执行后，没有发生异常时执行
     */
    void afterReturning();

    /**
     * 方法执行后，发生异常时执行
     */
    void afterThrowing();

    /**
     * 是否使用around方法取代原有方法
     */
    boolean useAround();
}
