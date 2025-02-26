//package com.demo.schedule.service;
//
//import com.demo.schedule.po.CronPO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.convert.converter.ConverterRegistry;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.ScheduledFuture;
//
//@Slf4j
//@Component
//public class DynamicTaskService {
//
//    /**
//     * 以下兩個都是執行緒安全的集合類。
//     */
//    public Map<String, ScheduledFuture<?>> taskMap = new ConcurrentHashMap<>();
//    public List<String> taskList = new CopyOnWriteArrayList<String>();
//
//    private final ThreadPoolTaskScheduler syncScheduler;
//
//    public DynamicTaskService(ThreadPoolTaskScheduler syncScheduler) {
//        this.syncScheduler = syncScheduler;
//    }
//
//    /**
//     * 檢視已開啟但還未執行的動態任務
//     */
//    public List<String> getTaskList() {
//        return taskList;
//    }
//
//
//    /**
//     * 新增一個動態任務
//     *
//     * @param task
//     * @return
//     */
//    public boolean add(CronPO task) {
//        // 此處的邏輯是 ，如果當前已經有這個名字的任務存在，先刪除之前的，再新增現在的。（即重複就覆蓋）
//        if (null != taskMap.get(task.getName())) {
//            stop(task.getName());
//        }
//
//        // hutool 工具包下的一個轉換型別工具類 好用的很
//        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
//        Date startTime = converterRegistry.convert(Date.class, task.getStart());
//
//        // schedule :排程給定的Runnable ，在指定的執行時間呼叫它。
//        //一旦排程程式關閉或返回的ScheduledFuture被取消，執行將結束。
//        //引數：
//        //任務 – 觸發器觸發時執行的 Runnable
//        //startTime – 任務所需的執行時間（如果這是過去，則任務將立即執行，即儘快執行）
//        ScheduledFuture<?> schedule = syncScheduler.schedule(getRunnable(task), startTime);
//        taskMap.put(task.getName(), schedule);
//        taskList.add(task.getName());
//        return true;
//    }
//
//
//    /**
//     * 執行任務
//     *
//     * @param task
//     * @return
//     */
//    public Runnable getRunnable(CronPO task) {
//        return () -> {
//            log.info("---動態定時任務執行---");
//            try {
//                System.out.println("此時時間==>" + LocalDateTime.now());
//                System.out.println("task中設定的時間==>" + task);
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("---end--------");
//        };
//    }
//
//    /**
//     * 停止任務
//     *
//     * @param name
//     * @return
//     */
//    public boolean stop(String name) {
//        if (null == taskMap.get(name)) {
//            return false;
//        }
//        ScheduledFuture<?> scheduledFuture = taskMap.get(name);
//        scheduledFuture.cancel(true);
//        taskMap.remove(name);
//        taskList.remove(name);
//        return true;
//    }
//}
