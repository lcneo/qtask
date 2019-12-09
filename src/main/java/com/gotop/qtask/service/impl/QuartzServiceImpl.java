package com.gotop.qtask.service.impl;

import com.gotop.qtask.dao.QuartzJobMapper;
import com.gotop.qtask.domain.QuartzJob;
import com.gotop.qtask.service.QuartzService;
import com.sun.tools.javac.util.Convert;
import org.quartz.CronExpression;
import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuartzServiceImpl implements QuartzService {

    @Resource
    private Scheduler scheduler;

    @Resource
    private QuartzJobMapper quartzJobMapper;

//    @Autowired
//    private QuartzJobMapper quartzJobMapper;

    /**
     * 启动项目时，初始化定时器
     * @throws SchedulerException
     */
    @PostConstruct
    public void init() throws SchedulerException{

    }


    /**
     * 查询quartz调度器的计划任务列表
     * @param job 调度信息
     * @return
     */
    @Override
    public List<QuartzJob> selectJobList(QuartzJob job) {
        return quartzJobMapper.selectJobList(job);
    }

    /**
     * 通过调度任务的ID查询调度信息
     * @param jobId 调度任务Id
     * @return
     */
    @Override
    public QuartzJob selectJobById(Long jobId) {
        return quartzJobMapper.selectJobById(jobId);
    }

    /**
     * 暂停任务
     *
     * @param job 调度信息
     * @return
     * @throws SchedulerException
     */
    @Override
    public int pauseJob(QuartzJob job) throws SchedulerException {
            job.setStatus("1"); // status "1" 为静止
            int rows = quartzJobMapper.updateJob(job);
            /*
            todo: 在调度器中暂停job
            scheduler.pauseJob(ScheduleUtils.getJobKey(job.jobId, job.jobGroup));
             */
        return rows;
    }

    @Override
    public int resumeJob(QuartzJob job) throws SchedulerException {
            job.setStatus("0"); //  status "0" 为正常
            int rows = quartzJobMapper.updateJob(job);
            /*
            todo: 在调度器中恢复job
            scheduler.pauseJob(ScheduleUtils.getJobKey(job.jobId, job.jobGroup));
             */
        return 0;
    }

    @Override
    public int deleteJob(QuartzJob job) throws SchedulerException {
        Long jobId = job.getJobId();
        String jobGroup = job.getJobGroup();
        int rows = quartzJobMapper.deleteJobById(jobId);
        if (rows > 0){
            /*
            todo: 完成ScheduleUtils类
            scheduler.deleteJob(ScheduleU)
             */
        }
        return rows;
    }

    @Override
    public void deleteJobByIds(String ids) throws SchedulerException {
        Long[] JobIds = {};
        if(ids != null){
            String[] arr = ids.split(",");
            final List<Long> longs = new ArrayList<Long>();
            for(int i = 0; i < arr.length; i++){
                if((Object)arr[i] instanceof Long){
                    longs.add((Long)(Object)arr[i]);
                }
            }
            JobIds = (Long[])longs.toArray();

        }

    }

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     * @return
     * @throws SchedulerException
     */
    @Override
    public int changeStatus(QuartzJob job) throws SchedulerException {
        int rows = 0;
        if((job = selectJobById(job.getJobId())) != null){
            if(job.getStatus() == "0")
                rows = pauseJob(job);
            else
                rows = resumeJob(job);
        }
        return 0;
    }

    @Override
    public void run(QuartzJob job) throws SchedulerException {

    }

    /**
     * 先判别输入参数是否合法，再判断主键是否唯一，最后插入调度任务
     * @param job 调度信息
     * @return  -1 参数有不合法，0 主键不唯一，others 成功插入
     * @throws SchedulerException
     */
    @Override
    public int insertJob(@Valid QuartzJob job) throws SchedulerException {
        if(quartzJobMapper.selectJobIdByJob(job) != null)
            return 0;
//        todo:job.setStatus(ScheduleConstants.Status.PAUSE.getValue());
        int rows = quartzJobMapper.insertJob(job);
        if(rows > 0){
//            todo:ScheduleUtils.createScheduleJob(scheduler, job);
        }
        return 1;
    }


    @Override
    public int updateJob(QuartzJob job) throws SchedulerException {
        int rows = 0;
        if(quartzJobMapper.selectJobIdByJob(job) == job.getJobId() || quartzJobMapper.selectJobIdByJob(job) == null){
            QuartzJob properties = selectJobById(job.getJobId());
            rows = quartzJobMapper.updateJob(job);
        }
        if (rows > 0){
//            todo:updateSchedulerJob(job, properties.getJobGroup());
        }
        return rows;
    }

    /**
     * 校验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return  结果
     */
    @Override
    public boolean checkCronExpressionIsValid(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }


}
