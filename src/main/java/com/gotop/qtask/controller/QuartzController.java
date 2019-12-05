package com.gotop.qtask.controller;

import com.gotop.qtask.job.Job;
import com.gotop.qtask.job.Job2;
import com.gotop.qtask.service.impl.QuartzServiceOld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quartz")
public class QuartzController {
    @Resource
    QuartzServiceOld quartzService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Map<String, Object>> getAll(){
        return quartzService.queryAllJob();
    }

    @RequestMapping("/addJob1")
    @ResponseBody
    public boolean addjob1(){
        Map<String, Object> map = new HashMap<>();
        map.put("name",1);
        quartzService.addJob(Job.class, "job1","jobs", "0/7 * * * * ?", map); return true;
    }

    @RequestMapping("/addJob2")
    @ResponseBody
    public boolean addjob2(){
        Map<String, Object> map = new HashMap<>();
        map.put("name",1);
        quartzService.addJob(Job2.class, "job2","jobs", "0/6 * * * * ?", map); return true;
    }

    @RequestMapping("/delete1")
    @ResponseBody
    public boolean delete1(){
        quartzService.deleteJob("job1","jobs");
        return true;
    }

    @RequestMapping("/delete2")
    @ResponseBody
    public boolean delete2(){
        quartzService.deleteJob("job2","jobs");
        return true;
    }

    @RequestMapping(value = "addTask",method = RequestMethod.POST)
    @ResponseBody
    public List<String> addTask(@RequestParam String jobName, @RequestParam String groupName,
                                @RequestParam String invokeTarget, @RequestParam String cronExpress,
                                @RequestParam String misfirePolicy, @RequestParam String concurrent,
                                @RequestParam String status, @RequestParam String remake){
        List<String> ls = new ArrayList<String>();
        ls.add(jobName);
        ls.add(groupName);
        ls.add(invokeTarget);
        ls.add(cronExpress);
        ls.add(misfirePolicy);
        ls.add(concurrent);
        ls.add(status);
        ls.add(remake);
        return ls;
    }



}
