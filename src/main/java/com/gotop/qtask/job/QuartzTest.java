package com.gotop.qtask.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//@EnableScheduling
public class QuartzTest {

    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("hello");
    }
}
