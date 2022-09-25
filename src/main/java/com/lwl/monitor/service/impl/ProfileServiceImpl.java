package com.lwl.monitor.service.impl;

import com.lwl.monitor.entity.Profile;
import com.lwl.monitor.service.ProfileService;
import com.lwl.monitor.utils.ConnectionUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwl
 * @create 2021/11/15 11:07
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Override
    public Map<String, Object> profile(Profile profile) {
        //获取连接
        Connection connection = ConnectionUtil.getInstance().getConnection();
        Map<String, Object> map = new HashMap<>(20);
        try {
            String flag = null;
            ResultSet resultSet = connection.prepareStatement("SELECT @@profiling").executeQuery();
            while (resultSet.next()){
                 flag = resultSet.getString("@@profiling");
            }
            if("0".equals(flag)){
                //生成内存临时表
                connection.prepareStatement("set profiling = 1").execute();
            }

            //执行SQL语句
            connection.prepareStatement(profile.getValue()).execute();
            //查询执行情况
            ResultSet rs = connection.prepareStatement("show profile").executeQuery();
            while (rs.next()) {
                String status = (String) rs.getObject("Status");
                BigDecimal duration = (BigDecimal) rs.getObject("Duration");
                map.put(status, duration);
            }
            //回滚,不让测试语句影响磁盘数据
            connection.rollback();
        } catch (Exception e) {
            //返回错误信息
            map.put("errorMsg", e.getMessage());
            try {
                //回滚
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        } finally {
            try {
                //保持监控数据源
                connection.prepareStatement("use performance_schema").execute();
                //一定需要关闭连接
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
