package com.kosmo.project.boardtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kosmo.project.boardtest.serverinfo.ServerInfo;
import com.kosmo.project.boardtest.serverinfo.ServerInfoRepository;

@Service("ServerInfoService")
public class ServerInfoServiceImpl implements ServerInfoService{
	@Autowired
	private ServerInfoRepository sir;

	@Override
	public ServerInfo save(ServerInfo si) {
		return sir.save(si);
	}

	@Override
	public Long count() {
		return sir.count();
	}

	@Override
	public ServerInfo findByServerInfoId(int ServeerInfoId) {
		return sir.findByServerInfoId(ServeerInfoId);
	}

	@Override
	public Page<ServerInfo> findAll(Pageable pageable) {
		return sir.findAll(pageable);
	}

	
}
