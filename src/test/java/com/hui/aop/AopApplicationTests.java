package com.hui.aop;

import com.hui.aop.interceptor.Impl.MyInterceptorIml;
import com.hui.aop.proxy.ProxyBean;
import com.hui.aop.service.HelloService;
import com.hui.aop.service.Impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {
    @Test
    void contextLoads() {
        HelloService proxyBean = (HelloService) ProxyBean.getProxyBean(new HelloServiceImpl(), new MyInterceptorIml());
        System.out.println(proxyBean.hello("Java"));
    }

}
