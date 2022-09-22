package com.lwl.monitor.mapper;

import com.lwl.monitor.entity.TableIndex;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lwl
 * @create 2021/11/5 10:33
 */
@Repository
public interface TableIndexMapper {
    /**
     * 对应table_io_waits_summary_by_index_usage表下
     * 查看数据库各表的索引
     * @return Cursor<TableIndex>
     */
    @Select("SELECT OBJECT_NAME,OBJECT_SCHEMA,IFNULL(INDEX_NAME,'none') INDEX_NAME,SUM_TIMER_WAIT,MIN_TIMER_WAIT,MAX_TIMER_WAIT,AVG_TIMER_WAIT,COUNT_READ,COUNT_FETCH,COUNT_INSERT,COUNT_UPDATE,COUNT_DELETE , COUNT_STAR FROM table_io_waits_summary_by_index_usage ORDER BY  COUNT_STAR DESC\n")
    @Results({
            @Result(property = "objectName",column = "OBJECT_NAME"),
            @Result(property = "objectSchema",column = "OBJECT_SCHEMA"),
            @Result(property = "indexName",column = "INDEX_NAME"),
            @Result(property = "sumTimerWait",column = "SUM_TIMER_WAIT"),
            @Result(property = "minTimerWait",column = "MIN_TIMER_WAIT"),
            @Result(property = "maxTimerWait",column = "MAX_TIMER_WAIT"),
            @Result(property = "avgTimerWait",column = "AVG_TIMER_WAIT"),
            @Result(property = "countRead",column = "COUNT_READ"),
            @Result(property = "countFetch",column = "COUNT_FETCH"),
            @Result(property = "countInsert",column = "COUNT_INSERT"),
            @Result(property = "countUpdate",column = "COUNT_UPDATE"),
            @Result(property = "countDelete",column = "COUNT_DELETE"),
            @Result(property = "countStar",column = "COUNT_STAR"),
    })
    Cursor<TableIndex> getTableIndexCursor();

    /**
     * 获取该表下有多少相应数据库对应，确认map容器长度
     * @return Integer
     */
    @Select("SELECT COUNT(*) FROM (SELECT OBJECT_SCHEMA FROM table_io_waits_summary_by_index_usage GROUP BY OBJECT_SCHEMA) AS num")
    Integer getTableDigestCount();

    /**
     * 获取数据库库名
     * @return List<String>
     */
    @Select("SELECT OBJECT_SCHEMA FROM table_io_waits_summary_by_index_usage GROUP BY OBJECT_SCHEMA")
    List<String> getObjectSchema();
}
