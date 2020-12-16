package com.github.cxx;

import org.quartz.*;

import java.util.Date;

@DisallowConcurrentExecution//这个注解保证同一时间只有一个job实例在执行
public class MyJob implements Job {
    int jobk;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("============="+jobExecutionContext.getFireTime());
        System.out.println(jobExecutionContext.getTrigger().getEndTime());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        //key.
        //int jobk = jobDataMap.getInt("jobk");
        System.out.println(jobk);
        //jobDataMap.put("jobk",jobk++);
        System.out.println("this my job"+new Date());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置set方法 可以不用去jobDateMap 中获取jobk
     * @param jobk
     */
    public void setJobk(int jobk) {
        this.jobk = jobk;
    }
}
