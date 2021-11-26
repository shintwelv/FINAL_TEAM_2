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
	@Column(name="free_id")
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="FREE_SEQ_GEN" //식별자 생성기를 설정해놓은  FREE_SEQ_GEN으로 설정        
            )
	private int freeId;
	
	@Column(name="free_title")
	private String freeTitle;
	
	@Column(name="free_content")
	private String freeContent;
	
	@Column(name="free_writer_id")
	private String freeWriterId;
	
	@Column(name="free_date")
	private Date freeDate;
	
	@Column(name="free_view_count")
	private int freeViewCount;
	
	@Column(name="free_star")
	private double freeStar;
	
	@Column(name="free_like")
	private int freeLike;
	
	@Column(name="free_image")
	private String freeImage;
}
