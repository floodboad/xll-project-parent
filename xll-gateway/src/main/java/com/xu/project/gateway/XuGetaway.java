package com.xu.project.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/18 22:13
 * @Description:
 */
@EnableZuulProxy
@SpringCloudApplication
public class XuGetaway {
    public static void main(String[] args) {
        SpringApplication.run(XuGetaway.class);
    }
}
