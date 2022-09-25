package com.lwl.config;


import com.lwl.config.dynamicDataSource.MonitorProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lwl
 * @create 2022/9/25 13:07
 */
@Configuration
@ConditionalOnProperty(prefix = "monitor", value = "enabled", havingValue = "true")
@EnableConfigurationProperties(MonitorProperties.class)
@MapperScan(basePackages = MonitorAutoConfiguration.PACKAGE, sqlSessionFactoryRef = "MonitorSqlSessionFactory")
public class MonitorAutoConfiguration implements BeanClassLoaderAware {

    static final String PACKAGE = "com.lwl.monitor.mapper";

    private String className;
    private String url;
    private String user;
    private String password;
    private ClassLoader classLoader;

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public MonitorAutoConfiguration(MonitorProperties monitorProperties) {
        this.className = monitorProperties.getDataSource().getDriverClassName();
        this.url = monitorProperties.getDataSource().getUrl();
        this.user = monitorProperties.getDataSource().getUsername();
        this.password = monitorProperties.getDataSource().getPassword();
    }

    @Bean(name = "monitorDataSource")
    public DataSource MonitorDataSource() {
        DataSource dataSource = DataSourceBuilder.create(getClassLoader())
                .driverClassName(className)
                .url(url)
                .username(user)
                .password(password)
                .build();
        return dataSource;
    }

    @Bean(name = "monitorTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(MonitorDataSource());
    }

    @Bean(name = "MonitorSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("monitorDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        return sessionFactory.getObject();
    }

}
