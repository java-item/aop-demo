package com.hui.aop.service.Impl;

import com.hui.aop.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void hello(String str) {
        System.out.println(str);
    }
}
