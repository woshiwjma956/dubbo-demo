package com.ycorn.service;

import com.ycorn.facade.FallbackTestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: wujianmin
 * @Date: 2020/3/13 17:13
 * @Function:
 * @Version 1.0
 */
@Service
public class FallbackService {

    @Reference(version = "1.0.0")
    FallbackTestService fallbackTestService;

    public String testFallbackWithHystrix(String name) {
        return fallbackTestService.fallback(name);
    }
}
