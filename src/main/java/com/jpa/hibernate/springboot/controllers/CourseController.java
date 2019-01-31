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

	@Autowired
	private CourseBS courseBS;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseBS.findAllCourses();
	}

	@GetMapping("/course/{id}")
	public Course getCourseById(@PathVariable long id) {
		return courseBS.findById(id);
	}

	@PostMapping("/course")
	public Course saveOrUpdateCourse(@RequestBody Course person) {
		return courseBS.saveOrUpdate(person);
	}

	@DeleteMapping("/course/{id}")
	public Course deleteCourseById(@PathVariable long id) {
		return courseBS.deleteCourseById(id);
	}
}
