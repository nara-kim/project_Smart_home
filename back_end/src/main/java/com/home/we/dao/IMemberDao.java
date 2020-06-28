package com.home.we.dao;

public interface IMemberDao {
	boolean addMem(String id, String pw, String name, String email);
	boolean loginMem(String id, String pw);
}
