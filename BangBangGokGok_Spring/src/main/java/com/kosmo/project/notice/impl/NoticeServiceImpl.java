package com.kosmo.project.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.project.notice.dao.NoticeDAO;
import com.kosmo.project.notice.model.NoticeVO;

@Service("service")
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public void insert(NoticeVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(NoticeVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(NoticeVO vo) {
		dao.update(vo);
	}
	
	@Override
	public NoticeVO select(NoticeVO vo) {
		NoticeVO board = dao.select(vo);
		return board;
	}
	
	@Override
	public List<NoticeVO> selectArticleList() {
		List<NoticeVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	@Override
	public List<NoticeVO> pageNationNotice(int page) {
		List<NoticeVO> articleList = null;
		articleList = dao.pageNationNotice(page);
		return articleList;
	}
	@Override
	public void countUp(NoticeVO vo) {
		dao.countUp(vo);
	}
	
	@Override
	public int totalPage() {
		int totalArticleCount = dao.totalArticleCount();
		int totalPage = (totalArticleCount - (totalArticleCount%10))/10;
		if (totalArticleCount%10 != 0) {
			totalPage++;
		}
		return totalPage;
	}
	
}
