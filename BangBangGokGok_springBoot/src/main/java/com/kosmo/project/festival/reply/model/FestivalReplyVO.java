package com.kosmo.project.festival.reply.model;

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
@Table(name = "festival_reply")
@SequenceGenerator(
        name="FESTIVAL_REPLY_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="FESTIVAL_REPLY_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class FestivalReplyVO {
	
	@Id
	@Column(name = "REPLY_ID")
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="FESTIVAL_REPLY_SEQ_GEN" //식별자 생성기를 설정해놓은  FESTIVAL_REPLY_SEQ_GEN으로 설정        
            )
	private int replyId;
	@Column(name = "FESTIVAL_ID")
	private int articleId;
	@Column(name = "REPLY_CONTENT")
	private String replyContent;
	@Column(name = "REPLY_WRITER_ID")
	private String replyWriterId;
	@Column(name = "REPLY_DATE")
	private Date replyDate;

}
