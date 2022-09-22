package com.lwl.monitor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 对应performance_schema下的events_statements_summary_by_digest表
 * 事件摘要
 * @author lwl
 * @create 2021/10/26 19:31
 */
public class EventsDigest {
    /**
     * 数据库库名
     */
    String schemaName;
    /**
     * SQL语句
     */
    String digestText;
    /**
     * SQL语句调用次数
     */
    Long countStar;
    /**
     * SQL语句执行总时间
     */
    Long sumTimerWait;
    /**
     * 单个SQL语句执行最大时间
     */
    Long maxTimerWait;
    /**
     * 单个SQL语句执行最小时间
     */
    Long minTimerWait;
    /**
     * 每条SQL语句执行平均时间
     */
    Long avgTimerWait;
    /**
     * 首次调用该SQL语句时间
     */
    Date firstSeen;
    /**
     * 最后调用该SQL语句时间
     */
    Date lastSeen;
    //--
    /**
     * SQL排序记录数
     */
    Long sumSortRows;

    /**
     * SQL扫描次数
     */
    Long sumRowsExamined;
    /**
     * 内存临时表
     */
    Long sumCreatedTmpTables;
    /**
     * 磁盘临时表
     */
    Long sumCreatedTmpDiskTables;
    /**
     * 返回结果集
     */
    Long sumRowsSent;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getDigestText() {
        return digestText;
    }

    public void setDigestText(String digestText) {
        this.digestText = digestText;
    }

    public Long getCountStar() {
        return countStar;
    }

    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }

    public Long getSumTimerWait() {
        return sumTimerWait;
    }

    public void setSumTimerWait(Long sumTimerWait) {
        this.sumTimerWait = sumTimerWait;
    }

    public Long getMaxTimerWait() {
        return maxTimerWait;
    }

    public void setMaxTimerWait(Long maxTimerWait) {
        this.maxTimerWait = maxTimerWait;
    }

    public Long getMinTimerWait() {
        return minTimerWait;
    }

    public void setMinTimerWait(Long minTimerWait) {
        this.minTimerWait = minTimerWait;
    }

    public Long getAvgTimerWait() {
        return avgTimerWait;
    }

    public void setAvgTimerWait(Long avgTimerWait) {
        this.avgTimerWait = avgTimerWait;
    }

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }
    //--


    public Long getSumSortRows() {
        return sumSortRows;
    }

    public void setSumSortRows(Long sumSortRows) {
        this.sumSortRows = sumSortRows;
    }

    public Long getSumRowsExamined() {
        return sumRowsExamined;
    }

    public void setSumRowsExamined(Long sumRowsExamined) {
        this.sumRowsExamined = sumRowsExamined;
    }

    public Long getSumCreatedTmpTables() {
        return sumCreatedTmpTables;
    }

    public void setSumCreatedTmpTables(Long sumCreatedTmpTables) {
        this.sumCreatedTmpTables = sumCreatedTmpTables;
    }

    public Long getSumCreatedTmpDiskTables() {
        return sumCreatedTmpDiskTables;
    }

    public void setSumCreatedTmpDiskTables(Long sumCreatedTmpDiskTables) {
        this.sumCreatedTmpDiskTables = sumCreatedTmpDiskTables;
    }

    public Long getSumRowsSent() {
        return sumRowsSent;
    }

    public void setSumRowsSent(Long sumRowsSent) {
        this.sumRowsSent = sumRowsSent;
    }

    @Override
    public String toString() {
        return "EventsDigest{" +
                "schemaName='" + schemaName + '\'' +
                ", digestText='" + digestText + '\'' +
                ", countStar=" + countStar +
                ", sumTimerWait=" + sumTimerWait +
                ", maxTimerWait=" + maxTimerWait +
                ", minTimerWait=" + minTimerWait +
                ", avgTimerWait=" + avgTimerWait +
                ", firstSeen=" + firstSeen +
                ", lastSeen=" + lastSeen +
                ", sumSortRows=" + sumSortRows +
                ", sumRowsExamined=" + sumRowsExamined +
                ", sumCreatedTmpTables=" + sumCreatedTmpTables +
                ", sumCreatedTmpDiskTables=" + sumCreatedTmpDiskTables +
                ", sumRowsSent=" + sumRowsSent +
                '}';
    }
}
