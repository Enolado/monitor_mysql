package com.lwl.monitor.service.impl;

import com.lwl.monitor.entity.Threads;
import com.lwl.monitor.entity.Users;
import com.lwl.monitor.mapper.ThreadsMapper;
import com.lwl.monitor.mapper.UsersMapper;
import com.lwl.monitor.service.ThreadsService;
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
 * @create 2021/11/9 21:11
 */
@Service
public class ThreadsServiceImpl implements ThreadsService {

    @Autowired
    private ThreadsMapper threadsMapper;

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 获取事务管理器
     */
    @Autowired
    DataSourceTransactionManager manager;

    @Override
    public Map<String, List> getThreadsMap() {
        Double length = threadsMapper.getThreadsCount() / 0.75;
        //由于将连接用户也添加到map集合中，所以需要多加1
        Map<String,List> map = new HashMap<>(length.intValue()+2);
        //编程式事务
        TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
        transactionTemplate.execute(status -> {
            //获取连接用户
            List<Users> users = usersMapper.getAllConnections();
            map.put("usersConnectionDetail",users);
            users.forEach(user->{
                map.put(user.getUser(),new LinkedList());
            });
            try (Cursor<Threads> cursor = threadsMapper.getThreadsCursor()) {
                cursor.forEach(tableIndex -> {
                    map.get(tableIndex.getProcesslistUser()).add(tableIndex);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        return map;
    }
}
