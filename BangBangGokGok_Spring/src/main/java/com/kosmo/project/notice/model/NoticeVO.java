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
//	 ARTICLE_TITLE                             NOT NULL VARCHAR2(100)
//	 ARTICLE_CONTENT                                    VARCHAR2(4000)
//	 WRITE_DATE                                NOT NULL DATE
//	 ARTICLE_IMAGE                                      VARCHAR2(1000)
//	 VIEW_COUNT                                NOT NULL NUMBER(38)
//	 USER_ID                                            VARCHAR2(20)
	
	private int article_no;
	private String article_title;
	private String article_content;
	private Date write_date;
	private String article_image;
	private int view_count;
	private String user_id;
}
