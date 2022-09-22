package com.lwl.monitor.service.impl;

import com.lwl.monitor.entity.FileSummary;
import com.lwl.monitor.mapper.FileSummaryMapper;
import com.lwl.monitor.service.FileSummaryService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/17 16:10
 */
@Service
public class FileSummaryServiceImpl implements FileSummaryService{

    @Autowired
    private FileSummaryMapper fileSummaryMapper;

    /**
     * 获取事务管理器
     */
    @Autowired
    DataSourceTransactionManager manager;

    @Override
    public Map<String, List<FileSummary>> getFileSummaryMap() {
        //获取所有事件
        List<String> eventNameList = fileSummaryMapper.getEventNameList();
        List<String> fileNameList = fileSummaryMapper.getFileNameList();
        Double length = eventNameList.size() /0.75;
        Map<String,List<FileSummary>> map = new HashMap<>(length.intValue()+1);
        TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
        //编程式事务
        transactionTemplate.execute(status -> {
            fileNameList.forEach(fileName->{
                if(!StringUtils.isEmpty(fileName)){
                    map.put(fileName,new LinkedList<>());
                }
            });
            //流式查询
            try(Cursor<FileSummary> cursor = fileSummaryMapper.getFileSummaryCursor()){
                cursor.forEach(fileSummary -> {
                    fileNameList.forEach(fileName->{
                        if(fileName.equals(fileSummary.getFileName())){
                            map.get(fileName).add(fileSummary);
                        }
                    });
                });
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        });
        return map;
    }
}
