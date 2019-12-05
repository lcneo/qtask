package com.gotop.qtask.controller;

import com.gotop.qtask.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
//    private static Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/hot")
    @ResponseBody
    public String hot(){
        return "烫烫烫烫hot!";
    }

}
