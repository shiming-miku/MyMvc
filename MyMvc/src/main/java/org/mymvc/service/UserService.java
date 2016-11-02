package org.mymvc.service;

import org.mymvc.model.User;

public interface UserService {

	/**
	 * 用户删除
	 * @param userId
	 * @return
	 */
    int deleteByPrimaryKey(Long userId);

    /**
     * 用户新增
     * @param record
     */
    void insert(User record);

    /**
     * 用户查询
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Long userId);

    /**
     * 用户更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
	
}
