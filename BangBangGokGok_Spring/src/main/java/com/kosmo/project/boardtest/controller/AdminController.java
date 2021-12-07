package com.kosmo.project.boardtest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kosmo.project.boardtest.manager.Manager;
import com.kosmo.project.boardtest.manager.ManagerRepository;
import com.kosmo.project.boardtest.modulefunc.ModuleFunc;
import com.kosmo.project.boardtest.serverinfo.ServerInfo;
import com.kosmo.project.boardtest.serverinfo.ServerInfoRepository;
import com.kosmo.project.boardtest.tmpboard.TmpBoard;
import com.kosmo.project.boardtest.tmpboard.TmpBoardRepository;
import com.kosmo.project.boardtest.users.Users;
import com.kosmo.project.boardtest.users.UsersRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired private TmpBoardRepository tbr;
	@Autowired private ModuleFunc mf;
	@Autowired private ServerInfoRepository sir;
	@Autowired private ManagerRepository mr;
	@Autowired private UsersRepository ur;
	
	private int serverInfoCount = 0; // ServerInfo count
	
	private final String FILE_UPLOAD_PATH = "C:\\tmp\\upload\\";
	
	//해당 폴더 없을시 폴더 자동 생성
	public AdminController() {
		// TODO Auto-generated constructor stub
		Path path1 = Paths.get(FILE_UPLOAD_PATH);
		try {
			Files.createDirectories(path1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path path2 = Paths.get("C:\\tmp\\Resource\\");
		try {
			Files.createDirectories(path2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/*.do",method=RequestMethod.GET)
	public String GetRequest(HttpServletRequest request, Model model, @RequestParam(value = "page", defaultValue = "1") int pageNum, Principal principal) {
		String requestPath = request.getRequestURI();
		if(requestPath.equals("/admin/insertBoard.do")) {
			model.addAttribute("username", principal.getName());
			return "/admin/insertBoard"; 
		} else if(requestPath.equals("/admin/board.do")) {
			mf.paging(model, pageNum, "board");
			return "/admin/board";
		} else if(requestPath.equals("/admin/getBoard.do")) {
			model.addAttribute("TmpBoard", tbr.findByArticleNo(Integer.parseInt(request.getParameter("index")))).addAttribute("index", request.getParameter("index"));
			return "/admin/getBoard";
		} else if(requestPath.equals("/admin/updateBoard.do")) {
			model.addAttribute("TmpBoard", tbr.findByArticleNo(Integer.parseInt(request.getParameter("index")))).addAttribute("index", request.getParameter("index"));
			return "/admin/updateBoard";
		} else if(requestPath.equals("/admin/deleteBoard.do")) {
			tbr.delete(Integer.parseInt(request.getParameter("index")));
			return "redirect:/admin/board.do";
		} 
		return "error";
	}
		
	@RequestMapping(value="/next.do")
	public String next(HttpServletRequest request, Model model) {
		int pageNum = Integer.parseInt(request.getParameter("page"))-1;
		pageNum = pageNum+1+(10-(pageNum%10));
		
		return "redirect:/admin/board.do?page="+pageNum;
	}
	
	@RequestMapping(value="/previous.do")
	public String previous(HttpServletRequest request, Model model) {
		int pageNum = Integer.parseInt(request.getParameter("page"));
		System.out.println("pageNum : " + pageNum);
		
		if(pageNum % 10 == 0) pageNum -= 1;
		
		pageNum = (pageNum-(pageNum%10))-9; 
		
		return "redirect:/admin/board.do?page="+pageNum;
	}
	
	@RequestMapping(value= {"/insertBoard.do", "/updateBoard.do"}, method=RequestMethod.POST)
	public String insertBoardPost(TmpBoard tmpBoard, @RequestParam("uploadFile") MultipartFile mf, HttpServletRequest request) throws IllegalStateException, IOException {
		
		if(mf.getSize() != 0) {
			System.out.println("file name : "+mf.getOriginalFilename());
			File file = new File(FILE_UPLOAD_PATH+mf.getOriginalFilename());
			tmpBoard.setArticleImage(mf.getOriginalFilename());
			mf.transferTo(file);
		}
		
		tbr.save(tmpBoard);
		return "redirect:/admin/board.do";
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String header = request.getHeader("User-Agent");
		String fileName = request.getParameter("fileName");
		
		if(fileName != null) {
			fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		}
		
		FileInputStream fis = null;
		OutputStream fos = null;
		String filePath = FILE_UPLOAD_PATH+fileName;
		try {
		 	File file = new File(filePath);
		 	long fileLength = file.length();
		 	
		 	if(header.contains("Chrome")) {
		 		fileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
		 		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		 	}
		 	response.setContentType("application/octet-stream");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Length", "" + fileLength);
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");
	       	fis = new FileInputStream(filePath);
	       	fos = response.getOutputStream();
	        	
	       	int read = 0;
	        byte buffer[] = new byte[1024];
	        while ((read = fis.read(buffer)) != -1) {
	        	fos.write(buffer, 0, read);
	        }
	        
        } catch (Exception e) {
            throw new Exception("download error");
        } finally {
        	if(fis != null) {
        		fis.close();
        	}
        	if(fos != null) {
        		fos.close();
        	}
        }
	}
	
	@RequestMapping(value="/boardSearch.do", method=RequestMethod.POST)
	public void boardSearch(String searchCondition, String searchText, Model model) {
		System.out.println("####### [boardSearch]");
		System.out.println("searchCondition : "+searchCondition);
		System.out.println("searchText : "+searchText);
		
		if(searchCondition.equals("writer")) {
//			mf.paging(model, pageNum, url);
		}
		
	}
		
	/* =========== admin Level AA =========== */
	@RequestMapping(value="/adminAa/dashboard.do", method=RequestMethod.GET)
	public String dashboard(Authentication authentication) {
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		System.out.println("authToken.getName() : "+authToken.getName());
		System.out.println(""+authToken.getAuthorities());
		return "/admin/adminAa/dashboard";
	}
	
	@RequestMapping(value="/adminAa/cpuChartData.do", method=RequestMethod.POST)
	@ResponseBody
	public List<ServerInfo> cpuChartDataPost() {
		Pageable pageable = null;
		Page<ServerInfo> page = null;
		
		if(serverInfoCount <= 10) {
			serverInfoCount = Math.toIntExact(sir.count());
			pageable = new PageRequest(0, serverInfoCount, new Sort(Direction.DESC, "serverInfoId"));
			page = sir.findAll(pageable);
		} else {
			pageable = new PageRequest(0, 10, new Sort(Direction.DESC, "serverInfoId"));
			page = sir.findAll(pageable);
		}
		return page.getContent();
	}
	

	/* ================================================ */
	
	@RequestMapping(value="/adminSa/accountEnableInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public void accountEnableInfo(@RequestBody List<Map<String, String>> UserInfo) {
		System.out.println("############## [accountEnableInfo] : ");
		System.out.println("UserInfo : "+UserInfo);
		
		Iterator<Map<String, String>> it = UserInfo.iterator();
		while(it.hasNext() ) {
			Map<String, String> userMap = new HashMap<String, String>(); 
			userMap = it.next();
			String username = userMap.get("username");
			String enabled = userMap.get("enabled");
			System.out.println(username+" : "+enabled);
			
			ur.updateEnabled(username, Boolean.parseBoolean(enabled));
		}
	}
	
	@RequestMapping(value="/adminSa/accountEnableSet.do", method=RequestMethod.GET)
	public List[] accountEnableSet(Model model) {
		System.out.println("###### [accountEnableSet] ");
		
		model.addAttribute("UsersList", ur.findByAdmin("Y")).addAttribute("ManagerList", mr.findAll());
		List[] toSend = {ur.findByAdmin("Y"), mr.findAll()};
		return toSend;
	}
}

