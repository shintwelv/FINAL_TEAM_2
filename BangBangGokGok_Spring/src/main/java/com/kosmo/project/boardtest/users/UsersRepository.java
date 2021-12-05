package com.kosmo.project.boardtest.users;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{
	public Users findOne(String username);
	
	public Users findByUsername(String username);
	
	public Users save(Users user);
	
	public List<Users> findAll();
	
	@Transactional
	@Modifying
	@Query("UPDATE Users SET enabled = ?2 WHERE user_id = ?1")
	public int updateEnabled(String username, Boolean enabled);
}
