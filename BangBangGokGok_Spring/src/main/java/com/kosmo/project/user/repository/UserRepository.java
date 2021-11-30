package com.kosmo.project.user.repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.kosmo.project.user.model.UserVO;

@Repository
public class UserRepository {

	private static SqlSessionFactory sqlMapper;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			String resource = "mybatis/mybatis-config.xml";
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}


	public List<UserVO> selectAll() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		return session.selectList("User.selectAllUsers");
	}


	public UserVO select(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		UserVO user = (UserVO) session.selectOne("User.selectUser", vo);
		return user;
	}

	public void insert(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("User.insertUser", vo);
		session.commit();
	}

	public void update(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("User.udpateUser", vo);
		session.commit();
	}

	public void delete(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("User.deleteUser", vo);
		session.commit();
	}

	public UserVO chkUser(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		UserVO user = (UserVO) session.selectOne("User.chkUser", vo);
		return user;
	}
	public UserVO createUser(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		UserVO user = (UserVO) session.selectOne("User.createUser", vo);
		return user;
	}


}
