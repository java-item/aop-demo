package com.hui.aop.service.Impl;

import com.hui.aop.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String str) {
        return str;
    }
}
