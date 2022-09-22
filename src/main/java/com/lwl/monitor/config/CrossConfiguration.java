/*
package com.lwl.monitor.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * 跨域配置
 * @author lwl
 * @create 2021/10/28 10:20
 *//*

@Configuration
public class CrossConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许远程访问的域名
                .allowedOrigins("http://localhost:8089")
                //允许请求的方法("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                //允许请求头
                .allowedHeaders("*");
    }
}
*/
