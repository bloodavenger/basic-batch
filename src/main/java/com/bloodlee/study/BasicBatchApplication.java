package com.bloodlee.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Application 설정 및 실행<br/>
 * 
 * @author Bred
 *
 */
@SpringBootApplication
@Slf4j
public class BasicBatchApplication {

	public static void main(String[] args) {
		log.info("Run BasicBatchApplication");
		System.exit(SpringApplication.exit(SpringApplication.run(BasicBatchApplication.class, args)));
	}
	
}
