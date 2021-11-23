package com.kosmo.project.review.reply.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "review_reply")
public class ReviewReplyVO {
	
	@Id
	@Column(name = "REPLY_ID")
	@GeneratedValue
	private int replyId;
	@Column(name = "REVIEW_ID")
	private int articleId;
	@Column(name = "REPLY_CONTENT")
	private String replyContent;
	@Column(name = "REPLY_WRITER_ID")
	private String replyWriterId;
	@Column(name = "REPLY_DATE")
	private Date replyDate;
	@Column(name = "REPLY_RATING")
	private float replyRating;

}
