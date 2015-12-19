package com.myblog.model;

import java.util.Date;

public class Message {
	
	/**
	 * 留言Id
	 */
	private int mid;
	
	/**
	 * 留言者昵称
	 */
	private String messagerNickname;
	
	/**
	 * 留言内容
	 */
	private String messageContent;
	
	/**
	 * 留言时间
	 */
	private Date messageTime;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMessagerNickname() {
		return messagerNickname;
	}

	public void setMessagerNickname(String messagerNickname) {
		this.messagerNickname = messagerNickname;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	

}
