package com.kosmo.project.boardtest.users;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{
	public Users findOne(String user_id);
	
	public Users findByUserId(String user_id);
	
	public Users save(Users user);
	
	public List<Users> findAll();
	
	public List<Users> findByAdmin(String admin);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users SET enabled = ?2 WHERE user_id = ?1")
	public int updateEnabled(String user_id, Boolean enabled);
}
