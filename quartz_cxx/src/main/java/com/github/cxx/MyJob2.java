package com.github.cxx;

import org.quartz.*;

import java.util.Date;

public class MyJob2 implements Job {
    int jobk;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("============="+jobExecutionContext.getFireTime());
        System.out.println(jobExecutionContext.getTrigger().getEndTime());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        //int jobk = jobDataMap.getInt("jobk");
        System.out.println(jobk);
        //jobDataMap.put("jobk",jobk++);
        System.out.println("this my job"+new Date());
    }

    /**
     * 设置set方法 可以不用去jobDateMap 中获取jobk
     * @param jobk
     */
    public void setJobk(int jobk) {
        this.jobk = jobk;
    }
}
