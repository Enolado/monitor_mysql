package com.lwl.config.dynamicDataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lwl
 * @create 2022/9/25 13:02
 */
@ConfigurationProperties(prefix = "monitor")
@Data
public class MonitorProperties {
    private boolean enabled;

    private DataSource dataSource;

    @Data
    public static class DataSource {

        private Class<? extends javax.sql.DataSource> type;
        private String driverClassName;
        private String url;
        private String username;
        private String password;
    }
}
