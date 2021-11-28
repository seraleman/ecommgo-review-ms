package com.seraleman.review_ms.review.dao;

import com.seraleman.review_ms.review.Review;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IReviewDao extends MongoRepository<Review, String> {

}
