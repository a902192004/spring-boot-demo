//package com.demo.schedule.config;
//
//import com.demo.schedule.mapper.CronMapper;
//import com.demo.schedule.po.CronPO;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.util.StringUtils;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Configuration
//@EnableScheduling
//public class TaskConfig implements SchedulingConfigurer {
//
//    private final CronMapper cronMapper;
//
//    public TaskConfig(CronMapper cronMapper) {
//        this.cronMapper = cronMapper;
//    }
//
//    /**
//     * 執行定時任務.
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(
//                //1.新增任務內容(Runnable)
//                () -> System.out.println("執行定時任務: " + LocalDateTime.now().toLocalTime()),
//                //2.設定執行週期(Trigger)
//                triggerContext -> {
//                    //2.1 從資料庫獲取執行週期
//                    List<CronPO> cronInfoList = cronMapper.getCron();
//                    // 校驗cron
//                    if (StringUtils.isEmpty(cronInfoList)) {
//                        // Omitted Code ..
//                    }
//                    //2.3 返回執行週期(Date)
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }
//
//}
