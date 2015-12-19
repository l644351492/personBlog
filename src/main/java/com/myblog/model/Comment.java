package com.myblog.model;

import java.util.Date;

public class Comment {
	
	/**
	 * 评论Id
	 */
	private int cid;
	
	/**
	 * 评论者昵称
	 */
	private String commentNickname;
	
	/**
	 * 评论内容
	 */
	private String commentContent;
	
	/**
	 * 评论时间
	 */
	private Date commentTime;
	
	/**
	 * 目标评论Id
	 */
	private int  targetCommentId;
	
	/**
	 * 目标评论
	 */
	private Comment targetComment;
	
	/**
	 * 目标博客Id
	 */
	private int targetBlogId;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCommentNickname() {
		return commentNickname;
	}

	public void setCommentNickname(String commentNickname) {
		this.commentNickname = commentNickname;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public int getTargetCommentId() {
		return targetCommentId;
	}

	public void setTargetCommentId(int targetCommentId) {
		this.targetCommentId = targetCommentId;
	}

	public int getTargetBlogId() {
		return targetBlogId;
	}

	public void setTargetBlogId(int targetBlogId) {
		this.targetBlogId = targetBlogId;
	}

	public Comment getTargetComment() {
		return targetComment;
	}

	public void setTargetComment(Comment targetComment) {
		this.targetComment = targetComment;
	}

}
