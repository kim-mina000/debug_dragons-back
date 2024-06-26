package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaAuditing //엔티티의 생성 시간, 수정 시간 등을 자동으로 기록하는 기능
public class AttibusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttibusApplication.class, args);
	}

}
