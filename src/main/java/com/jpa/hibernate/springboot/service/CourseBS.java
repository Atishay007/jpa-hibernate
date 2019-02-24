package com.jpa.hibernate.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Course;
import com.jpa.hibernate.springboot.dto.Review;
import com.jpa.hibernate.springboot.repository.CourseRepositoryBSI;

@Service
@Transactional
public class CourseBS implements CourseRepositoryBSI {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseBS.class);

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
		Course course = findById(id);
		em.remove(course);
		return course;
	}

	@Override
	public List<Course> findAllCourses() {
		TypedQuery<Course> tQuery = em.createNamedQuery("get_all_courses", Course.class);
		return tQuery.getResultList();
	}

	@Override
	public List<Review> getCourseReview(long courseId) {
		List<Review> rev = findById(courseId).getReviews();
		LOGGER.info("Review of CourseID " + courseId + " is -> {}", rev);
		return rev;
	}

}
