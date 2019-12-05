package com.gotop.qtask.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Job extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int name = jobExecutionContext.getJobDetail().getJobDataMap().getInt("name");
        System.out.println("Job1: Hello quartz!" + name);


    }
}
