package org.mymvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mymvc.dao.UserDao;
import org.mymvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring_dao.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	
	@Test
	public void userAdd(){
		User user=new User();
		user.setUserId(2000L);
		user.setScore(888);
		user.setUserName("Ê¯Ã÷");
		user.setUserPhone(18969023769L);
		userDao.insert(user);
	}

	@Test
	public void selectById(){
		User user=userDao.selectByPrimaryKey(2000L);
		System.out.println(user);
	}
}
 