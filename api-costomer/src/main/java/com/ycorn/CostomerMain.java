package com.ycorn;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: wujianmin
 * @Date: 2020/3/13 15:11
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo
public class CostomerMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CostomerMain.class, args);
    }
}
