package com.lwl.monitor.service;

import com.lwl.monitor.entity.EventsDigest;

import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/10/26 20:37
 */
public interface EventsService {

    /**
     * 查询SQL语句的执行次数
     * @return Map<String,List<EventsDigest>>
     */
    Map<String,List<EventsDigest>> getEventsDigestMap();

    /**
     * 查询mysql下的所有数据库
     * @return List<String>
     */
    List<String> getAllDataBases();
}
