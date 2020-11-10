package com.hui.aop;

import com.hui.aop.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
@SpringBootTest
class AopApplicationTests {
    @Resource
    private HelloService helloService;
    @Test
    void contextLoads() {
         helloService.hello("测试多个切面");
    }
}
