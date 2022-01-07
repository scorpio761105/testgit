package com.guigu.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.guigu.pojo.Users;
public interface UsersService {
	public void addUsers(Users users);
	public void removeUsersByUid(int uid);
	public void modifyUsers(Users users);
	public Users findUsersByUid(int uid);
	public List<Users> findAllUsers();
	
	public void testTransacation(Users users,int id);
}
