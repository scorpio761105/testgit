package com.guigu.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.guigu.pojo.Users;
//@Component
@Repository
public interface UsersMapper {
	public void saveUsers(Users users);
	public void deleteUsersByUid(int uid);
	public void updateUsers(Users users);
	public Users selectUsersByUid(int uid);
	public List<Users> selectAllUsers();
}
