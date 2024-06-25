package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.testEntity.TestName;
import com.example.demo.testReopository.TestRepository;

@SpringBootTest
class AttibusApplicationTests {

	@Autowired
	TestRepository repository;

	@Test
	void contextLoads() {
		System.out.println("hello world!");
	}

//	@Test
//	void 엔티티연결됐나요(){
//		TestName name = TestName.builder().name("??").build();
//		repository.save(name);
//	}

}
