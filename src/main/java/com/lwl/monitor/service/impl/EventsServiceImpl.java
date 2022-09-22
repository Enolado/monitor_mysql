package com.lwl.monitor.service.impl;

import com.lwl.monitor.entity.EventsDigest;
import com.lwl.monitor.mapper.EventsMapper;
import com.lwl.monitor.service.EventsService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/10/26 20:37
 */
@Service
public class EventsServiceImpl implements EventsService  {

    @Autowired
    EventsMapper eventsMapper;

    /**
     * 获取事务管理器
     */
    @Autowired
    DataSourceTransactionManager manager;

    @Override
    public Map<String,List<EventsDigest>> getEventsDigestMap() {
         //HashMap初始化长度定义(尽量定义),=>需要的容量/负载因子(0.75)+1,因为扩容是在插入后进行的，加一减少额外一次扩容
        Double length = eventsMapper.getEventsDigestCount() / 0.75;
        Map<String,List<EventsDigest>> map = new HashMap<String,List<EventsDigest>>( length.intValue()+1);
        TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
        //编程式事务
        transactionTemplate.execute(status->{
            //获取数据库库名
            List<String> schemaNameList = eventsMapper.getSchemaNames();
            schemaNameList.forEach(schemaName->{
                //初始化
                map.put(schemaName,new LinkedList<>());
            });
            //流式查询
            try(Cursor<EventsDigest> cursor = eventsMapper.getEventsDigestCursor()){
                cursor.forEach(digest->{
                    schemaNameList.forEach(schemaName -> {
                        if(schemaName.equals(digest.getSchemaName())){
                            //根据数据库名进行分类
                            map.get(schemaName).add(digest);
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

    @Override
    public List<String> getAllDataBases() {
        return eventsMapper.getAllDataBases();
    }
}
