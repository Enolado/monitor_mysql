package com.lwl.monitor.service;

import com.lwl.monitor.entity.Profile;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/15 11:05
 */
public interface ProfileService {

    /**
     * 测试SQL语句
     * @param profile
     * @return Map<String, Object>
     */
    Map<String, Object> profile(Profile profile);
}
