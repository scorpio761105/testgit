package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.mapper.UsersMapper;
import com.guigu.pojo.Users;
import com.guigu.service.UsersService;
//@Component
@Service
public class UsersServiceImpl implements UsersService{
//	@Resource
//	@Qualifier
	@Autowired
	private UsersMapper usersMapper= null;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void addUsers(Users users) {
		usersMapper.saveUsers(users);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void removeUsersByUid(int uid) {
		usersMapper.deleteUsersByUid(uid);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void modifyUsers(Users users) {
		usersMapper.updateUsers(users);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public Users findUsersByUid(int uid) {
		Users users = usersMapper.selectUsersByUid(uid);
		return users;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public List<Users> findAllUsers() {
		return usersMapper.selectAllUsers();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void testTransacation(Users users, int id) {
		usersMapper.deleteUsersByUid(id);
		usersMapper.saveUsers(users);
	}

}
