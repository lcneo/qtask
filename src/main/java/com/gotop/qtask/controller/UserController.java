package com.gotop.qtask.controller;

import com.gotop.qtask.domain.QuartzJob;
import com.gotop.qtask.dao.QuartzJobMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/hot")
    @ResponseBody
    public String hot(){
        return "烫烫烫烫hot!";
    }

    @Resource
    private QuartzJobMapper quartzJobMapper;

    @RequestMapping("ssm")
    @ResponseBody
    public List<QuartzJob> all(){
        List<QuartzJob> lq = new ArrayList<QuartzJob>();
        lq = quartzJobMapper.selectJobAll();
        return lq;
    }
    @RequestMapping("aa")
    @ResponseBody
    public String aall(){
        return quartzJobMapper.count() + "";
    }

}
