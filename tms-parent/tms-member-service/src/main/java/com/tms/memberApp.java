package com.tms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tms.member.persist")
public class memberApp {
public static void main(String[] args) {
	SpringApplication.run(memberApp.class, args);
}
}
