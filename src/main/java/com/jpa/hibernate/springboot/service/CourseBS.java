package com.jpa.hibernate.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.repository.CourseRepositoryBSI;

@Service
@Transactional
public class CourseBS implements CourseRepositoryBSI {

	private static final Logger LOGGER=LoggerFactory.getLogger(CourseBS.class);
			
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
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	@Override
	public Course deleteCourseById(long id) {
		Course person = findById(id);
		em.remove(person);
		return person;
	}

	@Override
	public List<Course> findAllCourses() {
		return em.createNamedQuery("get_all_courses", Course.class).getResultList();
	}
}
