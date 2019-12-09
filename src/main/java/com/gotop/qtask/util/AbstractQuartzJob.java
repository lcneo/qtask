package com.gotop.qtask.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 抽象Quartz调用
 * @author neo
 */
public abstract class AbstractQuartzJob implements Job {
    /** 线程本地变量 **/
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
