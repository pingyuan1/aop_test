package com.aop.controller;

import com.aop.common.Response;
import com.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/7/6 17:05
 */
@RestController
@RequestMapping("/handler1")
public class HandlerController {

    @Autowired
    private AopService aopService;

    @GetMapping("/getStr")
    public Response<String> getStr() throws Exception{
        return Response.success(aopService.getStr("2342",1,2));
    }
}
