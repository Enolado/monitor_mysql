package com.lwl.monitor.entity;

/**
 * 对应performance下的events_statements_history表
 * @author lwl
 * @create 2021/11/9 14:43
 */
public class EventsStatements {
    /**
     * 线程ID
     */
    private Long threadID;
    /**
     * 事件ID
     */
    private Long eventID;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件执行时间/秒
     */
    private Double execTimeSec;
    /**
     * 锁执行时间/秒
     */
    private Double lockTimeSec;
    /**
     * sql语句
     */
    private String sqlText;
    /**
     * 响应消息
     */
    private String messageText;

    public Long getThreadID() {
        return threadID;
    }

    public void setThreadID(Long threadID) {
        this.threadID = threadID;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Double getExecTimeSec() {
        return execTimeSec;
    }

    public void setExecTimeSec(Double execTimeSec) {
        this.execTimeSec = execTimeSec;
    }

    public Double getLockTimeSec() {
        return lockTimeSec;
    }

    public void setLockTimeSec(Double lockTimeSec) {
        this.lockTimeSec = lockTimeSec;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "EventsStatements{" +
                "threadID=" + threadID +
                ", eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", execTimeSec=" + execTimeSec +
                ", lockTimeSec=" + lockTimeSec +
                ", sqlText='" + sqlText + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
