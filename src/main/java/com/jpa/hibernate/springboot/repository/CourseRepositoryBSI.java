package com.jpa.hibernate.springboot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.hibernate.springboot.dto.Course;

@Repository
public interface CourseRepositoryBSI {

	public Course findById(long id);

	public Course saveOrUpdate(Course person);

	public Course deleteCourseById(long id);

	public List<Course> findAllCourses();

}
