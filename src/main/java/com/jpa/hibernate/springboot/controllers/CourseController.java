package com.jpa.hibernate.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.service.CourseBS;

@RestController
public class CourseController {

	// This shows when RestController is initialized
	// All the beans or objects will be of Singleton.
	private Course course = new Course();

	@Autowired
	private CourseBS courseBS;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		// Everytime same object will be printed
		// This shows singleton property.
		System.out.println(course);
		return courseBS.findAllCourses();
	}

	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable long id) {
		return courseBS.findById(id);
	}

	@PostMapping("/courses")
	public Course saveOrUpdateCourse(@RequestBody Course person) {
		return courseBS.saveOrUpdate(person);
	}

	@DeleteMapping("/courses/{id}")
	public Course deleteCourseById(@PathVariable long id) {
		return courseBS.deleteCourseById(id);
	}
}
