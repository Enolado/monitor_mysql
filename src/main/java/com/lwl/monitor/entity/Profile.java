package com.lwl.monitor.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 接受测试语句
 * @author lwl
 * @create 2021/11/15 10:28
 */

public class Profile {
    /**
     * 接收测试的SQL语句
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
