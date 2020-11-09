package com.hui.aop.aspect;

import com.hui.aop.service.HelloParamService;
import com.hui.aop.service.Impl.HelloParamServiceImpl;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 * 定义切面类
 */
@Aspect
@Component
public class MyAspect {
    /**
     * 引入其他接口
     */
    @DeclareParents(value = "com.hui.aop.service.Impl.HelloServiceImpl",defaultImpl = HelloParamServiceImpl.class)
    public HelloParamService helloParamService;
}
