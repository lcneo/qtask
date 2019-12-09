package com.gotop.qtask.util;

import com.gotop.qtask.domain.QuartzJob;
import org.quartz.Job;

/**
 * 定时任务工具类
 * @author neo
 * @date 2019/12/8 - 17:48
 */
public class ScheduleUtils {
    private static Class<? extends Job> getQuartzJobClass(QuartzJob job){
        boolean isCurrent = "0".equals(job.getConcurrent());
//        return isCurrent ?
    }
}
