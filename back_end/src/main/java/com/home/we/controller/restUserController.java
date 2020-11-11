package com.home.we.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.we.dto.MemVO;
import com.home.we.service.IMemberService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController	//여기가 컨트롤러라고 알려주는 어노테이션 사용
public class restUserController {
	
	@Autowired	//객체 주입
	private IMemberService ser;
	
	@PostMapping(value = "/SignUp")	//post로 RequestMapping
	public ResponseEntity<String> insert(@RequestBody MemVO mem) {	//@RequestBody-HTTP 요청을 자바 객체로 변환
		ResponseEntity<String> re = null;
		try {
			//서비스로 보낸다
			ser.addMem(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			// HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@PostMapping(value = "/Login")
	public boolean login(@RequestBody MemVO mem) {
		String id = mem.getId();
		String pw = mem.getPw();
		System.out.println(id+" "+pw);
		ResponseEntity<String> re = null;
		try {
			boolean isLogin = ser.loginMem(id, pw);
			return isLogin;
		} catch (Exception e) {
			// HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
			return false;
		}
	}
}
