package com.kosmo.project.boardtest.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kosmo.project.boardtest.serverinfo.ServerInfo;
import com.kosmo.project.boardtest.serverinfo.ServerInfoRepository;
import com.sun.management.OperatingSystemMXBean;

@Component
public class CommFunc {
	//CPU �뜲�씠�꽣���옣
	private Map<String, Double>cpuData = new LinkedHashMap<String, Double>();

	// �쁽�옱 �꽌踰꾩뿉 �뿰寃곕맂 �궗�슜�옄 Session �젙蹂�
	private Map<String, Integer>sessionData = new LinkedHashMap<String, Integer>();
	
	// Memory �뜲�씠�꽣 ���옣 ( Memory 珥� �슜�웾, Memory �궗�슜 媛��뒫�븳 �슜�웾, Memory �궓�� �슜�웾, Memory �궗�슜以묒씤 �슜�웾(珥� �슜�웾 ��鍮� % �젙蹂�), Memory �궗�슜媛��뒫�븳 �슜�웾(珥� �슜�웾 ��鍮� % �젙蹂�)
	private Map<String, Map<String, Integer>>memoryData = new LinkedHashMap<String, Map<String, Integer>>();
	private Map<String, Integer> memoryDataMap = new LinkedHashMap<String, Integer>();
	
	// HDD �뜲�씠�꽣 ���옣 ( HDD 珥� �슜�웾, HDD �궗�슜以묒씤 �슜�웾, HDD �궗�슜 媛��뒫�븳 �슜�웾, HDD �궗�슜以묒씤 �슜�웾(珥� �슜�웾 ��鍮� % �젙蹂�), HDD �궗�슜媛��뒫�븳 �슜�웾(珥� �슜�웾 ��鍮� % �젙蹂�)
	private Map<String, Map<String, Integer>>hddData = new LinkedHashMap<String, Map<String, Integer>>();
	private Map<String, Integer> hddDataMap = new LinkedHashMap<String, Integer>();
	
	private SimpleDateFormat dataTime = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat fileTime = new SimpleDateFormat("yyyyMMdd-HHmm");
	private SimpleDateFormat objectTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final File ORIGIN_FILE = new File("C:\\tmp\\Resource\\OriginFile.xlsx");
	private String newFileName;
	private String saveTime;
	
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	
	private OperatingSystemMXBean osBean = null;
	
	private final File HDDPATH = new File("/");
	
	private int cycle = 1; 
	
	private Date now;
	
	@Autowired
	private ServerInfoRepository sir;
	private ServerInfo si;
	
	@Scheduled(fixedDelay=30000)
	public void ServerResourceSaver() throws IOException, ParseException{
		osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		si = new ServerInfo();
		now = new Date();
		saveTime = dataTime.format(now);
		
		cpuDataInjector();
		sessionDataInjector();
		memoryDataInjector();
		hddDataInjector();
		sir.save(si);
		
		if(cycle == 6) {
			cycle = 0;
			ServerResourceWriter();
		} else if(cycle == 1) {
			fileCreate();
		}
		cycle++;
	}

	public void ServerResourceWriter() throws IOException {
		InputStream is = new FileInputStream(newFileName);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheet("Resource");
		/* CPU Row */
		XSSFRow cpuTimeRowNum = sheet.createRow(0);
		XSSFRow cpuRow = sheet.createRow(1);
		
		/* Session Row */
		XSSFRow sessionTimeRowNum = sheet.createRow(3);
		XSSFRow sessionDiskTotal = sheet.createRow(4);
		
		/* Memory Row */
		XSSFRow memoryTimeRowNum = sheet.createRow(6);
		XSSFRow memoryTotalPhysicalSize = sheet.createRow(7);
		XSSFRow memoryFreePhysicalSize = sheet.createRow(8);
		XSSFRow memoryUsagePercent = sheet.createRow(9);
		XSSFRow memoryIdelPercent = sheet.createRow(10);
		
		/* HDD Row */
		XSSFRow hddTimeRowNum = sheet.createRow(12);
		XSSFRow hddDiskTotal = sheet.createRow(13);
		XSSFRow hddDiskUsage = sheet.createRow(14);
		XSSFRow hddDiskIdle = sheet.createRow(15);
		XSSFRow hddDiskUsagePercent = sheet.createRow(16);
		XSSFRow hddDiskIdelPercent = sheet.createRow(17);
		
		cpuCellCreator(cpuTimeRowNum, cpuRow);
		sessionCellCreator(sessionTimeRowNum, sessionDiskTotal);
		memoryCellCreator(memoryTimeRowNum, memoryTotalPhysicalSize, memoryFreePhysicalSize, memoryUsagePercent, memoryIdelPercent);
		hddCellCreator(hddTimeRowNum, hddDiskTotal, hddDiskUsage, hddDiskIdle, hddDiskUsagePercent, hddDiskIdelPercent);
		try {
			fos = new FileOutputStream(newFileName);
			workbook.write(fos);
			fos.close();
			workbook.close();
			System.out.println("Excel Data Inject Success");
		} catch(Exception e) {
			System.out.println("엑셀 파일 데이터 입력 실패 ! >> "+e);
		}
		cpuData.clear();
		sessionData.clear();
		memoryData.clear();
		memoryDataMap.clear();
		hddData.clear();
		hddDataMap.clear();
	}


	private void memoryCellCreator(XSSFRow memoryTimeRowNum, XSSFRow memoryTotalPhysicalSize, XSSFRow memoryFreePhysicalSize, XSSFRow memoryUsagePercent, XSSFRow memoryIdelPercent) {
		XSSFCell memoryTimeRowNumCell = memoryTimeRowNum.createCell(0);
		XSSFCell memoryTotalPhysicalSizeCell = memoryTotalPhysicalSize.createCell(0);
		XSSFCell memoryFreePhysicalSizeCell = memoryFreePhysicalSize.createCell(0);
		XSSFCell memoryUsagePercentCell = memoryUsagePercent.createCell(0);
		XSSFCell memoryIdelPercentCell = memoryIdelPercent.createCell(0);
		
		memoryTimeRowNumCell.setCellValue("Memory Check Time");
		memoryTotalPhysicalSizeCell.setCellValue("TotalPhysicalMemorySize(단위 : GB)");
		memoryFreePhysicalSizeCell.setCellValue("FreePhysicalMemorySize(단위 : GB)");
		memoryUsagePercentCell.setCellValue("UsagePercent(단위 : %)");
		memoryIdelPercentCell.setCellValue("IdlePercent(단위 : %)");
		
		int i=1;
		String key;
		for(Map.Entry<String, Map<String, Integer>> entry : memoryData.entrySet()) {
			key = entry.getKey();
			memoryTimeRowNumCell = memoryTimeRowNum.createCell(i);
			memoryTotalPhysicalSizeCell = memoryTotalPhysicalSize.createCell(i);
			memoryFreePhysicalSizeCell = memoryFreePhysicalSize.createCell(i);
			memoryUsagePercentCell = memoryUsagePercent.createCell(i);
			memoryIdelPercentCell = memoryIdelPercent.createCell(i);
			
			memoryTimeRowNumCell.setCellValue(key);
			
			memoryTotalPhysicalSizeCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			memoryTotalPhysicalSizeCell.setCellValue(entry.getValue().get("memoryTotalPhysicalSize"+i));
			
			memoryFreePhysicalSizeCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			memoryFreePhysicalSizeCell.setCellValue(entry.getValue().get("memoryFreePhysicalSize"+i));
			
			memoryUsagePercentCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			memoryUsagePercentCell.setCellValue(entry.getValue().get("memoryUsagePercent"+i));
			
			memoryIdelPercentCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			memoryIdelPercentCell.setCellValue(entry.getValue().get("memoryIdelPercent"+i));
			i++;
		}
	}
	
	private void sessionCellCreator(XSSFRow sessionTimeRowNum, XSSFRow sessionDiskTotal) {
		XSSFCell sessionTimeDataCell = sessionTimeRowNum.createCell(0);
		XSSFCell sessionDiskTotalCell = sessionDiskTotal.createCell(0);
		
		sessionTimeDataCell.setCellValue("Session Check Time");
		sessionDiskTotalCell.setCellValue("Session Count");
		
		int i = 1;
		for(Map.Entry<String, Integer> entry : sessionData.entrySet()) {
			sessionTimeDataCell = sessionTimeRowNum.createCell(i);
			sessionDiskTotalCell = sessionDiskTotal.createCell(i);
			
			sessionTimeDataCell.setCellValue(entry.getKey());
			sessionDiskTotalCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			sessionDiskTotalCell.setCellValue(entry.getValue());
			i++;
		}
	}

	public void hddCellCreator(XSSFRow hddTimeRowNum, XSSFRow hddDiskTotal, XSSFRow hddDiskUsage, XSSFRow hddDiskIdle, XSSFRow hddDiskUsagePercent, XSSFRow hddDiskIdelPercent) {
		XSSFCell hddTimeDataCell = hddTimeRowNum.createCell(0);
		XSSFCell hddDiskTotalCell = hddDiskTotal.createCell(0);
		XSSFCell hddDiskUsageCell = hddDiskUsage.createCell(0);
		XSSFCell hddDiskIdleCell = hddDiskIdle.createCell(0);
		XSSFCell hddDiskUsagePercentCell = hddDiskUsagePercent.createCell(0);
		XSSFCell hddDiskIdelPercentCell = hddDiskIdelPercent.createCell(0);
		
		hddTimeDataCell.setCellValue("HDD Check Time");
		hddDiskTotalCell.setCellValue("HDD Total(단위 : GB)");
		hddDiskUsageCell.setCellValue("HDD Usage(단위 : GB)");
		hddDiskIdleCell.setCellValue("HDD Idel(단위 : GB)");
		hddDiskUsagePercentCell.setCellValue("HDD Usage Percent(단위 : %)");
		hddDiskIdelPercentCell.setCellValue("HDD Idel Percent(단위 : %)");
		
		int i=1;
		String key;
		for(Map.Entry<String, Map<String, Integer>> entry : hddData.entrySet()) {
			key = entry.getKey();
			hddTimeDataCell = hddTimeRowNum.createCell(i);
			hddDiskTotalCell = hddDiskTotal.createCell(i);
			hddDiskUsageCell = hddDiskUsage.createCell(i);
			hddDiskIdleCell = hddDiskIdle.createCell(i);
			hddDiskUsagePercentCell = hddDiskUsagePercent.createCell(i);
			hddDiskIdelPercentCell = hddDiskIdelPercent.createCell(i);
			
			hddTimeDataCell.setCellValue(key);
			hddDiskTotalCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			hddDiskTotalCell.setCellValue(entry.getValue().get("hddDiskTotal"+i));
			
			hddDiskUsageCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			hddDiskUsageCell.setCellValue(entry.getValue().get("hddDiskUsage"+i));
			
			hddDiskIdleCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			hddDiskIdleCell.setCellValue(entry.getValue().get("hddDiskIdle"+i));
			
			hddDiskUsagePercentCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			hddDiskUsagePercentCell.setCellValue(entry.getValue().get("hddDiskUsagePercent"+i));
			
			hddDiskIdelPercentCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			hddDiskIdelPercentCell.setCellValue(entry.getValue().get("hddDiskIdelPercent"+i));
			i++;
		}
	}
	
	public void cpuCellCreator(XSSFRow cpuTimeRowNum, XSSFRow cpuRow) {
		XSSFCell cpuTimeDataCell = cpuTimeRowNum.createCell(0);
		XSSFCell cpuDataCell = cpuRow.createCell(0);
		cpuTimeDataCell.setCellValue("CPU Check Time");
		cpuDataCell.setCellValue("CPU Usage");
		
		int i = 1;
		for(Map.Entry<String, Double> entry : cpuData.entrySet()) {
			cpuTimeDataCell = cpuTimeRowNum.createCell(i);
			cpuDataCell = cpuRow.createCell(i);
			
			cpuTimeDataCell.setCellValue(entry.getKey());
			cpuDataCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cpuDataCell.setCellValue(entry.getValue());
			i++;
		}
	}
	
	public void fileCreate(){
		newFileName = "C:\\tmp\\Resource\\ServerResourceData_"+fileTime.format(new Date())+".xlsx";
		File newFile = new File(newFileName);
		try {
			fis = new FileInputStream(ORIGIN_FILE);
			fos = new FileOutputStream(newFile);
		
			byte buffer[] = new byte[1024];
			int read;
			
			while((read = fis.read(buffer)) > 0 ) {
				fos.write(buffer, 0, read);
			}
		} catch(IOException ioe) {
			System.out.println("엑셀 파일 생성 실패 ! ==> "+ioe);
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			}catch(IOException ioe) {
				
			}
		}
	}
	
	public void cpuDataInjector() throws ParseException {
		double cpuUsage = Math.round((osBean.getSystemCpuLoad() * 100)*100)/100.0;
		si.setDataCheckTime(objectTime.format(now));
		//si.setDataCheckTime(now);
		si.setCpuUsage(cpuUsage);
		cpuData.put(saveTime, cpuUsage);
	}

	private void sessionDataInjector() {
		int sessionCount = SessionCount.getCount();
		si.setSessionCount(sessionCount);
		System.out.println("session Count : "+sessionCount);
		sessionData.put(saveTime, sessionCount);
	}

	private void memoryDataInjector() {
		int memoryTotalSize = (int) Math.round( osBean.getTotalPhysicalMemorySize() / (1024*1024) / 1000.0);
		int memoryFreeSize = (int) Math.round( osBean.getFreePhysicalMemorySize() / (1024*1024) / 1000.0);
		int memoryUsagePercent = (int) Math.round( ( Double.valueOf(osBean.getTotalPhysicalMemorySize() - osBean.getFreePhysicalMemorySize() ) ) / Double.valueOf( osBean.getTotalPhysicalMemorySize() ) * 100);
		int memoryIdelPercent = (int) Math.round( Double.valueOf(osBean.getFreePhysicalMemorySize()) / Double.valueOf( osBean.getTotalPhysicalMemorySize() ) * 100);
		
		si.setMemoryTotalSize(memoryTotalSize);
		si.setMemoryFreeSize(memoryFreeSize);
		si.setMemoryUsagePercent(memoryUsagePercent);
		si.setMemoryIdelPercent(memoryIdelPercent);
		memoryDataMap.put("memoryTotalPhysicalSize"+cycle, memoryTotalSize);
		memoryDataMap.put("memoryFreePhysicalSize"+cycle, memoryFreeSize);
		memoryDataMap.put("memoryUsagePercent"+cycle, memoryUsagePercent);
		memoryDataMap.put("memoryIdelPercent"+cycle, memoryIdelPercent);
		
		memoryData.put(saveTime, memoryDataMap);
	}
	
	
	public void hddDataInjector() {
		int hddTotal = (int) Math.round( HDDPATH.getTotalSpace()/(1024*1024) / 1000.0 );
		int hddUsage = Math.round( Math.round( (HDDPATH.getTotalSpace() - HDDPATH.getUsableSpace())/(1024*1024)/ 1000.0));
		int hddIdle = Math.round( Math.round( HDDPATH.getUsableSpace()/(1024*1024) / 1000.0 ));
		int hddUsagePercent = Math.round( Math.round( Double.valueOf(HDDPATH.getTotalSpace() - HDDPATH.getUsableSpace()) / Double.valueOf(HDDPATH.getTotalSpace()) * 100));
		int hddIdlePercent = Math.round( Math.round( Double.valueOf(HDDPATH.getUsableSpace()) / Double.valueOf(HDDPATH.getTotalSpace()) * 100));
		
		si.setHddTotal(hddTotal);
		si.setHddUsage(hddUsage);
		si.setHddIdle(hddIdle);
		si.setHddUsagePercent(hddUsagePercent);
		si.setHddIdlePercent(hddIdlePercent);
		hddDataMap.put("hddDiskTotal"+cycle, hddTotal);
		hddDataMap.put("hddDiskUsage"+cycle, hddUsage);
		hddDataMap.put("hddDiskIdle"+cycle, hddIdle);
		hddDataMap.put("hddDiskUsagePercent"+cycle, hddUsagePercent);
		hddDataMap.put("hddDiskIdelPercent"+cycle, hddIdlePercent);
		
		hddData.put(saveTime, hddDataMap);
	}
}
