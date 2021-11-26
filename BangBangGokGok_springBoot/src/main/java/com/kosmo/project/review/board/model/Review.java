package com.kosmo.project.review.board.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@SequenceGenerator(
        name="REVIEW_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="REVIEW_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class Review {

    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="REVIEW_SEQ_GEN" //식별자 생성기를 설정해놓은  REVIEW_SEQ_GEN으로 설정        
            )
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
    private Double reviewStar; // 별점

    @Column(name = "review_like")
    private Integer reviewLike; // 좋아요

    @Column(name = "review_image")
    private String reviewImage; // 이미지
}