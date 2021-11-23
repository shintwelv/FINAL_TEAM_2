package com.kosmo.project.review.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosmo.project.review.board.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
