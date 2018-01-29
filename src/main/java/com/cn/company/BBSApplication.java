package com.cn.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.cn.company.dao.jpa")
@EnableElasticsearchRepositories(basePackages ="com.cn.company.dao.elasticsearch")
public class BBSApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBSApplication.class, args);
	}
}
