package com.seraleman.review_ms.review;

import com.seraleman.review_ms.review.dao.services.IReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms/api/reviews")
public class ReviewRestController {
    
    @Autowired
    private IReviewService reviewService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return reviewService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return reviewService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Review review) {
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return reviewService.delete(id);
    }
}
