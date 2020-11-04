package com.hui.aop.service.Impl;

import com.hui.aop.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String str) {
        return str;
    }
}
