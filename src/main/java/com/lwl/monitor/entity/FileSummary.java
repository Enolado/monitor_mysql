package com.lwl.monitor.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 对应performance_schema库下的file_summary_by_instance表
 * @author lwl
 * @create 2021/11/17 11:22
 */
public class FileSummary {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * I/O次数，汇总了所有I/O操作
     */
    private Long countStar;
    /**
     * 最小时间消耗(I/O)
     */
    private Long minTimerWait;
    /**
     * 最大时间消耗(I/O)
     */
    private Long maxTimerWait;
    /**
     * Read读操作
     */
    private Long countRead;
    /**
     * 最小时间消耗(Read)
     */
    private Long minTimerRead;
    /**
     * 最大时间消耗(Read)
     */
    private Long maxTimerRead;
    /**
     * 读取的字节总数
     */
    private Long sumNumberOfBytesRead;
    /**
     * Write写操作
     */
    private Long countWrite;
    /**
     * 最小时间消耗(Write)
     */
    private Long minTimerWrite;
    /**
     * 最大时间消耗(Write)
     */
    private Long maxTimerWrite;
    /**
     * 写入的字节总数
     */
    private Long sumNumberOfBytesWrite;
    /**
     *  计数杂项，聚合了所有其他I/O操作,包括创建，删除，打开，关闭，流打开，流关闭,查找，通知，刷新，统计，FSTAT
     *  CHSIZE,重命名和同步。这些操作没有字节计数.
     */
    private Long countMisc;
    /**
     * 最小时间消耗(misc)
     */
    private Long minTimerMisc;
    /**
     * 最大时间消耗(misc)
     */
    private Long maxTimerMisc;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getCountStar() {
        return countStar;
    }

    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }

    public Long getMinTimerWait() {
        return minTimerWait;
    }

    public void setMinTimerWait(Long minTimerWait) {
        this.minTimerWait = minTimerWait;
    }

    public Long getMaxTimerWait() {
        return maxTimerWait;
    }

    public void setMaxTimerWait(Long maxTimerWait) {
        this.maxTimerWait = maxTimerWait;
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getMinTimerRead() {
        return minTimerRead;
    }

    public void setMinTimerRead(Long minTimerRead) {
        this.minTimerRead = minTimerRead;
    }

    public Long getMaxTimerRead() {
        return maxTimerRead;
    }

    public void setMaxTimerRead(Long maxTimerRead) {
        this.maxTimerRead = maxTimerRead;
    }

    public Long getSumNumberOfBytesRead() {
        return sumNumberOfBytesRead;
    }

    public void setSumNumberOfBytesRead(Long sumNumberOfBytesRead) {
        this.sumNumberOfBytesRead = sumNumberOfBytesRead;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getMinTimerWrite() {
        return minTimerWrite;
    }

    public void setMinTimerWrite(Long minTimerWrite) {
        this.minTimerWrite = minTimerWrite;
    }

    public Long getMaxTimerWrite() {
        return maxTimerWrite;
    }

    public void setMaxTimerWrite(Long maxTimerWrite) {
        this.maxTimerWrite = maxTimerWrite;
    }

    public Long getSumNumberOfBytesWrite() {
        return sumNumberOfBytesWrite;
    }

    public void setSumNumberOfBytesWrite(Long sumNumberOfBytesWrite) {
        this.sumNumberOfBytesWrite = sumNumberOfBytesWrite;
    }

    public Long getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Long countMisc) {
        this.countMisc = countMisc;
    }

    public Long getMinTimerMisc() {
        return minTimerMisc;
    }

    public void setMinTimerMisc(Long minTimerMisc) {
        this.minTimerMisc = minTimerMisc;
    }

    public Long getMaxTimerMisc() {
        return maxTimerMisc;
    }

    public void setMaxTimerMisc(Long maxTimerMisc) {
        this.maxTimerMisc = maxTimerMisc;
    }

    @Override
    public String toString() {
        return "FileSummary{" +
                "fileName='" + fileName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", countStar=" + countStar +
                ", minTimerWait=" + minTimerWait +
                ", maxTimerWait=" + maxTimerWait +
                ", countRead=" + countRead +
                ", minTimerRead=" + minTimerRead +
                ", maxTimerRead=" + maxTimerRead +
                ", sumNumberOfBytesRead=" + sumNumberOfBytesRead +
                ", countWrite=" + countWrite +
                ", minTimerWrite=" + minTimerWrite +
                ", maxTimerWrite=" + maxTimerWrite +
                ", sumNumberOfBytesWrite=" + sumNumberOfBytesWrite +
                ", countMisc=" + countMisc +
                ", minTimerMisc=" + minTimerMisc +
                ", maxTimerMisc=" + maxTimerMisc +
                '}';
    }
}
