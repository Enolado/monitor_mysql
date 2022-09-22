package com.lwl.monitor.service;
import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/9 21:08
 */
public interface ThreadsService {

    /**
     * 查找连接线程和事件
     * @return Map<String,List>
     */
    Map<String,List> getThreadsMap();
}
