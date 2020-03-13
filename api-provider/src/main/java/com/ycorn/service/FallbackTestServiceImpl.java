package com.ycorn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ycorn.facade.FallbackTestService;
import io.netty.util.internal.ThreadLocalRandom;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: wujianmin
 * @Date: 2020/3/13 17:07
 * @Function:
 * @Version 1.0
 */
@Service(version = "1.0.0")
public class FallbackTestServiceImpl implements FallbackTestService {

    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public String fallback(String name) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            int i = 1 / 0;
        }
        return "hello " + name;
    }

    public String hystrixFallback(String name) {
        return name + " = hystrixFallback";
    }
}
