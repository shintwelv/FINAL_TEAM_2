package com.kosmo.project.boardtest.manager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", initialValue = 1, allocationSize = 1)
@Table(name = "ACCESS_LEVEL")
public class Manager {
	@Id
	@GeneratedValue(generator = "authority_seq", strategy = GenerationType.SEQUENCE)
	private int authorityId;
	@Column(name = "admin_id")
	private String adminId;
	@Column(name = "admin_level")
	private String adminLevel;
	
	public Manager() {
	}
	
	public Manager(String adminId, String adminLevel) {
		super();
		this.adminId = adminId;
		this.adminLevel = adminLevel;
	}	 
	
	@Override
	public String toString() {
		return "Manager [authorityId=" + authorityId + ", adminId=" + adminId + ", adminLevel=" + adminLevel + "]";
	}
}
