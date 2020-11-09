package com.hui.aop;

import com.hui.aop.service.HelloParamService;
import com.hui.aop.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AopApplicationTests {
    @Resource
    private HelloService helloService;
    @Test
    void contextLoads() {
        List<String> paramList = Arrays.asList("Java", null);
        paramList.forEach(s -> {
            HelloParamService helloParamService = (HelloParamService) helloService;
            if (helloParamService.checkParam(s)) {
                System.out.println("result -->" +  helloService.hello(s));
            }
        });
    }
}
