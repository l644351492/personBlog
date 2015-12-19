package com.myblog.mapper;

import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TestMessageMapper {

	 /**
     * 测试用例: 测试getMessageList方法
     * 测试数据: 查询所有message
     * 预期结果: 返回一个Message对象列表，列表非空
     */
	@Test
	public void testGetMessageList(){
		List<Message> list = messageMapper.getMessageList();
		System.out.println(list.size());
	}
	
	 /**
     * 测试用例: 测试insertMessage方法
     * 测试数据: 一个Message对象
     * 预期结果: 返回 1 (影响数据库的行数)
     */
	@Test
	public void testInsertMessage(){
		Message message = new Message();
		message.setMessagerNickname("wer");
		message.setMessageContent("qewr");
		message.setMessageTime(new Date());
	    int affectRows = messageMapper.insertMessage(message);
	    assertFalse(affectRows != 1);
	}
	
	/**
	 * 自动装配的messageMapper对象
	 */
	@Autowired
	private MessageMapper messageMapper;

}
