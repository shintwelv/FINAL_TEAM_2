package com.kosmo.project.boardtest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kosmo.project.boardtest.serverinfo.ServerInfo;

public interface ServerInfoService {
	public ServerInfo save(ServerInfo si);
	
	public Long count();
	
	public ServerInfo findByServerInfoId(int ServeerInfoId);
	
	public Page<ServerInfo> findAll(Pageable pageable);
}
