package com.kosmo.project.notice.impl;

import java.util.List;

import com.kosmo.project.notice.model.NoticeVO;

public interface NoticeService {

	void insert(NoticeVO vo);

	void delete(NoticeVO vo);

	void update(NoticeVO vo);

	NoticeVO select(NoticeVO vo);

	List<NoticeVO> selectArticleList();

	void countUp(NoticeVO vo);

	int totalPage();

	List<NoticeVO> pageNationNotice(int page, int size);

}