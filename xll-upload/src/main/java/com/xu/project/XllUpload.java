package com.xu.project;

import com.xu.project.config.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/20 18:55
 * @Description: 上传图片服务器
 */
@EnableDiscoveryClient
@EnableConfigurationProperties({PropertiesConfig.class})
@SpringBootApplication(scanBasePackages = {"com.xu.project"})
public class XllUpload {
    public static void main(String[] args) {
        SpringApplication.run(XllUpload.class);
    }
}
