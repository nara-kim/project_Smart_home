package com.home.we.service;

public interface IMemberService {
	boolean addMem(String id, String pw, String name, String email);
	boolean loginMem(String id, String pw);
}
