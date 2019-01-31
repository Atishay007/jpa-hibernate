package com.jpa.hibernate.springboot.repository;

import org.springframework.stereotype.Repository;

import com.jpa.hibernate.springboot.dto.Course;

@Repository
public interface CourseRepositoryBSI {

	public Course findById(long id);

	public Course saveOrUpdate(Course person);

	public Course delete(long id);

}
