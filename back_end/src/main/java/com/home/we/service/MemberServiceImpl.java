package com.home.we.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.we.dao.IMemberDao;


@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberDao man;

	@Override
	public boolean addMem(String id, String pw, String name, String email) {
		// TODO Auto-generated method stub
		//Dao로 보낸다(Repository)
		return man.addMem(id, pw, name, email);
	}

	@Override
	public boolean loginMem(String id, String pw) {
		// TODO Auto-generated method stub
		
		return man.loginMem(id, pw);
	}

}
