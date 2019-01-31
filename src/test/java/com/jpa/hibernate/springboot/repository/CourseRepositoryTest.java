package com.jpa.hibernate.springboot.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.springboot.SpringBootStarter;
import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.service.CourseBS;

@RunWith(SpringRunner.class)
//This statement will load the Spring Context
//or what happen when we start app.
@SpringBootTest(classes = SpringBootStarter.class)
public class CourseRepositoryTest {

	private final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTest.class);

	@Autowired
	private CourseBS courseBS;

	@Test
	public void findById() {
		LOGGER.info("Test Case Running");
		Course course = courseBS.findById(1);
		assertEquals(course.getName(), "Maths");
	}

	@Test
	// Spring will reset the deleted data.
	// So that other methods can use the data.
	@DirtiesContext
	public void deleteById() {
		Course course = courseBS.deleteCourseById(1);
		assertEquals(course.getName(), "Maths");
	}
	
}
