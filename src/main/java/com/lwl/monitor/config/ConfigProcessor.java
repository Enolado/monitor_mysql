package com.lwl.monitor.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author lwl
 * @create 2022/9/25 14:30
 */

public class ConfigProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Object bean = beanFactory.getBean("webMvcProperties");
        System.out.println("bean = " + bean);
    }
}
