package com.lwl.monitor.entity;

/**
 * @author lwl
 * @create 2021/11/5 10:24
 */
public class TableIndex {
    /**
     * 表名
     */
    private String objectName;
    /**
     * 数据库
     */
    private String objectSchema;
    /**
     * 索引名
     */
    private String IndexName;
    /**
     * 总响应时间
     */
    private Long sumTimerWait;
    /**
     * 最短响应时间
     */
    private Long minTimerWait;
    /**
     * 最长响应时间
     */
    private Long maxTimerWait;
    /**
     * 平均响应时间
     */
    private Long avgTimerWait;
    /**
     * 读
     */
    private Long countRead;
    /**
     * 取
     */
    private Long countFetch;
    /**
     * 插入
     */
    private Long countInsert;
    /**
     * 更新
     */
    private Long countUpdate;
    /**
     * 删除
     */
    private Long countDelete;
    /**
     * 总次数
     */
    private Long countStar;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema;
    }

    public String getIndexName() {
        return IndexName;
    }

    public void setIndexName(String indexName) {
        IndexName = indexName;
    }

    public Long getSumTimerWait() {
        return sumTimerWait;
    }

    public void setSumTimerWait(Long sumTimerWait) {
        this.sumTimerWait = sumTimerWait;
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

    public Long getAvgTimerWait() {
        return avgTimerWait;
    }

    public void setAvgTimerWait(Long avgTimerWait) {
        this.avgTimerWait = avgTimerWait;
    }

    public Long getCountFetch() {
        return countFetch;
    }

    public void setCountFetch(Long countFetch) {
        this.countFetch = countFetch;
    }

    public Long getCountInsert() {
        return countInsert;
    }

    public void setCountInsert(Long countInsert) {
        this.countInsert = countInsert;
    }

    public Long getCountUpdate() {
        return countUpdate;
    }

    public void setCountUpdate(Long countUpdate) {
        this.countUpdate = countUpdate;
    }

    public Long getCountDelete() {
        return countDelete;
    }

    public void setCountDelete(Long countDelete) {
        this.countDelete = countDelete;
    }

    public Long getCountStar() {
        return countStar;
    }

    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    @Override
    public String toString() {
        return "TableIndex{" +
                "objectName='" + objectName + '\'' +
                ", objectSchema='" + objectSchema + '\'' +
                ", IndexName='" + IndexName + '\'' +
                ", sumTimerWait=" + sumTimerWait +
                ", minTimerWait=" + minTimerWait +
                ", maxTimerWait=" + maxTimerWait +
                ", avgTimerWait=" + avgTimerWait +
                ", countRead=" + countRead +
                ", countFetch=" + countFetch +
                ", countInsert=" + countInsert +
                ", countUpdate=" + countUpdate +
                ", countDelete=" + countDelete +
                ", countStar=" + countStar +
                '}';
    }
}
