package com.hui.aop.service.Impl;

import com.hui.aop.service.HelloParamService;
import org.springframework.stereotype.Service;

@Service
public class HelloParamServiceImpl implements HelloParamService {
    @Override
    public Boolean checkParam(String str) {
        System.out.println("引入增强接口 = " + str);
        return str != null;
    }
}
