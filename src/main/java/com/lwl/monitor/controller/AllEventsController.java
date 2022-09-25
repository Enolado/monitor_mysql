package com.lwl.monitor.controller;

import com.lwl.monitor.service.EventsService;
import com.lwl.monitor.service.FileSummaryService;
import com.lwl.monitor.service.TableIndexService;
import com.lwl.monitor.service.ThreadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lwl
 * @create 2021/10/26 16:41
 */
@RestController
@RequestMapping("/events")
public class AllEventsController {

    /**
     * sql执行
     */
    @Autowired
    private EventsService eventsService;

    /**
     * 表索引
     */
    @Autowired
    private TableIndexService tableIndexService;

    /**
     * 连接线程信息
     */
    @Autowired
    private ThreadsService threadsService;

    /**
     * 事件物理IO信息
     */
    @Autowired
    private FileSummaryService fileSummaryService;

    /**
     * 返回数据
     */
    Map<String,Object> map = new HashMap<>();

    /**
     * 阻塞队列(生产者-消费者模型)
     */
    LinkedTransferQueue<Map<String,Object>> queue = new LinkedTransferQueue<>();

    /**
     * 一个线程专门轮询访问数据库获取结果
     */
    ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);

    /**
     * 初次执行标志
     */
    private Boolean first_flag = false;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Map<String,Object> getAll() throws InterruptedException {
        Map<String,Object> result = null;
        if (first_flag) {
            //复次访问,拿阻塞队列中的数据
            result = queue.take();
        } else {
            //初次访问，激活线程池循环执行任务
            scheduled.scheduleAtFixedRate(() -> {
                try {
                    //初始化容器
                    map = new HashMap<>();
                    //执行次数
                    map.put("eventsDigest",eventsService.getEventsDigestMap());
                    //表索引数量
                    map.put("tableIndex",tableIndexService.getTableIndexMap());
                    //所有数据库
                    map.put("allDatabases",eventsService.getAllDataBases());
                    //连接线程用户信息
                    map.put("connectionThread",threadsService.getThreadsMap());
                    //事件物理IO信息
                    map.put("fileSummary",fileSummaryService.getFileSummaryMap());
                    //阻塞当前线程,提前准备好数据，等http请求一来便直接响应数据,数据有60s延迟(前端定时时间)
                    queue.transfer(map);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 0, 1, TimeUnit.SECONDS);
            //拿队列中的数据
            result = queue.take();
            //避免多次执行定时任务
            first_flag = true;
        }
        return result;
    }


}
