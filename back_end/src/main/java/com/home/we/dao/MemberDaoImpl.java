package com.home.we.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.we.dto.MemVO;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addMem(String id, String pw, String name, String email) {
		// TODO Auto-generated method stub
		
		//객체 하나 만들어주고
		MemVO m = new MemVO(id, pw, name, email);
		
		//session으로 간다(memberMapper.xml 보면 됨)
		int n = session.insert("member.insertMem", m);
		
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean loginMem(String id, String pw) {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		int n = session.selectOne("member.isLogin", map);
		if (n == 1)
			return true;
		else
			return false;
	}

}
