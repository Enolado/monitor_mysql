package com.lwl.monitor.mapper;

import com.lwl.monitor.entity.Threads;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lwl
 * @create 2021/11/9 20:38
 */
@Repository
public interface ThreadsMapper {

    /**
     * 访问performance_schema下的threads表
      * @return Cursor<Threads>
     */
    @Select("SELECT THREAD_ID,IFNULL(PROCESSLIST_USER,'backgroundThread')PROCESSLIST_USER,NAME,TYPE,PROCESSLIST_ID,PROCESSLIST_HOST,PROCESSLIST_DB,PROCESSLIST_COMMAND,PROCESSLIST_TIME,IFNULL(PROCESSLIST_STATE,'空闲的Client对话/未检测到阶段') PROCESSLIST_STATE,PROCESSLIST_INFO,PARENT_THREAD_ID,IFNULL(CONNECTION_TYPE,'用于后台线程') CONNECTION_TYPE,THREAD_OS_ID FROM threads")
    @Results({
            @Result(column = "THREAD_ID",property = "threadId"),
            @Result(column = "PROCESSLIST_USER",property = "processlistUser"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "TYPE",property = "type"),
            @Result(column = "PROCESSLIST_ID",property = "processlistId"),
            @Result(column = "PROCESSLIST_HOST",property = "processlistHost"),
            @Result(column = "PROCESSLIST_DB",property = "processlistDB"),
            @Result(column = "PROCESSLIST_COMMAND",property = "processlistCommand"),
            @Result(column = "PROCESSLIST_TIME",property = "processlistTime"),
            @Result(column = "PROCESSLIST_STATE",property = "processlistState"),
            @Result(column = "PROCESSLIST_INFO",property = "processlistInfo"),
            @Result(column = "PARENT_THREAD_ID",property = "parentThreadId"),
            @Result(column = "CONNECTION_TYPE",property = "connectionType"),
            @Result(column = "THREAD_OS_ID",property = "threadOSID"),
            @Result(column = "THREAD_ID",property = "eventsList",many = @Many(select = "com.lwl.monitor.mapper.EventsMapper.getEventsStatementsList",fetchType= FetchType.EAGER))
    })
    Cursor<Threads> getThreadsCursor();

    /**
     * 获取threads表下的数据量
     * @return Integer
     */
    @Select("SELECT COUNT(*) FROM threads")
    Integer getThreadsCount();

}
