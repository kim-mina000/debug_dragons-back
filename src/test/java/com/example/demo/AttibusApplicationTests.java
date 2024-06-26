package com.example.demo;

import com.example.demo.Test.TestEntity.TestName;
import com.example.demo.Test.TestRepository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AttibusApplicationTests {

	@Autowired
	TestRepository repository;

	@Test
	void contextLoads() {
		System.out.println("HELLO WORLD");
	}

	@Test
	void repositoryTest(){
		System.out.println("HELLO WORLD");

		TestName A =  TestName.builder().name("a").build();
		repository.save(A);
	}

}
