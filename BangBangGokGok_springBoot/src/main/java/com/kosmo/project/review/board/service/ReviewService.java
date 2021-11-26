package com.kosmo.project.review.board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kosmo.project.review.board.model.Review;
import com.kosmo.project.review.board.repository.ReviewRepository;
import com.kosmo.project.review.exception.ResourceNotFoundException;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // 후기 목록
    public List<Review> getAllReview(){
        return reviewRepository.findAll();
    }

    // 후기 작성
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // 후기 상세
    public Review getReview(Integer reviewId) {
    	Review review = reviewRepository.findById(reviewId)
              .orElseThrow(() -> new ResourceNotFoundException("Not exist Review Data by reviewId : ["+reviewId+"]"));
    	return review;
	}
    
//    public ResponseEntity<Review> getReview(Integer reviewId) {
//        Review review = reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new ResourceNotFoundException("Not exist Review Data by reviewId : ["+reviewId+"]"));
//        return ResponseEntity.ok(review);
//    }

    // 후기 수정
    public ResponseEntity<Review> updateReview(
            Integer reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Review Data by reviewId : ["+reviewId+"]"));
        review.setReviewTitle(updatedReview.getReviewTitle());
        review.setReviewContent(updatedReview.getReviewContent());
        review.setReviewUpdatedDate(new Date());

        Review endUpdatedReview = reviewRepository.save(review);
        return ResponseEntity.ok(endUpdatedReview);
    }

    // 후기 삭제
    public ResponseEntity<Map<String, Boolean>> deleteReview(
            Integer reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Review Data by reviewId : [" + reviewId + "]"));

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Review Data by reviewId : [" + reviewId + "]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}