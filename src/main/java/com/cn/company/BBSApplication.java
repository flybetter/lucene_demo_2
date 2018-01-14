package com.cn.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BBSApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBSApplication.class, args);
	}
}
