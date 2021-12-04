package com.kosmo.project.board.model;

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
@Table(name = "ARTICLE")
@SequenceGenerator(
		name="ARTICLE_SEQ_GEN",
		sequenceName = "ARTICLE_SEQ",
		initialValue = 1,
		allocationSize = 1)
public class ArticleVO {
	
//	 ARTICLE_NO                                NOT NULL NUMBER(38)
//	 ARTICLE_CODE                              NOT NULL VARCHAR2(10)
//	 ARTICLE_TITLE                             NOT NULL VARCHAR2(100)
//	 ARTICLE_CONTENT                                    VARCHAR2(4000)
//	 USER_ID                                   NOT NULL VARCHAR2(20)
//	 WRITE_DATE                                NOT NULL DATE
//	 VIEW_COUNT                                         NUMBER(38)
//	 ARTICLE_STAR                                       FLOAT(126)
//	 ARTICLE_LIKE                                       NUMBER(38)
//	 ARTICLE_IMAGE                                      VARCHAR2(1000)
//	 FESTIVAL_LOCATION                                  VARCHAR2(10)
//	 FESTIVAL_NAME                                      VARCHAR2(1000)
//	 FESTIVAL_FEE                                       NUMBER(38)
//	 FESTIVAL_OWNER                                     VARCHAR2(60)
//	 FESTIVAL_DURATION                                  VARCHAR2(30)
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_SEQ_GEN")
	@Column(name = "ARTICLE_NO")
	private int articleNo;
	
	@Column(name = "ARTICLE_CODE")
	private String articleCode;
	
	@Column(name = "ARTICLE_TITLE")
	private String articleTitle;
	
	@Column(name = "ARTICLE_CONTENT")
	private String articleContent;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "WRITE_DATE")
	private Date writeDate;
	
	@Column(name = "VIEW_COUNT")
	private int viewCount;
	
	@Column(name = "ARTICLE_STAR")
	private double articleStar;
	
	@Column(name = "ARTICLE_LIKE")
	private int articleLike;
	
	@Column(name = "ARTICLE_IMAGE")
	private String articleImage;
	
	@Column(name = "FESTIVAL_LOCATION")
	private String festivalLocation;
	
	@Column(name = "FESTIVAL_NAME")
	private String festivalName;
	
	@Column(name = "FESTIVAL_FEE")
	private int festivalFee;
	
	@Column(name = "FESTIVAL_OWNER")
	private String festivalOwner;
	
	@Column(name = "FESTIVAL_DURATION")
	private String festivalDuration;
}
