package com.hui.aop;

import com.hui.aop.interceptor.Impl.MyInterceptorIml;
import com.hui.aop.proxy.ProxyBean;
import com.hui.aop.service.DemoService;
import com.hui.aop.service.Impl.DemoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {


    @Test
    void contextLoads() {
        DemoService proxyBean = (DemoService) ProxyBean.getProxyBean(new DemoServiceImpl(), new MyInterceptorIml());
        System.out.println(proxyBean.hello("Java"));
    }

}
