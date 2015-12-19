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

import com.myblog.model.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TestCommentMapper {
	
	 /**
     * 测试用例: 测试getCommentListByTargetBlogId方法
     * 测试数据: 查询博客id为15的评论列表
     * 预期结果: 博客列表
     */
	@Test
	public void testGetComentList(){
		List<Comment> list = commentMapper.getCommentListByTargetBlogId(15);
		System.out.println(list.size());
	}
	
	 /**
     * 测试用例: 测试getCommentByCid方法
     * 测试数据: 查询评论Id为7的目标评论对象
     * 预期结果: 打印最终的结果
     */
	@Test
	public void testGetCommentByCid(){
		Comment comment;
		comment = commentMapper.getCommentByCid(7);
		if(comment.getTargetComment()!=null)
			System.out.println(comment.getTargetComment().getCommentNickname());
		
	}
	
	 /**
     * 测试用例: 测试insertComment方法
     * 测试数据: 一个Comment对象
     * 预期结果: 返回  1 (影响数据库的行数)
     */
	@Test
	public void testInsertComment(){
		Comment comment = new Comment();
		comment.setCommentNickname("zml");
		comment.setCommentContent("2333");
		comment.setCommentTime(new Date());
		comment.setTargetCommentId(1);
		comment.setTargetBlogId(15);
		int affectRows = commentMapper.insertComment(comment);
		assertFalse(affectRows != 1);
	}
	
	 /**
     * 测试用例: 测试getCommentByCid方法
     * 测试数据: 查询评论Id为7的目标评论对象
     * 预期结果: 打印最终的结果
     */
	@Test
	public void testDeleteCommentListByTargrtBlogId(){
		int affectRows = commentMapper.deleteCommentListByTargrtBlogId(16);
		System.out.println(affectRows);
		
	}
	
	/**
	 * 自动装配的commentMapper对象
	 */
	@Autowired
	private CommentMapper commentMapper;

}
