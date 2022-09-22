package com.lwl.monitor.service;

import com.lwl.monitor.entity.FileSummary;

import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/17 16:10
 */
public interface FileSummaryService {

    /**
     * 获取事件物理I/O详细
     * @return Map<String, List<FileSummary>>
     */
    Map<String, List<FileSummary>> getFileSummaryMap();
}
