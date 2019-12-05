package com.gotop.qtask.service;

import com.gotop.qtask.domain.QuartzJob;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * 定时任务调度信息 服务层
 *
 * @author neo
 * @date 2019/12/4 - 14:00
 */
public interface QuartzService {

    /**
     * 获取quartz调度器的计划任务
     *
     * @param job 调度信息
     * @return 调度任务集合
     */
    public List<QuartzJob> selectJobList(QuartzJob job);

    /**
     * 通过任务ID查询调度信息
     *
     * @param jobId 调度任务Id
     * @return 调度任务对象信息
     */
    public QuartzJob selectJobById(Long jobId);

    /**
     * 暂停任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int pauseJob(QuartzJob job) throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int resumeJob(QuartzJob job) throws SchedulerException;

    /**
     * 删除任务后，所对应trigger也将被删除
     *
     * @param job 调度信息
     * @return 结果
     */
    public int deleteJob(QuartzJob job) throws SchedulerException;

    /**
     * 批量删除调度信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public void deletejobByIds(String ids) throws SchedulerException;

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     * @return 结果
     */
    public int changeStatus(QuartzJob job) throws SchedulerException;

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public void run(QuartzJob job) throws SchedulerException;

    /**
     * 新增任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int insertJob(QuartzJob job) throws SchedulerException;

    /**
     * 更新任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int updateJob(QuartzJob job) throws SchedulerException;

    /**
     * 检验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return 结果
     */
    public boolean checkCronExpressionIsVakid(String cronExpression);

    public boolean test();

}
