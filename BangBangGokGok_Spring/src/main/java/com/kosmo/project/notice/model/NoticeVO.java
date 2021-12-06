package com.kosmo.project.notice.model;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class NoticeVO {
	
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

	private Integer articleNo;
	private String articleCode;
	private String articleTitle;
	private String articleContent;
	private String userId;
	private Date writeDate;
	private Integer viewCount;
	private Double articleStar;
	private Integer articleLike;
	private String articleImage;
	private String festivalLocation;
	private String festivalName;
	private Integer festivalFee;
	private String festivalOwner;
	private String festivalDuration;
	
}
