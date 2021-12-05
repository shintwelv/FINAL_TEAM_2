package com.kosmo.project.boardtest.manager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	public Manager findByAdminId(String adminId);
	
	public Manager save(Manager manager);
	
	public List<Manager> findAll();
}
