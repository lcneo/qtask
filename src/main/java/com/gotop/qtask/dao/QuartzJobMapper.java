package com.gotop.qtask.dao;

import com.gotop.qtask.domain.QuartzJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuartzJobMapper {
    /**
     * 查询调度任务日志集合
     *
     * @param job   调度信息
     * @return  操作日志集合
     */
    public List<QuartzJob> selectJobList(QuartzJob job);

    /**
     * 通过调度任务名和调度任务组查询ID
     * @param job
     * @return  调度任务ID
     */
    @Select("select job_id from quartz_job where job_name=#{jobName} AND job_group =#{jobGroup}")
    public Long selectJobIdByJob(QuartzJob job);

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
     * 通过调度ID删除任务信息
     * @param jobId 调度ID
     * @return
     */
    public int deleteJobById(Long jobId);

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

    @Select("select count(*) from quartz_job")
    public int count();
}
