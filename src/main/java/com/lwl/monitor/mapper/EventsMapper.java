package com.lwl.monitor.mapper;

import com.lwl.monitor.entity.EventsDigest;
import com.lwl.monitor.entity.EventsStatements;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lwl
 * @create 2021/10/26 20:38
 */
@Repository
public interface EventsMapper {

    /**
     * 获取events_statements_summary_by_digest下的数据
     * @return Cursor<EventsDigest>
     */
    @Select("SELECT IFNULL(SCHEMA_NAME,\"none\") SCHEMA_NAME ,DIGEST_TEXT,COUNT_STAR,SUM_TIMER_WAIT,MAX_TIMER_WAIT,MIN_TIMER_WAIT,AVG_TIMER_WAIT ,FIRST_SEEN,LAST_SEEN,SUM_SORT_ROWS,SUM_ROWS_EXAMINED,SUM_CREATED_TMP_TABLES,SUM_CREATED_TMP_DISK_TABLES,SUM_ROWS_SENT FROM events_statements_summary_by_digest  ORDER BY count_star DESC ;")
    @Results({
            @Result(property = "schemaName",column = "SCHEMA_NAME"),
            @Result(property = "digestText",column = "DIGEST_TEXT"),
            @Result(property = "countStar",column = "COUNT_STAR"),
            @Result(property = "sumTimerWait",column = "SUM_TIMER_WAIT"),
            @Result(property = "maxTimerWait",column = "MAX_TIMER_WAIT"),
            @Result(property = "minTimerWait",column = "MIN_TIMER_WAIT"),
            @Result(property = "avgTimerWait",column = "AVG_TIMER_WAIT"),
            @Result(property = "firstSeen",column = "FIRST_SEEN"),
            @Result(property = "lastSeen",column = "LAST_SEEN"),
            @Result(property = "sumSortRows",column = "SUM_SORT_ROWS"),
            @Result(property = "sumRowsExamined",column = "SUM_ROWS_EXAMINED"),
            @Result(property = "sumCreatedTmpTables",column = "SUM_CREATED_TMP_TABLES"),
            @Result(property = "sumCreatedTmpDiskTables",column = "SUM_CREATED_TMP_DISK_TABLES"),
            @Result(property = "sumRowsSent",column = "SUM_ROWS_SENT")
    })
    Cursor<EventsDigest> getEventsDigestCursor();

    /**
     * 获取数据的名字
     * @return List<String>
     */
    @Select("SELECT CASE WHEN SCHEMA_NAME IS NULL THEN 'none' ELSE SCHEMA_NAME END AS SCHEMA_NAME FROM events_statements_summary_by_digest GROUP BY SCHEMA_NAME")
    List<String> getSchemaNames();

    /**
     * 获取events_statements_summary_by_digest数据中库的数量
     * @return Integer
     */
    @Select("SELECT COUNT(*) FROM (SELECT SCHEMA_NAME FROM events_statements_summary_by_digest GROUP BY SCHEMA_NAME) AS num")
    Integer getEventsDigestCount();


    /**
     * 根据线程ID获取events_statements_history表中的数据
     * @param THREAD_ID
     * @return List<EventsStatements>
     */
    @Select("SELECT thread_id,event_id,event_name,(timer_end-timer_start)/1000000000000 exec_time_sec,lock_time/1000000000000 lock_time_sce, sql_text,MESSAGE_TEXT FROM performance_schema.events_statements_history   WHERE THREAD_ID = #{THREAD_ID} ORDER BY exec_time_sec DESC")
    @Results({
            @Result(column = "event_id",property = "eventID"),
            @Result(column = "event_name",property = "eventName"),
            @Result(column = "exec_time_sec",property = "execTimeSec"),
            @Result(column = "lock_time_sce",property = "lockTimeSec"),
            @Result(column = "sql_text",property = "sqlText"),
            @Result(column = "MESSAGE_TEXT",property = "messageText"),
    })
    List<EventsStatements> getEventsStatementsList(Long THREAD_ID);

    /**
     * 查找所有数据库
     * @return List<String>
     */
    @Select("SHOW DATABASES")
    List<String> getAllDataBases();
}
