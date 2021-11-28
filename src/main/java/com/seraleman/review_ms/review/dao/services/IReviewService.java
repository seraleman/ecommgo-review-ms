package com.seraleman.review_ms.review.dao.services;

import com.seraleman.review_ms.review.Review;

import org.springframework.http.ResponseEntity;

public interface IReviewService {
    
    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Review review);

    public ResponseEntity<?> update(String id, Review review);

    public ResponseEntity<?> delete(String id);

}
