package com.kosmo.project.review.reply.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "review_reply")
@SequenceGenerator(
        name="REVIEW_REPLY_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="REVIEW_REPLY_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class ReviewReplyVO {
	
	@Id
	@Column(name = "REPLY_NO")
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="REVIEW_REPLY_SEQ_GEN" //식별자 생성기를 설정해놓은  REVIEW_REPLY_SEQ_GEN으로 설정        
            )
	private int replyId;
	@Column(name = "ARTICLE_NO")
	private int articleId;
	@Column(name = "REPLY_CONTENT")
	private String replyContent;
	@Column(name = "WRITER_ID")
	private String replyWriterId;
	@Column(name = "WRITE_DATE")
	private Date replyDate;
	@Column(name = "REPLY_RATING")
	private double replyRating;

}
