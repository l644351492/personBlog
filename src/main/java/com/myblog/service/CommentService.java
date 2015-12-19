package com.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.mapper.CommentMapper;
import com.myblog.model.Comment;

/**
 * 评论管理服务层
 * @author 2012216954
 *
 */
@Service
public class CommentService {
	
	/**
	 * 插入评论
	 * @param targetBlogId - 目标博客Id
	 * @param targetCommentId - 目标评论Id
	 * @param username - 评论者昵称
	 * @param content - 评论内容
	 * @return 影响数据库的行数
	 */
	public int insertComment(int targetBlogId, int targetCommentId, String username, String content){
		Comment comment = new Comment();
		comment.setCommentContent(content);
		comment.setTargetBlogId(targetBlogId);
		comment.setTargetCommentId(targetCommentId);
		comment.setCommentNickname(username);
		commentMapper.insertComment(comment);
		return comment.getCid();
	}
	
	/**
	 * 自动装配的commentMapper对象
	 */
    @Autowired
    private CommentMapper commentMapper;

}
