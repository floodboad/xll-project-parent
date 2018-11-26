package com.xu.project.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/18 22:52
 * @Description:
 */
@EnableDiscoveryClient
@MapperScan("com.xu.project.item.mapper")
@SpringBootApplication(scanBasePackages = {"com.xu.project"})
public class XuService {
    public static void main(String[] args) {
        SpringApplication.run(XuService.class,args);
    }
}
