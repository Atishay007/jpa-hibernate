package com.jpa.hibernate.springboot.repository;

import org.springframework.stereotype.Repository;

import com.jpa.hibernate.springboot.dto.Review;

@Repository
public interface ReviewRepositoryBSI {

	public Review getAllReviewOfCourse(long courseID);
}
