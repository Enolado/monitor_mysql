package com.lwl.monitor.mapper;


import com.alibaba.druid.pool.DruidPooledConnection;
import com.lwl.monitor.entity.*;
import com.lwl.monitor.service.*;
import com.lwl.monitor.utils.ConnectionUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;

/**
 * 测试
 * @author lwl
 * @create 2021/10/26 21:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsMapperTest {
    @Autowired
    EventsMapper eventsMapper;

    @Autowired
    EventsService eventsService;

    @Test
    public void getEventsDigestList() {
        long start = System.currentTimeMillis();
        Map<String, List<EventsDigest>> eventsDigestMap = eventsService.getEventsDigestMap();
        //    System.out.println("eventsDigestMap = " + eventsDigestMap);
        System.out.println("消耗时间:" + (System.currentTimeMillis() - start));
    }

    @Test
    public void testMap() {
        Map map = new HashMap();
        List list = new LinkedList();
        map.put(1, list);
        list.add(1);
        list.add(2);
        System.out.println(map.get(1));
    }

    /**
     * 存储查询数据
     */
    List<Map<String, List<EventsDigest>>> list = new ArrayList<>();

    /**
     * 生产者-消费者模型
     */
    BlockingQueue<List<Map<String, List<EventsDigest>>>> queue = new ArrayBlockingQueue<>(1);
    /**
     * 轮询访问数据库获取结果
     */
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    LinkedTransferQueue<List<Map<String, List<EventsDigest>>>> strs = new LinkedTransferQueue<>();

    boolean flag = false;


    public void testTask() throws InterruptedException {
        while (true) {

            List<Map<String, List<EventsDigest>>> result = null;
            if (flag) {
                System.out.println("复次调优");
              //  result = queue.take();
                //  System.out.println("result = " + result);
                result = strs.take();

            } else {
                System.out.println("--------------初次执行-----------------");
                service.scheduleAtFixedRate(() -> {
                    try {
                        list = new ArrayList<>();
                        list.add(eventsService.getEventsDigestMap());
                        //容量满了就等待
                        System.out.println("循环"+list.size());
                        strs.transfer(list);
                       // queue.put(list);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 0, 100, TimeUnit.MILLISECONDS);
                result  = strs.take();
                flag = true;
          //      System.out.println("result = " + result);
            }
            Thread.sleep(5000);
        }
    }

    @Test
    public void testScheduled(){
        service.scheduleAtFixedRate(()->{
            System.out.println("21");
        },0,500,TimeUnit.MILLISECONDS);
    }


    @Autowired
    TableIndexService tableIndexService;
    @Test
    public void testTableIndex(){
        Map<String, List<TableIndex>> tableIndexMap = tableIndexService.getTableIndexMap();
        System.out.println("tableIndexMap = " + tableIndexMap);
    }

    @Autowired
    ThreadsService threadsService;


    @Autowired
    ProfileService profileService;

    @Test
    public void testThreads() throws SQLException {
        Profile profile = new Profile();
        profile.setValue("SELECT * FROM day02.`user`");
        profileService.profile(profile);
    }



    @Test
    public void TestConnection(){
        DruidPooledConnection connection = ConnectionUtil.getInstance().getConnection();
        System.out.println("connection = " + connection);

    }

    @Test
    public void TestSQL(){
        String sql = "select * from user";
        String dataBase = "day01";

        int start = sql.indexOf("from");
        sql = sql.substring(start,start+4);
        System.out.println("start = " + sql);
    }

    @Autowired
    private FileSummaryService summaryService;
    @Test
    public void TestFileSummaryService(){
        Map<String, List<FileSummary>> fileSummaryMap = summaryService.getFileSummaryMap();
        System.out.println("fileSummaryMap = " + fileSummaryMap);

    }
}
