package com.ycorn.controller;

import com.ycorn.service.FallbackService;
import com.ycorn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujianmin
 * @Date: 2020/3/13 15:08
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/rpc")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private FallbackService fallbackService;

    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return testService.test(name);
    }


    @GetMapping("/fallback")
    public String fallback(@RequestParam("name") String name){
        return fallbackService.testFallbackWithHystrix(name);
    }
}
