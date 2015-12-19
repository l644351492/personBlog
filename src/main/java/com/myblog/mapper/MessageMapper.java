package com.myblog.mapper;

import java.util.List;

import com.myblog.model.Message;
/**
 * 留言管理Mapper层
 * @author 2012216954
 *
 */
public interface MessageMapper {
	
	/**
	 * 插入留言
	 * @param message - 待插入的留言
	 * @return 影响数据库的行数
	 */
	public int insertMessage(Message message);
	
	/**
	 * 获得留言列表
	 * @return
	 */
	public List<Message> getMessageList();


}
