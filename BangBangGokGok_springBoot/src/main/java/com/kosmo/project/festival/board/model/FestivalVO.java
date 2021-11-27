package com.kosmo.project.festival.board.model;

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
@Table(name= "festival")
@SequenceGenerator(
        name="FESTIVAL_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="FESTIVAL_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class FestivalVO {
	@Id
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="FESTIVAL_SEQ_GEN" //식별자 생성기를 설정해놓은  FESTIVAL_SEQ_GEN으로 설정        
            )
	@Column(name = "ARTICLE_NO")
	private int festivalId;
	
	@Column(name = "FESTIVAL_LOCATION")
	private String festivalLocation;
	
	@Column(name = "FESTIVAL_NAME")
	private String festivalName;
	
	@Column(name = "FESTIVAL_CONTENT")
	private String festivalContent;
	
	@Column(name = "FESTIVAL_DURATION")
	private String festivalDuration;
	
	@Column(name = "FESTIVAL_FEE")
	private int festivalFee;
	
	@Column(name = "FESTIVAL_OWNER")
	private String festivalOwner;
	
	@Column(name = "FESTIVAL_IMAGE")
	private String festivalImage;
}
	
