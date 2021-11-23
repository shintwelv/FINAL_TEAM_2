package com.kosmo.project.festival.board.model;

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
@Table(name= "festival")
public class FestivalVO {
	@Id
	@GeneratedValue
	@Column(name = "festival_id")
	private int festivalId;
	
	@Column(name = "festival_location")
	private String festivalLocation;
	
	@Column(name = "festival_name")
	private String festivalName;
	
	@Column(name = "festival_content")
	private String festivalContent;
	
	@Column(name = "festival_start_date")
	private Date festivalstartDate;
	
	@Column(name = "festival_end_date")
	private Date festivalendDate;
	
	@Column(name = "festival_fee")
	private int festivalFee;
	
	@Column(name = "festival_owner")
	private String festivalOwner;
	
	@Column(name = "festival_image")
	private String festivalImage;
}
	
