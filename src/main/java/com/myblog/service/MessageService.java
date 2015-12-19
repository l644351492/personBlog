package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.mapper.MessageMapper;
import com.myblog.model.Message;
/**
 * 留言管理服务层
 * @author 2012216954
 *
 */
@Service
public class MessageService {
	
	/**
	 * 获得留言列表
	 * @return 留言列表
	 */
	public List<Message> getMessageList(){
		return messageMapper.getMessageList();
	}
	
	/**
	 * 插入留言
	 * @param nickName - 留言者昵称
	 * @param messageContent - 留言内容
	 * @return 影响数据库的行数
	 */
	public int insertMessage(String nickName, String messageContent){
		Message message = new Message();
		message.setMessagerNickname(nickName);
		message.setMessageContent(messageContent);
		return messageMapper.insertMessage(message);
	}

	/**
	 * 自动装配的messageMapper对象
	 */
	@Autowired
	private MessageMapper messageMapper;
}
