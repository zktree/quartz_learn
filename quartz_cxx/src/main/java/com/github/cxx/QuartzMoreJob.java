package com.github.cxx;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

/**
 * @author xueluochenghua
 */
public class QuartzMoreJob {
    public static void main(String[] args) throws SchedulerException {
        //首先定义一个schuler
        //调度器
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        //触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)//每两秒执行一次
                        //.withRepeatCount(10)//执行次数
                        .repeatForever()//一直执行
                )//执行次数
                .endAt(new GregorianCalendar(2020, 12, 15, 20, 57, 30).getTime())//日期月份是从0开始的
                .build();
        SimpleTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)//每两秒执行一次
                        //.withRepeatCount(10)//执行次数
                        .repeatForever()//一直执行
                )//执行次数
                .endAt(new GregorianCalendar(2020, 12, 15, 20, 57, 30).getTime())//日期月份是从0开始的
                .build();
        //jobDetail
        JobDetail jobDetail = JobBuilder.newJob(MyJob2.class)
                .usingJobData("jobk",1000)
                .withIdentity("myjob", "group1")
                .build();

        JobDetail jobDetail2 = JobBuilder.newJob(MyJob2.class)
                .usingJobData("jobk",100)
                .withIdentity("myjob2", "group1")
                .build();

        //4.江jobdetail 和触发器放入调度中
        defaultScheduler.scheduleJob(jobDetail, trigger);
        //defaultScheduler.scheduleJob(jobDetail, trigger);

        //启动调度器
        defaultScheduler.start();


    }
}
