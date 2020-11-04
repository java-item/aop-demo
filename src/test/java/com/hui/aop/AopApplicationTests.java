package com.hui.aop;

import com.hui.aop.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AopApplicationTests {
    @Resource
    private HelloService helloService;
    @Test
    void contextLoads() {
        String java = helloService.hello("Java");
        System.out.println("result -->" + java);
    }

}
