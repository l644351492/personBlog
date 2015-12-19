package com.myblog.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TestUserMapper {
	
	
	 /**
     * 测试用例: 测试getTargetUserByUsernameAndPassword方法
     * 测试数据: 使用用户名为"zjm",密码为"123456"的数据
     * 预期结果: 返回一个User对象
     */
	@Test
	public void testGetTargetUserByUsernameAndPassword(){
		User user ;
		user = userMapper.getTargetUserByUsernameAndPassword("ljm", "123456");
		assertNotNull(user);
		
	}
	
	 /**
     * 测试用例: 测试getTargrtUserByUid方法
     * 测试数据: 用户Id为1的测试数据
     * 预期结果: 返回一个User对象
     */
	@Test
	public void testGetTargrtUserByUid(){
		User user ;
		user = userMapper.getTargrtUserByUid(1);
		System.out.println(user.getUsername());
		assertNotNull(user);
		
	}
	
	/**
	 * 自动装配的分类管理Mapper层
	 */
	@Autowired
	private UserMapper userMapper;

}
