package com.jpa.hibernate.springboot.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.repository.CourseRepositoryBSI;

@Service
@Transactional
public class CourseBS implements CourseRepositoryBSI {

	// @PersistenceContext: We can use this annotation also.
	@Autowired
	private EntityManager em;

	@Override
	public Course findById(long id) {
		return em.find(Course.class, id);
	}

	@Override
	public Course saveOrUpdate(Course course) {
		// It will update Person if Id matches otherwise it
		// will insert the new Person.
		em.merge(course);
		return course;
	}

	@Override
	public Course delete(long id) {
		Course person = findById(id);
		em.remove(person);
		return person;
	}
}
