package com.ycorn.service;

import com.ycorn.facade.DemoService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: wujianmin
 * @Date: 2020/3/13 15:07
 * @Function:
 * @Version 1.0
 */
@Service
public class TestService {
    /**
     * version: 支持多版本
     * retries: 除去第一次调用失败之后再,重试三次
     * loadbalance:  负载均衡策略 org.apache.dubbo.rpc.cluster.LoadBalance
     */
    @Reference(version = "1.0.0", retries = 3, loadbalance = "roundrobin",
            methods = {
                    @Method(name = "sayHello", retries = 2, loadbalance = "leastactive")
            })
    DemoService demoService;

    public String test(String name) {
        return demoService.sayHello(name);
    }
}
