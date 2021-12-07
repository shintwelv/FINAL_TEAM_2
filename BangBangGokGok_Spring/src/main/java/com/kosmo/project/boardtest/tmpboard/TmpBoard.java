package com.kosmo.project.boardtest.tmpboard;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "ARTICLE")
@SequenceGenerator(
		name="ARTICLE_SEQ_GEN",
		sequenceName = "ARTICLE_SEQ",
		initialValue = 1,
		allocationSize = 1)
@ToString
public class TmpBoard {
//	@Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTICLE_SEQ_GEN")
//	@Column(name = "transfer_id")
//	private int transferId;
//	@Column(name = "transfer_name")
//	private String transferName;
//	@Column(name = "transfer_content")
//	private String transferContent;
//	@Column(name = "transfer_writer_id")
//	private String transferWriterId;
//	@Temporal(TemporalType.DATE)
//	@Column(name = "transfer_date")
//	private Date transferDate;
//	@Column(name = "transfer_image")
//	private String transferImage;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_SEQ_GEN")
	@Column(name = "ARTICLE_NO")
	private Integer articleNo;
	
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
	private Integer viewCount;
	
	@Column(name = "ARTICLE_STAR")
	private Double articleStar;
	
	@Column(name = "ARTICLE_LIKE")
	private Integer articleLike;
	
	@Column(name = "ARTICLE_IMAGE")
	private String articleImage;
	
	@Column(name = "FESTIVAL_LOCATION")
	private String festivalLocation;
	
	@Column(name = "FESTIVAL_NAME")
	private String festivalName;
	
	@Column(name = "FESTIVAL_FEE")
	private Integer festivalFee;
	
	@Column(name = "FESTIVAL_OWNER")
	private String festivalOwner;
	
	@Column(name = "FESTIVAL_DURATION")
	private String festivalDuration;

	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setWriteDate(String writeDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.writeDate = format.parse(writeDate);
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public void setArticleStar(Double articleStar) {
		this.articleStar = articleStar;
	}

	public void setArticleLike(Integer articleLike) {
		this.articleLike = articleLike;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public void setFestivalLocation(String festivalLocation) {
		this.festivalLocation = festivalLocation;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public void setFestivalFee(Integer festivalFee) {
		this.festivalFee = festivalFee;
	}

	public void setFestivalOwner(String festivalOwner) {
		this.festivalOwner = festivalOwner;
	}

	public void setFestivalDuration(String festivalDuration) {
		this.festivalDuration = festivalDuration;
	}
	
	
	
//	public TmpBoard() {
//		
//	}
//
//	public TmpBoard(int transfer_id, String transferName, String transferContent, String transferWriterId, Date transferDate) {
//		super();
//		this.transferId = transfer_id;
//		this.transferName = transferName;
//		this.transferContent = transferContent;
//		this.transferWriterId = transferWriterId;
//		this.transferDate = transferDate;
//	}
//	public void setTransferId(int transferId) {
//		this.transferId = transferId;
//	}
//
//	public void setTransferName(String transferName) {
//		this.transferName = transferName;
//	}
//
//	public void setTransferContent(String transferContent) {
//		this.transferContent = transferContent;
//	}
//
//	public void setTransferWriterId(String transferWriterId) {
//		this.transferWriterId = transferWriterId;
//	}
//
//	public void setTransferDate(String transferDate) throws ParseException {
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		this.transferDate = format.parse(transferDate);
//	}
//
//	public void setTransferImage(String transferImage) {
//		this.transferImage = transferImage;
//	}
	
//	@Override
//	public String toString() {
//		return "TmpBoard [transferId=" + transferId + ", transferName=" + transferName + ", transferContent="
//				+ transferContent + ", transferWriterId=" + transferWriterId + ", transferDate=" + transferDate
//				+ ", transferImage=" + transferImage + "]";
//	}
	
}
