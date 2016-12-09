package org.mymvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mymvc.dao.AccessTokenDao;
import org.mymvc.dao.UserDao;
import org.mymvc.model.AccessToken;
import org.mymvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring_dao.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private AccessTokenDao accessTokenDao;
	
	
    
	public void userAdd(){
		User user=new User();
		user.setUserId(2000L);
		user.setScore(888);
		user.setUserName("Ê¯Ã÷");
		user.setUserPhone(18969023769L);
		userDao.insert(user);
	}

	
	public void selectById(){
		User user=userDao.selectByPrimaryKey(2000L);
		System.out.println(user);
	}
	
	@Test
	public void selectAccessToken(){
		AccessToken accessToken=accessTokenDao.getAccessToken();
		System.out.println(accessToken);
	}
	
	@Test
	public void insertAccessToken(){
		AccessToken accessToken = new AccessToken();
		accessToken.setAccess_token("y6ru6GDEqPnKi3pY823NPzg00Uv0IlK38HubZepYXwOUFznRv3-__PS_XnlQ-BvWznCkFT2AOdY6I1zRiREPJHt7Ngi9BaMyvxBM9tg6KPoMi5A2-yKeZuHPLIts3rHFJOCgABAMRF");
		accessToken.setExpires_in(7200);
		accessTokenDao.insertAccessToken(accessToken);
	}
}
 