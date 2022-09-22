package com.lwl.monitor.entity;

import java.util.List;

/**
 * 对应performance_schema下的threads表
 * @author lwl
 * @create 2021/11/9 19:35
 */
public class Threads {
    /**
     * 唯一线程标识符
     */
    private Long threadId;
    /**
     * 与前台线程管理的用户，NULL为后台线程
     */
    private String processlistUser;
    /**
     * 与服务器中的线程检测代码关联的名称
     */
    private String name;
    /**
     * 线程类型FOREGROUND或BACKGROUND
     */
    private String type;
    /**
     * 该值在show processlist输出的Id列中显示
     */
    private Long processlistId;
    /**
     * 与前台线程关联的Client端的主机名，NULL 为table后台线程
     */
    private String processlistHost;
    /**
     * 线程的默认数据库,如果未选择则为null
     */
    private String processlistDB;
    /**
     * 对于前台线程，该线程代表 tableClient 端执行的命令类型；如果会话空闲，则返回Sleep。								空闲，则返回Sleep。
     */
    private String processlistCommand;
    /**
     * 线程处于其当前状态的时间(以秒为单位)。对于副本 SQL 线程，该值是最后一个复制事件的时间戳与副本主机的实时之间的秒数
     */
    private Long processlistTime;
    /**
     * 指示线程正在执行的操作，事件或状态。如果值为NULL，则该线程可能对应于一个空闲的 Client 端会话，或者该线程正在执行的工作没有阶段化.								作没有阶段化
     */
    private String processlistState;
    /**
     * 线程正在执行的语句，如果不执行任何语句，则返回NULL。
     */
    private String processlistInfo;

    /**
     * 如果此线程是子线程(由另一个线程生成)，则这是生成线程的THREAD_ID值。
     */
    private Long parentThreadId;

    /**
     * 用于构建连接的协议类型允许的值为:
     * TCP/IP(未加密构建的 TCP/IP 连接)，SSL/TLS(通过加密构建的 TCP/IP 连接)，
     * Socket(Unix 套接字文件连接)，Named Pipe(Windows 命名管道连接),
     * Shared Memory(Windows 共享内存连接),Shared Memory(Windows 共享内存连接)。
     */
    private String connectionType;

    /**
     * OS的线程id
     */
    private Long threadOSID;

    /**
     * 根据线程id进行查询(一对多)
     */
    private List<EventsStatements> eventsList;


    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getProcesslistUser() {
        return processlistUser;
    }

    public void setProcesslistUser(String processlistUser) {
        this.processlistUser = processlistUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProcesslistId() {
        return processlistId;
    }

    public void setProcesslistId(Long processlistId) {
        this.processlistId = processlistId;
    }

    public String getProcesslistHost() {
        return processlistHost;
    }

    public void setProcesslistHost(String processlistHost) {
        this.processlistHost = processlistHost;
    }

    public String getProcesslistDB() {
        return processlistDB;
    }

    public void setProcesslistDB(String processlistDB) {
        this.processlistDB = processlistDB;
    }

    public String getProcesslistCommand() {
        return processlistCommand;
    }

    public void setProcesslistCommand(String processlistCommand) {
        this.processlistCommand = processlistCommand;
    }

    public Long getProcesslistTime() {
        return processlistTime;
    }

    public void setProcesslistTime(Long processlistTime) {
        this.processlistTime = processlistTime;
    }

    public String getProcesslistState() {
        return processlistState;
    }

    public void setProcesslistState(String processlistState) {
        this.processlistState = processlistState;
    }

    public String getProcesslistInfo() {
        return processlistInfo;
    }

    public void setProcesslistInfo(String processlistInfo) {
        this.processlistInfo = processlistInfo;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public Long getThreadOSID() {
        return threadOSID;
    }

    public void setThreadOSID(Long threadOSID) {
        this.threadOSID = threadOSID;
    }

    public List<EventsStatements> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventsStatements> eventsList) {
        this.eventsList = eventsList;
    }

    public Long getParentThreadId() {
        return parentThreadId;
    }

    public void setParentThreadId(Long parentThreadId) {
        this.parentThreadId = parentThreadId;
    }

    @Override
    public String toString() {
        return "Threads{" +
                "threadId=" + threadId +
                ", processlistUser='" + processlistUser + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", processlistId=" + processlistId +
                ", processlistHost='" + processlistHost + '\'' +
                ", processlistDB='" + processlistDB + '\'' +
                ", processlistCommand='" + processlistCommand + '\'' +
                ", processlistTime=" + processlistTime +
                ", processlistState='" + processlistState + '\'' +
                ", processlistInfo='" + processlistInfo + '\'' +
                ", parentThreadId=" + parentThreadId +
                ", connectionType='" + connectionType + '\'' +
                ", threadOSID=" + threadOSID +
                ", eventsList=" + eventsList +
                '}';
    }
}
