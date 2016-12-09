package org.mymvc.dao;

import org.mymvc.model.AccessToken;


public interface AccessTokenDao {
	/**
	 * access_token表新增方法
	 * @param accessToken
	 */
	void insertAccessToken(AccessToken accessToken);
	
	
	/**
	 * 获取最新的access_token记录
	 * @return
	 */
	AccessToken getAccessToken();
	
}
