package com.jpa.hibernate.springboot.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.springboot.dto.Review;
import com.jpa.hibernate.springboot.repository.ReviewRepositoryBSI;

@Service
@Transactional
public class ReviewBS implements ReviewRepositoryBSI {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewBS.class);

	// @PersistenceContext: We can use this annotation also.
	@Autowired
	private EntityManager em;

	@Override
	public Review getAllReviewOfCourse(long reviewID) {
		Review review = em.find(Review.class, reviewID);
		LOGGER.info("Review  is -> {}", review);
		LOGGER.info("Review for Course is -> {}", review.getCourse());
		return review;
	}

}
