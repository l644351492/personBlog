package com.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.mapper.UserMapper;
import com.myblog.model.User;
/**
 * 用户管理服务层
 * @author 2012216954
 *
 */
@Service
public class UserService {
	
	/**
	 * 通过表单提交过来的用户名和密码去数据库中查询用户
	 * @param username - 用户名
	 * @param password - 密码
	 * @return 如果在数据库中查到数据，则返回一个用户对象，否则，返回null
	 */
	public User getTargetUserByUsernameAndPassword(String username, String password){
		return userMapper.getTargetUserByUsernameAndPassword(username, password);
	}
	
	/**
	 * 自动装配的用户Mapper层
	 */
    @Autowired
	private UserMapper userMapper;

}


