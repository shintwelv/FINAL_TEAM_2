package com.kosmo.project.boardtest.modulefunc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo.project.boardtest.tmpboard.TmpBoard;
import com.kosmo.project.boardtest.tmpboard.TmpBoardRepository;
import com.kosmo.project.boardtest.users.UsersRepository;

@Service("ModuleFunc")
//@Getter @Setter
public class ModuleFuncImpl implements ModuleFunc{

	@Autowired private TmpBoardRepository tbr;
	
	@Override
	public void paging(Model model, int pageNum, String url) {
		int requestPage = pageNum;
		Pageable pageable = new PageRequest(pageNum-1, 10, new Sort(Direction.DESC, "articleNo"));
		
		Page<TmpBoard> page = null;
		if(url.equals("board")) {
			page = tbr.findAll(pageable);
		} else if(url.equals("")) {
			
		}

		
		pageNum = (pageNum-1) / 10;
		
		Map<String, Integer> pageRange = new HashMap<String, Integer>();
		
		int bottom = (pageNum*10)+1;
		int top = bottom+9;
		if(top > page.getTotalPages()) top = page.getTotalPages();
		
		pageRange.put("top", top);
		pageRange.put("bottom", bottom);
		
		boolean hasPrevious = false, hasNext = false;
		if(page.getTotalElements() - top*10 >= 1) {
			hasNext = true;
		}
		
		if(bottom > 10) {
			hasPrevious = true;
		}
				
		model.addAttribute("pageRange", pageRange).addAttribute("tbsList", page.getContent()).addAttribute("page", requestPage).
		addAttribute("hasPrevious", hasPrevious).addAttribute("hasNext", hasNext);
	}

}
