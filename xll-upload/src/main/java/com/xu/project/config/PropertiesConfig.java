package com.xu.project.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/11/26 16:08
 * @Description: 配置属性类
 */
@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "xll.config")
@PropertySource(value = "classpath:/Param.properties")
public class PropertiesConfig {
    private String imageUrl;
}
