package com.gotop.qtask.mapper;

import com.gotop.qtask.domain.QuartzJob;

import java.util.List;

public interface QuartzJobMapper {
    /**
     * 查询调度任务日志集合
     *
     * @param job   调度信息
     * @return  操作日志集合
     */
    public List<QuartzJob> selectJobList(QuartzJob job);

    /**
     * 查询所有调度信息
     *
     * @return  角色对象信息
     */
    public List<QuartzJob> selectJobAll();

    /**
     * 通过ID查询调度任务信息
     *
     * @param jobId 调度ID
     * @return
     */
    public QuartzJob selectJobById(Long jobId);

    /**
     * 批量删除调度任务信息
     *
     * @param ids 需要删除的数据ID
     * @return
     */
    public int deleteJobByIds(Long[] ids);

    /**
     * 修改调度信息
     *
     * @param job  调度任务信息
     * @return  结果
     */
    public int updateJob(QuartzJob job);

    /**
     * 新增调度信息
     *
     * @param job   调度任务信息
     * @return  结果
     */
    public int insertJob(QuartzJob job);
}
