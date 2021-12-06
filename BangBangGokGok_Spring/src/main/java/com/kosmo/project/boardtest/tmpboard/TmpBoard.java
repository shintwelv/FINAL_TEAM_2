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

@Entity
@Table(name = "tmpBoard")
@Getter
@SequenceGenerator(name="transfer_seq", sequenceName="transfer_seq", initialValue=1, allocationSize=1)
public class TmpBoard {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transfer_seq")
	@Column(name = "transfer_id")
	private int transferId;
	@Column(name = "transfer_name")
	private String transferName;
	@Column(name = "transfer_content")
	private String transferContent;
	@Column(name = "transfer_writer_id")
	private String transferWriterId;
	@Temporal(TemporalType.DATE)
	@Column(name = "transfer_date")
	private Date transferDate;
	@Column(name = "transfer_image")
	private String transferImage;
	
	public TmpBoard() {
		
	}

	public TmpBoard(int transfer_id, String transferName, String transferContent, String transferWriterId, Date transferDate) {
		super();
		this.transferId = transfer_id;
		this.transferName = transferName;
		this.transferContent = transferContent;
		this.transferWriterId = transferWriterId;
		this.transferDate = transferDate;
	}
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}

	public void setTransferContent(String transferContent) {
		this.transferContent = transferContent;
	}

	public void setTransferWriterId(String transferWriterId) {
		this.transferWriterId = transferWriterId;
	}

	public void setTransferDate(String transferDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.transferDate = format.parse(transferDate);
	}

	public void setTransferImage(String transferImage) {
		this.transferImage = transferImage;
	}
	
	@Override
	public String toString() {
		return "TmpBoard [transferId=" + transferId + ", transferName=" + transferName + ", transferContent="
				+ transferContent + ", transferWriterId=" + transferWriterId + ", transferDate=" + transferDate
				+ ", transferImage=" + transferImage + "]";
	}
	
}
