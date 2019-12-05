package com.gotop.qtask.domain;

import java.io.Serializable;

/**
 * 定时任务调度表 QuartzJob
 * @author neo
 * @date 2019/12/14 - 13:00
 */
public class QuartzJob implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long jobId;

    /** 任务名称 */
    private String jobGroup;

    /** 调用目标字符串 */
    private String invokeTarget;

    /** cron表达式 */
    private String cornExpression;

    /** cron计划策略(1立即执行触发 2触发一次执行 不触发立即执行) */
    private String misfirePolicy;

    /** 是否并发执行(0允许 1禁止） */
    private String concurrent;

    /** 任务状态(0正常 1禁止) */
    private String status;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getCornExpression() {
        return cornExpression;
    }

    public void setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
    }

    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }

    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuartzJob{" +
                "jobId=" + jobId +
                ", jobGroup='" + jobGroup + '\'' +
                ", invokeTarget='" + invokeTarget + '\'' +
                ", cornExpression='" + cornExpression + '\'' +
                ", misfirePolicy='" + misfirePolicy + '\'' +
                ", concurrent='" + concurrent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
