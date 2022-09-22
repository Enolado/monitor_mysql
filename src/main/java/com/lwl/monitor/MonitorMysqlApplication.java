package com.lwl.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lwl
 * @create 2021/10/26 16:41
 */
@SpringBootApplication
@MapperScan("com.lwl.monitor.mapper")
public class MonitorMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorMysqlApplication.class, args);
    }

}
