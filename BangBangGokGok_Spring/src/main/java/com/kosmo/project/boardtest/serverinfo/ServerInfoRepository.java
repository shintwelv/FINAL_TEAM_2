package com.kosmo.project.boardtest.serverinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerInfoRepository extends JpaRepository<ServerInfo, Integer>{
	public ServerInfo save(ServerInfo si);
	
	public long count();
	
	public ServerInfo findByServerInfoId(int ServeerInfoId);
	
	public Page<ServerInfo> findAll(Pageable pageable);
}