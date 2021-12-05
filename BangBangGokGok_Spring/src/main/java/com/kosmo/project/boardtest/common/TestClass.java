package com.kosmo.project.boardtest.common;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.management.OperatingSystemMXBean;

public class TestClass{
	
	public static void main(String[] args) {
		String retult = (5 > 3) ? "true" : "false";
		
		System.out.println("result : "+retult);
//		Date now = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분");
//		System.out.println(sdf.format(now));
//		
//        try{
//            OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//            File f = new File("/");
//            for(int i=0;i<100;i++){
//                System.out.println("***********************************************************");
//                System.out.println("CPU Usage : " + String.format("%.2f", osBean.getSystemCpuLoad() * 100));
////                System.out.println("Memory Free Space : " + String.format("%.2f", (double)osBean.getFreePhysicalMemorySize()/1024/1024/1024  ));
////                System.out.println("Memory Total Space : " + String.format("%.2f", (double)osBean.getTotalPhysicalMemorySize()/1024/1024/1024  ));
//                
//                System.out.println("HDD ==============================");
//                System.out.println("- Total : " + Math.round( f.getTotalSpace()/(1024*1024) / 1000.0 ) + "(GB)");
//                System.out.println("- Usage : " + Math.round( (f.getTotalSpace() - f.getUsableSpace())/(1024*1024)/ 1000.0) + "(GB)");
//                System.out.println("- Idle  : " + Math.round( f.getUsableSpace()/(1024*1024) / 1000.0 ) + "(GB)");
//                System.out.println("- Usage Percent : " + Math.round( Double.valueOf(f.getTotalSpace() - f.getUsableSpace())/ Double.valueOf(f.getTotalSpace()) * 100) + "%"   );
//                System.out.println("- Idle  Percent : " + Math.round( Double.valueOf(f.getUsableSpace()) / Double.valueOf(f.getTotalSpace()) * 100) + "%\n" );
//                
//                
//                System.out.println("Memory============================");
//                System.out.println("- TotalPhysicalMemorySize: " + Math.round( osBean.getTotalPhysicalMemorySize() / (1024*1024) / 1000.0) + "(GB)"); 
//                System.out.println("- FreePhysicalMemorySize: " + Math.round( osBean.getFreePhysicalMemorySize() / (1024*1024) / 1000.0) + "(GB)");
//                System.out.println("- Usage Percent : " + Math.round( ( Double.valueOf(osBean.getTotalPhysicalMemorySize() - osBean.getFreePhysicalMemorySize() ) ) / Double.valueOf( osBean.getTotalPhysicalMemorySize() ) * 100) + "%");
//                System.out.println("- Idle  Percent : " + Math.round( Double.valueOf(osBean.getFreePhysicalMemorySize()) / Double.valueOf( osBean.getTotalPhysicalMemorySize() ) * 100) + "%");
//                
//                Thread.sleep(1500);
//            }
//
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
		
	}
}
