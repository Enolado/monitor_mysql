package com.lwl.monitor.service;

import com.lwl.monitor.entity.EventsDigest;
import com.lwl.monitor.entity.TableIndex;

import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/5 10:34
 */
public interface TableIndexService {

    /**
     * 查询各表索引
     * @return Map<String,List<TableIndex>>
     */
    Map<String,List<TableIndex>> getTableIndexMap();
}
