package com.myblog.mapper;

import org.apache.ibatis.annotations.Param;

import com.myblog.model.User;

/**
 * 用户管理Mapper
 * @author 2012216954
 *
 */
public interface UserMapper {
	
	/**
	 * 通过表单提交过来的用户名和密码去数据库中查询用户
	 * @param username - 用户名
	 * @param password - 密码
	 * @return 如果在数据库中查到数据，则返回一个用户对象，否则，返回null
	 */
	public User getTargetUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	/**
	 * 根据用户Id选择用户对象
	 * @param uid - 用户Id
	 * @return
	 */
	public User getTargrtUserByUid(int uid);

}
