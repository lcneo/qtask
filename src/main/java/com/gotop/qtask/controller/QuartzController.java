package com.gotop.qtask.controller;

import com.gotop.qtask.domain.QuartzJob;
import com.gotop.qtask.job.Job;
import com.gotop.qtask.job.Job2;
import com.gotop.qtask.service.QuartzService;
import com.gotop.qtask.service.impl.QuartzServiceOld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class QuartzController {

    @Resource
    private QuartzServiceOld quartzServiceOld;


    @Resource
    private QuartzService quartzService;

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

    @RequestMapping("/test")
    @ResponseBody
    public boolean test(){
        return quartzService.test();
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



}
