package com.kosmo.project.review.board.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@Table(name = "review")
@DynamicInsert
@DynamicUpdate
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_id")
    private Integer reviewId; // 글 번호

    @Column(name = "review_title")
    private String reviewTitle; // 제목

    @Column(name = "review_content")
    private String reviewContent; // 내용

    @Column(name = "review_writer_id")
    private String reviewWriterId; // 작성자

    @Column(name = "review_created_date")
    private Date reviewCreatedDate; // 생성 날짜

    @Column(name = "review_updated_date")
    private Date reviewUpdatedDate; // 수정 날짜

    @Column(name = "review_view_count")
    private Integer reviewViewCount; // 조회수

    @Column(name = "review_star")
    private Float reviewStar; // 별점

    @Column(name = "review_like")
    private Integer reviewLike; // 좋아요

    @Column(name = "review_image")
    private String reviewImage; // 이미지
}