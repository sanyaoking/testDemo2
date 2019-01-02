package com.mengchaob.testDemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mengchaob.testDemo2")
public class TestDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestDemo2Application.class, args);
	}

}

