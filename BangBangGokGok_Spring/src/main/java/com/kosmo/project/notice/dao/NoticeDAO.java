package com.kosmo.project.notice.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.kosmo.project.notice.model.NoticeVO;

@Repository
public class NoticeDAO {

	private static SqlSessionFactory sqlMapper;
	
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			String resource = "mybatis/mybatis-config.xml";
			Reader reader;
			try {
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public void insert(NoticeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("Notice.insertNotice",vo);
		session.commit();
	}
	
	public void update(NoticeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		System.out.println(vo);
		session.update("Notice.updateNotice", vo);
		session.commit();
	}
	
	public void delete(NoticeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("Notice.deleteNotice", vo);
		session.commit();
	}
	
	public NoticeVO select(NoticeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		NoticeVO articleNotice = (NoticeVO) session.selectOne("Notice.selectNotice", vo);
		return articleNotice;
	}

	
	public List<NoticeVO> selectArticleList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<NoticeVO> articleList = null;
		articleList = session.selectList("Notice.getNoticeList");
		return articleList;
	}
	
	public int totalArticleCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int totalArticleCount = (Integer) session.selectOne("Notice.totalNoticeCount");
		return totalArticleCount;
	}
	public void countUp(NoticeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("Notice.boardCountUp", vo);
		session.commit();
	}
	
	public List<NoticeVO> pageNationNotice(int page) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<NoticeVO> articleList = session.selectList("Notice.pageNation", (page-1)*10);
		return articleList;
	}
}
