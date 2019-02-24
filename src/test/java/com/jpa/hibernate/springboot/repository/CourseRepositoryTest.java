package com.jpa.hibernate.springboot.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.springboot.SpringBootStarter;
import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.dto.Student;

@RunWith(SpringRunner.class)
//This statement will load the Spring Context
//or what happen when we start app.
@SpringBootTest(classes = SpringBootStarter.class)
public class CourseRepositoryTest {

	private final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTest.class);

	@Autowired
	private CourseRepositoryBSI courseBS;

	@Autowired
	private StudentRepositoryBSI studentBS;

	@Test
	public void findById() {
		LOGGER.info("Test Case Running");
		Course course = courseBS.findById(1001);
		assertEquals(course.getName(), "Maths");
	}

	@Test
	// Spring will reset the deleted data.
	// So that other methods can use the data.
	@Rollback
	// @DirtiestContext
	public void deleteById() {
		Course course = courseBS.deleteCourseById(1001);
		assertEquals(course.getName(), "Maths");
	}

	@Test
	public void saveStudentWithPassPort() {
		Student student = studentBS.saveStudentWithPassPort();
		assertEquals(student.getName(), "Joshua Bloch");
	}

	@Test
	@Transactional
	public void getStudentWithPassPort() {
		Student student = studentBS.getStudentWithPassPort();
		// If we don't use @Transacional and we try to get Passport from
		// Student and they have Fetch=FetchType.LAZY strategy then we will get
		// LazyInitialization error.
		assertEquals(student.getPassport().getNumber(), "B47811QWER");
	}
	
	

}
