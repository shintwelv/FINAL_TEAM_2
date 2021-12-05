package com.kosmo.project.boardtest.common;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCount implements HttpSessionListener {
	public static int count = 0;
	 
    public static int getCount() {
    	return count;
    }
 
    public void sessionCreated(HttpSessionEvent event) {        //�꽭�뀡�씠 留뚮뱾�뼱吏� �븣 �샇異�
        HttpSession session = event.getSession();
        session.setMaxInactiveInterval(60*20);

        count++;
        System.out.println("###############################################################");
        session.getServletContext().log(session.getId() + " 현재 연결된 세션 : " + count);
        System.out.println("###############################################################");
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {        //�꽭�뀡�씠 �냼硫몃맆 �븣 �샇異�
        count--;
        if(count<0)
            count=0;
         
        HttpSession session = event.getSession();
//        session.getServletContext().log(session.getId() + " �꽭�뀡�냼硫� " + ", �젒�냽�옄�닔 : " + count);
    }
}
