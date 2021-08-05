package com.aop.controller;

import com.aop.annotation.AopAnnotation;
import com.aop.common.Response;
import com.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/10 10:01
 */
@RestController
@RequestMapping("/aops")
public class AopController {

    @Autowired
    private AopService aopService;

    @GetMapping("/getStr")
    public Response<String> getStr() throws Exception{
        List<String> list = new ArrayList<>();
        return Response.success(aopService.getStr("2342",1,2));
    }

    @GetMapping("/getStr1")
    public Response<String> getStr1() throws Exception{
        List<String> list = new ArrayList<>();
        return Response.success(aopService.getStr("2342",1,2));
    }
}
