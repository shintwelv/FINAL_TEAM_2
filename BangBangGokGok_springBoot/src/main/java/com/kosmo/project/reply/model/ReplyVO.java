package com.kosmo.project.reply.model;

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
@Table(name = "REPLY")
public class ReplyVO {
	
//	 REPLY_NO                                  NOT NULL NUMBER(38)
//	 ARTICLE_CODE                              NOT NULL VARCHAR2(10)
//	 ARTICLE_NO                                NOT NULL NUMBER(38)
//	 REPLY_CONTENT                             NOT NULL VARCHAR2(600)
//	 USER_ID                                   NOT NULL VARCHAR2(20)
//	 WRITE_DATE                                NOT NULL DATE
//	 REPLY_RATING                                       FLOAT(126)
	
	@Id
	@GeneratedValue
	@Column(name = "REPLY_NO")
	private int replyNo;
	
	@Column(name = "ARTICLE_CODE")
	private String articleCode;

	@Column(name = "ARTICLE_NO")
	private int articleNo;
	
	@Column(name = "REPLY_CONTENT")
	private String replyContent;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "WRITE_DATE")
	private Date writeDate;
	
	@Column(name = "REPLY_RATING")
	private double replyRating;
}
