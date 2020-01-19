package com.gtstar.fsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.gtstar.fsm.mapper")
public class FsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsmApplication.class, args);
	}

}
