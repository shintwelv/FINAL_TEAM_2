package com.kosmo.project.review.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.project.review.board.model.Review;
import com.kosmo.project.review.board.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 후기 목록
    @GetMapping("/review")
    public List<Review> getAllReviews() {
        log.info("reviewService.getAllReview() : {}", reviewService.getAllReview());
        return reviewService.getAllReview();
    }

    // 후기 작성
    @PostMapping("/review")
    public Review createReview(@RequestBody Review review) {
        System.out.println(review);
        return reviewService.createReview(review);
    }

    // 후기 상세
    @GetMapping("/review/{reviewId}")
    public ResponseEntity<Review> getReviewByReviewId(
            @PathVariable Integer reviewId) {
        return reviewService.getReview(reviewId);
    }

    // 후기 수정
    @PutMapping("/review/{reviewId}")
    public ResponseEntity<Review> updateReviewByReviewId(
            @PathVariable Integer reviewId, @RequestBody Review review) {
        return reviewService.updateReview(reviewId, review);
    }

    // 후기 삭제
    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<Map<String, Boolean>> deleteReviewByReviewId(
            @PathVariable Integer reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}