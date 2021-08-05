package com.aop.service.Impl;

import com.aop.annotation.AopAnnotation;
import com.aop.service.AopService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/10 10:00
 */
@Service
public class AopServiceImpl implements AopService {

    @Override
    public String getStr(String code,int a,Integer b) throws InterruptedException {
        String flag = "";
        for (int i=0;i<10000;i++){
            b=i;
        }
        Thread.sleep(2000);
        return "success";
    }

}
