package com.hui.aop.proxy;

import com.hui.aop.interceptor.Interceptor;
import com.hui.aop.invocation.MyInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    /**
     * 绑定代理对象
     * @param target
     * @param interceptor
     * @return
     */
    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        // 保存被代理对象 target
        proxyBean.target = target;
        // 保存拦截器 interceptor
        proxyBean.interceptor = interceptor;
        // 生成代理对象
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, proxyBean);
        return proxyInstance;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行拦截器前置方法
        this.interceptor.before();
        MyInvocation myInvocation = new MyInvocation(target, method, args);
        boolean isError = false;
        Object result = null;
        try {
            // 检测是否要执行around方法
            if (this.interceptor.useAround()){
                // 通过拦截器触发原方法
                result = this.interceptor.around(myInvocation);
            }  else  {
                // 直接执行原方法
                result = method.invoke(target,args);
            }
            // 执行拦截器后置方法
            this.interceptor.after();
        } catch (Exception e){
            isError = true;
        }

        if (isError){
            // 方法执行后，发生异常时执行
            this.interceptor.afterThrowing();
        } else  {
            // 方法执行后，没有发生异常时执行
            this.interceptor.afterReturning();
        }
        return result;
    }
}
