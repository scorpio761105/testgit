package com.guigu.test;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guigu.mapper.UsersMapper;
import com.guigu.pojo.Users;
import com.guigu.service.UsersService;

public class TestSpringAndMyBatis {
	private Logger logger = Logger.getLogger(TestSpringAndMyBatis.class);
	private ApplicationContext context = null;
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}
	
	@Test
	public void testDataSource() {
		DataSource ds = (DataSource)context.getBean("dataSource");
		logger.debug(ds);
	}
	@Test
	public void testSessionFactory() {
		SqlSessionFactory factory = (SqlSessionFactory)context.getBean("sqlsessionFactory");
		logger.debug(factory);
	}
	@Test
	public void testUsersMapper() {
		UsersMapper mapper = (UsersMapper)context.getBean("usersMapper");
		List<Users> list = mapper.selectAllUsers();
		for (Users users : list) {
			logger.debug(users);
		}
		
//		Users users = new Users();
//		users.setUname("王涛");
//		users.setUpass("999");
//		users.setScore(99d);
//		users.setBirthday("2009-09-09");
//		dao.saveUsers(users);
	}
	
	@Test
	public void testUsersService() {
		UsersService service = (UsersService)context.getBean("usersServiceImpl");
		List<Users> list = service.findAllUsers();
		for (Users users : list) {
			logger.debug(users);
		}
		
//		service.findUsersByUid(10);
		
//		service.removeUsersByUid(7);
		
//		Users users = new Users();
//		users.setUname("王涛");
//		users.setUpass("999");
//		users.setScore(99d);
//		users.setBirthday("2009-09-09");
//		dao.saveUsers(users);
	}
	
	@Test
	public void testTransaction() {
		UsersService service = (UsersService)context.getBean("usersServiceImpl");
		Users users = new Users();
		users.setUname("王涛");
		users.setUpass("999");
		users.setScore(99d);
		users.setBirthday("2009-09-09");
		service.testTransacation(users, 1);
	}
}
