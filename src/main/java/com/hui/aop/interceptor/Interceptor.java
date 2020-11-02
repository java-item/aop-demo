package com.hui.aop.interceptor;



import com.hui.aop.invocation.MyInvocation;

import java.lang.reflect.InvocationTargetException;

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
     * 取代原有方法
     * @param invocation
     * @return Object
     * @throws InvocationTargetException
     * @throws IllegalAccessError
     */
    Object around(MyInvocation invocation) throws InvocationTargetException,IllegalAccessError,Exception;

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
