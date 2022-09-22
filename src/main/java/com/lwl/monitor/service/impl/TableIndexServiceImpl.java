package com.lwl.monitor.service.impl;

import com.lwl.monitor.entity.TableIndex;
import com.lwl.monitor.mapper.TableIndexMapper;
import com.lwl.monitor.service.TableIndexService;
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
 * @create 2021/11/5 10:34
 */
@Service
public class TableIndexServiceImpl implements TableIndexService {

    @Autowired
    TableIndexMapper tableMapper;

    /**
     * 获取事务管理器
     */
    @Autowired
    DataSourceTransactionManager manager;

    @Override
    public Map<String, List<TableIndex>> getTableIndexMap() {
        Double length = tableMapper.getTableDigestCount() / 0.75;
        Map<String,List<TableIndex>> map = new HashMap<String,List<TableIndex>>( length.intValue()+1);
        //编程式事务
        TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
        transactionTemplate.execute(status -> {
            //获取数据库库名
            List<String> ObjectSchemaList = tableMapper.getObjectSchema();
            ObjectSchemaList.forEach(objectSchema->{
                //初始化map集合
                map.put(objectSchema,new LinkedList<>());
            });
            try(Cursor<TableIndex> cursor = tableMapper.getTableIndexCursor()){
                cursor.forEach(tableIndex -> {
                    ObjectSchemaList.forEach(schemaName->{
                        if(schemaName.equals(tableIndex.getObjectSchema())){
                            map.get(schemaName).add(tableIndex);
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
