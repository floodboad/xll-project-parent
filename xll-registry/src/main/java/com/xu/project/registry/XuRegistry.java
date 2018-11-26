package com.xu.project.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/18 21:58
 * @Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class XuRegistry {
    public static void main(String[] args) {
        SpringApplication.run(XuRegistry.class,args);
    }
}
