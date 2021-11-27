package com.kosmo.project.free.board.model;



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
@Table(name="free")
@SequenceGenerator(
        name="FREE_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="FREE_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class FreeVO {
	
	@Id
	@Column(name="ARTICLE_NO")
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="FREE_SEQ_GEN" //식별자 생성기를 설정해놓은  FREE_SEQ_GEN으로 설정        
            )
	private int freeId;
	
	@Column(name="ARTICLE_TITLE")
	private String freeTitle;
	
	@Column(name="ARTICLE_CONTENT")
	private String freeContent;
	
	@Column(name="WRITER_ID")
	private String freeWriterId;
	
	@Column(name="WRITE_DATE")
	private Date freeDate;
	
	@Column(name="VIEW_COUNT")
	private int freeViewCount;
	
	@Column(name="ARTICLE_STAR")
	private double freeStar;
	
	@Column(name="ARTICLE_LIKE")
	private int freeLike;
	
	@Column(name="ARTICLE_IMAGE")
	private String freeImage;
}
