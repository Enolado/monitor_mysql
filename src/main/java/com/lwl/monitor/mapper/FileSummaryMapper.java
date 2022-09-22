package com.lwl.monitor.mapper;

import com.lwl.monitor.entity.FileSummary;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对应performance_schema下的file_summary_by_instance表
 * @author lwl
 * @create 2021/11/17 16:12
 */
@Repository
public interface FileSummaryMapper {

    /**
     * 获取file_summary_by_instance表中数据
     * @return Cursor<FileSummary>
     */
    @Select("SELECT FILE_NAME,EVENT_NAME,COUNT_STAR,MIN_TIMER_WAIT,MAX_TIMER_WAIT,COUNT_READ,MIN_TIMER_READ,MAX_TIMER_READ,SUM_NUMBER_OF_BYTES_READ,COUNT_WRITE,MIN_TIMER_WRITE,MAX_TIMER_WRITE,SUM_NUMBER_OF_BYTES_WRITE,COUNT_MISC,MIN_TIMER_MISC,MAX_TIMER_MISC FROM file_summary_by_instance ORDER BY SUM_NUMBER_OF_BYTES_READ + SUM_NUMBER_OF_BYTES_WRITE DESC")
    @Results({
            @Result(property = "fileName",column = "FILE_NAME"),
            @Result(property = "eventName",column = "EVENT_NAME"),
            @Result(property = "countStar",column = "COUNT_STAR"),
            @Result(property = "minTimerWait",column = "MIN_TIMER_WAIT"),
            @Result(property = "maxTimerWait",column = "MAX_TIMER_WAIT"),
            @Result(property = "countRead",column = "COUNT_READ"),
            @Result(property = "minTimerRead",column = "MIN_TIMER_READ"),
            @Result(property = "maxTimerRead",column = "MAX_TIMER_READ"),
            @Result(property = "sumNumberOfBytesRead",column = "SUM_NUMBER_OF_BYTES_READ"),
            @Result(property = "countWrite",column = "COUNT_WRITE"),
            @Result(property = "minTimerWrite",column = "MIN_TIMER_WRITE"),
            @Result(property = "maxTimerWrite",column = "MAX_TIMER_WRITE"),
            @Result(property = "sumNumberOfBytesWrite",column = "SUM_NUMBER_OF_BYTES_WRITE"),
            @Result(property = "countMisc",column = "COUNT_MISC"),
            @Result(property = "minTimerMisc",column = "MIN_TIMER_MISC"),
            @Result(property = "maxTimerMisc",column = "MAX_TIMER_MISC")
    })
    Cursor<FileSummary> getFileSummaryCursor();

    /**
     * 获取所有的事件名称
     * @return List<String>
     */
    @Select("SELECT event_name FROM file_summary_by_instance GROUP BY event_name")
    List<String> getEventNameList();

    /**
     * 获取所有的文件名称
     * @return List<String>
     */
    @Select("SELECT file_name FROM file_summary_by_instance GROUP BY FILE_NAME")
    List<String> getFileNameList();
}
