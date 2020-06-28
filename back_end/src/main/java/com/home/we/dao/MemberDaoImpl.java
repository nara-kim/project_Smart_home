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
		System.out.println("repository");

		MemVO m = new MemVO(id, pw, name, email);
		System.out.println(m.toString());
		int n = session.insert("member.insertMem", m);
		System.out.println("n?? " + n);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean loginMem(String id, String pw) {
		System.out.println("repository");
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		System.out.println("뭐야 왜이래");
		int n = session.selectOne("member.isLogin", map);
		System.out.println("이건?");
		System.out.println("nnnnnnnn  "+n);
		if (n == 1)
			return true;
		else
			return false;
	}

}
