package com.gotop.qtask.controller;

import com.gotop.qtask.dao.QuartzJobMapper;
import com.gotop.qtask.domain.QuartzJob;
import com.gotop.qtask.job.Job;
import com.gotop.qtask.job.Job2;
import com.gotop.qtask.service.QuartzService;
import com.gotop.qtask.service.impl.QuartzServiceOld;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

@Controller
public class QuartzController {

    @Resource
    private QuartzServiceOld quartzServiceOld;


    @Resource
    private QuartzService quartzService;

    @Resource
    private QuartzJobMapper quartzJobMapper;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Map<String, Object>> getAll(){
        return quartzServiceOld.queryAllJob();
    }



    @RequestMapping("/addJob1")
    @ResponseBody
    public boolean addjob1(){
        Map<String, Object> map = new HashMap<>();
        map.put("name",1);
        quartzServiceOld.addJob(Job.class, "job1","jobs", "0/7 * * * * ?", map); return true;
    }

    @RequestMapping("/addJob2")
    @ResponseBody
    public boolean addjob2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name",1);
        quartzServiceOld.addJob(Job2.class, "job2","jobs", "0/6 * * * * ?", map); return true;
    }

    @RequestMapping("/delete1")
    @ResponseBody
    public boolean delete1(){
        quartzServiceOld.deleteJob("job1","jobs");
        return true;
    }

    @RequestMapping("/delete2")
    @ResponseBody
    public boolean delete2(){
        quartzServiceOld.deleteJob("job2","jobs");
        return true;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<QuartzJob> list(QuartzJob job){
        return quartzService.selectJobList(job);
    }

    @PostMapping("/list")
    @ResponseBody
    public List<QuartzJob> plist(QuartzJob job){
        return quartzService.selectJobList(job);
    }

    @RequestMapping("/byid")
    @ResponseBody
    public QuartzJob selecetById(Long jobId){
        return quartzService.selectJobById(jobId);
    }


    @RequestMapping("/listAll")
    @ResponseBody
    public List<QuartzJob> listAll(Long jobId){
        return quartzJobMapper.selectJobAll();
    }

    @PostMapping("/insert")
    @ResponseBody
    public int insert(QuartzJob job) throws SchedulerException {
        return quartzService.insertJob(job);
    }

    @RequestMapping("/select")
    @ResponseBody
    public long select(QuartzJob job){
        return quartzJobMapper.selectJobIdByJob(job) != null ? quartzJobMapper.selectJobIdByJob(job) : 0;
    }

    @RequestMapping("/update")
    @ResponseBody
    public int update(QuartzJob job) throws SchedulerException {
        return quartzService.updateJob(job);
    }

    @RequestMapping("/cron")
    @ResponseBody
    public boolean cron(QuartzJob job){
        return quartzService.checkCronExpressionIsValid(job.getCronExpression());
    }


}
