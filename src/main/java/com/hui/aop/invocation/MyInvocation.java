package com.hui.aop.invocation;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Data
public class MyInvocation {
    /**
     * 参数
     */
    private Object[] params;
    /**
     * 保存原有方法
     */
    private Method method;
    private Object target;

    /**
     * 构造器
     * @param target
     * @param method
     * @param params
     */
    public MyInvocation(Object target, Method method,Object[] params){
        this.target = target;
        this.method = method;
        this.params = params;
    }

    /**
     * 通过反射执行原有方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessError
     * @throws IllegalAccessException
     */
    public Object process() throws InvocationTargetException, IllegalAccessError, IllegalAccessException {
        return method.invoke(target,params);
    }
}
