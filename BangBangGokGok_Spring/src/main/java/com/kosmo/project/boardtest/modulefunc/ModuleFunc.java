package com.kosmo.project.boardtest.modulefunc;

import org.springframework.ui.Model;

public interface ModuleFunc {
	public void paging(Model model, int pageNum, String url);

}
