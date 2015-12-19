package com.myblog.model;

import java.util.Date;
import java.util.List;

public class Blog {
	
	/**
	 * 博客Id
	 */
	private int bid;
	
	/**
	 * 博客标题
	 */
	private String blogTitle;
	
	/**
	 * 作者Id
	 */
	private int blogAuthorId;
	
	/**
	 * 作者
	 */
	private User author;
	
	

	/**
	 * markdown内容
	 */
	private String markdownContent;
	
	/**
	 * 博客内容
	 */
	private String blogContent;
	
	/**
	 * 分类Id
	 */
	private int categoryId;
	
	/**
	 * 分类
	 */
	private Category catogory;

	/**
	 * 博客完成时间
	 */
	private Date finishTime;
	
	/**
	 * 评论列表
	 */
	private List<Comment> commentList;
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public int getBlogAuthorId() {
		return blogAuthorId;
	}

	public void setBlogAuthorId(int blogAuthorId) {
		this.blogAuthorId = blogAuthorId;
	}

	public String getMarkdownContent() {
		return markdownContent;
	}

	public void setMarkdownContent(String markdownContent) {
		this.markdownContent = markdownContent;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryIdl) {
		this.categoryId = categoryIdl;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	public Category getCatogory() {
		return catogory;
	}

	public void setCatogory(Category catogory) {
		this.catogory = catogory;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	
}
