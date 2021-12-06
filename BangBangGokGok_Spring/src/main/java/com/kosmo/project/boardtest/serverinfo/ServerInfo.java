
package com.kosmo.project.boardtest.serverinfo;

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

import lombok.Data;

@Entity
@Data
@Table(name = "serverInfo")
@SequenceGenerator(name = "serverinfo_seq", sequenceName = "serverinfo_seq", initialValue = 1, allocationSize = 1)
public class ServerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serverinfo_seq" )
	@Column(name = "serverinfo_id")
	private int serverInfoId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datachecktime")
	private Date dataCheckTime;
	@Column(name = "cpu_usage")
	private double cpuUsage;
	@Column(name = "session_count")
	private int sessionCount;
	@Column(name = "memory_TotalPhysicalSize")
	private int memoryTotalSize;
	@Column(name = "memory_FreePhysicalSize")
	private int memoryFreeSize;
	@Column(name = "memory_UsagePercent")
	private int memoryUsagePercent;
	@Column(name = "memory_IdlePercent")
	private int memoryIdelPercent;
	@Column(name = "HDD_Total")	
	private int hddTotal;
	@Column(name = "HDD_Usage")
	private int hddUsage;
	@Column(name = "HDD_Idle")
	private int hddIdle;
	@Column(name = "HDD_UsagePercent")
	private int hddUsagePercent;
	@Column(name = "HDD_IdlePercent")
	private int hddIdlePercent;
	
	public ServerInfo() {
		
	}
	
	public ServerInfo(int serverInfoId, Date dataCheckTime, double cpuUsage, int sessionCount, int memoryTotalSize,
			int memoryFreeSize, int memoryUsagePercent, int memoryIdelPercent, int hddTotal, int hddUsage, int hddIdle,
			int hddUsagePercent, int hddIdlePercent) {
		super();
		this.serverInfoId = serverInfoId;
		this.dataCheckTime = dataCheckTime;
		this.cpuUsage = cpuUsage;
		this.sessionCount = sessionCount;
		this.memoryTotalSize = memoryTotalSize;
		this.memoryFreeSize = memoryFreeSize;
		this.memoryUsagePercent = memoryUsagePercent;
		this.memoryIdelPercent = memoryIdelPercent;
		this.hddTotal = hddTotal;
		this.hddUsage = hddUsage;
		this.hddIdle = hddIdle;
		this.hddUsagePercent = hddUsagePercent;
		this.hddIdlePercent = hddIdlePercent;
	}
	
	public void setServerInfoId(int serverInfoId) {
		this.serverInfoId = serverInfoId;
	}
	public void setDataCheckTime(String dataCheckTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.dataCheckTime = sdf.parse(dataCheckTime);
	}
	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public void setSessionCount(int sessionCount) {
		this.sessionCount = sessionCount;
	}
	public void setMemoryTotalSize(int memoryTotalSize) {
		this.memoryTotalSize = memoryTotalSize;
	}
	public void setMemoryFreeSize(int memoryFreeSize) {
		this.memoryFreeSize = memoryFreeSize;
	}
	public void setMemoryUsagePercent(int memoryUsagePercent) {
		this.memoryUsagePercent = memoryUsagePercent;
	}
	public void setMemoryIdelPercent(int memoryIdelPercent) {
		this.memoryIdelPercent = memoryIdelPercent;
	}
	public void setHddTotal(int hddTotal) {
		this.hddTotal = hddTotal;
	}
	public void setHddUsage(int hddUsage) {
		this.hddUsage = hddUsage;
	}
	public void setHddIdle(int hddIdle) {
		this.hddIdle = hddIdle;
	}
	public void setHddUsagePercent(int hddUsagePercent) {
		this.hddUsagePercent = hddUsagePercent;
	}
	public void setHddIdlePercent(int hddIdlePercent) {
		this.hddIdlePercent = hddIdlePercent;
	}
	public int getServerInfoId() {
		return serverInfoId;
	}
	public String getDataCheckTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(dataCheckTime);
	}
	public double getCpuUsage() {
		return cpuUsage;
	}
	public int getSessionCount() {
		return sessionCount;
	}
	public int getMemoryTotalSize() {
		return memoryTotalSize;
	}
	public int getMemoryFreeSize() {
		return memoryFreeSize;
	}
	public int getMemoryUsagePercent() {
		return memoryUsagePercent;
	}
	public int getMemoryIdelPercent() {
		return memoryIdelPercent;
	}
	public int getHddTotal() {
		return hddTotal;
	}
	public int getHddUsage() {
		return hddUsage;
	}
	public int getHddIdle() {
		return hddIdle;
	}
	public int getHddUsagePercent() {
		return hddUsagePercent;
	}
	public int getHddIdlePercent() {
		return hddIdlePercent;
	}
	@Override
	public String toString() {
		return "ServerInfo [serverInfoId=" + serverInfoId + ", dataCheckTime=" + dataCheckTime + ", cpuUsage="
				+ cpuUsage + ", sessionCount=" + sessionCount + ", memoryTotalSize=" + memoryTotalSize
				+ ", memoryFreeSize=" + memoryFreeSize + ", memoryUsagePercent=" + memoryUsagePercent
				+ ", memoryIdelPercent=" + memoryIdelPercent + ", hddTotal=" + hddTotal + ", hddUsage=" + hddUsage
				+ ", hddIdle=" + hddIdle + ", hddUsagePercent=" + hddUsagePercent + ", hddIdlePercent=" + hddIdlePercent
				+ "]";
	}

	
}
