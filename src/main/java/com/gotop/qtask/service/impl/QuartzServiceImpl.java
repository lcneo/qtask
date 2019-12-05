package com.gotop.qtask.service.impl;

import com.gotop.qtask.dao.QuartzJobMapper;
import com.gotop.qtask.domain.QuartzJob;
import com.gotop.qtask.service.QuartzService;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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


    @Override
    public List<QuartzJob> selectJobList(QuartzJob job) {
        return quartzJobMapper.selectJobList(job);
    }

    @Override
    public QuartzJob selectJobById(Long jobId) {
        return null;
    }

    @Override
    public int pauseJob(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public int resumeJob(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public int deleteJob(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public void deletejobByIds(String ids) throws SchedulerException {

    }

    @Override
    public int changeStatus(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public void run(QuartzJob job) throws SchedulerException {

    }

    @Override
    public int insertJob(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public int updateJob(QuartzJob job) throws SchedulerException {
        return 0;
    }

    @Override
    public boolean checkCronExpressionIsVakid(String cronExpression) {
        return false;
    }

    @Override
    public boolean test() {
        return true;
    }
}
