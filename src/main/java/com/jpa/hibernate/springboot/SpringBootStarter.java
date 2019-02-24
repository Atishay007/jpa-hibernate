package com.jpa.hibernate.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.springboot.repository.CourseRepositoryBSI;
import com.jpa.hibernate.springboot.repository.StudentRepositoryBSI;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner {

	@Autowired
	private StudentRepositoryBSI studentBS;

	@Autowired
	private CourseRepositoryBSI courseBS;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// To call methods present Repository using BS..
		studentBS.saveStudentWithPassPort();
		studentBS.getStudentWithPassPort();
	}

}
