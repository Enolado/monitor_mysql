package com.lwl.monitor.entity;

/**
 * 对应performance_schema下的users表
 * @author lwl
 * @create 2021/11/11 10:23
 */
public class Users {
    /**
     * 连接的Client端用户。对于内部线程或者未通过身份验证的用户会话，这是NULL
     */
    private String user;
    /**
     *  当前连接数
     */
    private Long currentConnections;
    /**
     * 总连接数
     */
    private Long totalConnections;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Long currentConnections) {
        this.currentConnections = currentConnections;
    }

    public Long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(Long totalConnections) {
        this.totalConnections = totalConnections;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                ", currentConnections=" + currentConnections +
                ", totalConnections=" + totalConnections +
                '}';
    }
}
