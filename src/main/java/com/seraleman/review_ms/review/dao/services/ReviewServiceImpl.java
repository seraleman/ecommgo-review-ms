package com.seraleman.review_ms.review.dao.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.seraleman.review_ms.review.Review;
import com.seraleman.review_ms.review.dao.IReviewDao;
import com.seraleman.review_ms.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    private IReviewDao reviewDao;

    @Autowired
    private IResponseService response;

    @Override
    public ResponseEntity<?> list() {

        List<Review> reviews = new ArrayList<>();

        try {
            reviews = reviewDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reviews.size() == 0) {
            return response.empty();
        }
        return response.list(reviews);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Review review = null;

        try {
            review = reviewDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (review == null) {
            return response.notFound(id);
        }
        return response.found(review);
    }

    @Override
    public ResponseEntity<?> create(Review review) {

        Review reviewNew = null;
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        LocalDateTime bogotaLocal = zdt.toLocalDateTime();
        review.setDate(bogotaLocal);

        try {
            reviewNew = reviewDao.save(review);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(reviewNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Review review) {

        Review reviewCurrent = null;

        try {
            reviewCurrent = reviewDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reviewCurrent == null) {
            return response.notFound(id);
        }

        try {
            reviewCurrent.setText(review.getText());
            reviewCurrent.setTitle(review.getTitle());
            reviewCurrent.setDate(review.getDate());
            reviewDao.save(reviewCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(reviewCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Review review = null;

        try {
            review = reviewDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (review == null) {
            return response.notFound(id);
        }

        try {
            reviewDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted(id);
    }
}
