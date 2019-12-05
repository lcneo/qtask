package com.gotop.qtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.gotop.qtask.qtask.dao")
//@ComponentScan(basePackages = ("com.gotop.qtask.qtask.*"))
public class QtaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtaskApplication.class, args);
	}

}
