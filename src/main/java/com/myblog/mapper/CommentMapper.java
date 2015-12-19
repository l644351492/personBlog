package com.myblog.mapper;

import java.util.List;

import com.myblog.model.Comment;
/**
 * 评论管理Mapper层
 * @author 2012216954
 *
 */
public interface CommentMapper {
	
	/**
	 * 插入评论
	 * @param comment - 插入的评论
	 * @return 影响数据库的行数
	 */
	public int insertComment(Comment comment);
	
	/**
	 * 获得指定博客Id的评论列表
	 * @param blogId - 目标博客Id
	 * @return 博客列表
	 */
	public List<Comment> getCommentListByTargetBlogId(int blogId);
	
	/**
	 * 根据评论id查询整个评论对象
	 * @param cid - 评论Id
	 * @return 评论对象
	 */
	public Comment getCommentByCid(int cid);
	
	/**
	 * 删除目标博客Id为bid的评论
	 * @param bid - 目标博客Id
	 * @return
	 */
	public int deleteCommentListByTargrtBlogId(int bid);
	
	

}
