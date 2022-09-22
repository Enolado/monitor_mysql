package com.lwl.monitor.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;


/**
 * 获取DruidDataSource的Connection
 * @author lwl
 * @create 2021/11/15 21:24
 */
@Component
public class ConnectionUtil {

    private ConnectionUtil(){

    }

    private static ConnectionUtil connectionUtil = null;

    @Autowired
    private DruidDataSource druidDataSource;

    @PostConstruct
    public void init(){
        connectionUtil = this;
        connectionUtil.druidDataSource = this.druidDataSource;
    }
    /**
     * 获取实例
     * @return ConnectionUtil
     */
    public static ConnectionUtil getInstance(){
        if(connectionUtil==null){
            synchronized (ConnectionUtil.class){
                if(connectionUtil==null){
                    connectionUtil = new ConnectionUtil();
                }
            }
        }
        return connectionUtil;
    }

    /**
     * 获取连接
     * @return DruidPooledConnection
     */
    public DruidPooledConnection getConnection(){
        DruidPooledConnection connection = null;
        try {
            connection = druidDataSource.getConnection();
            //手动控制事务
            connection.setAutoCommit(false);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  connection;
    }

}
