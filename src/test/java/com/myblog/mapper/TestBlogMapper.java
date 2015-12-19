package com.myblog.mapper;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.model.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TestBlogMapper {

	/**
     * 测试用例: 测试getBlogList方法
     * 测试数据: 查询所有博客列表
     * 预期结果: 返回所有博客列表
     */
	@Test
	public void testGetBlogList(){
		List<Blog> list = blogMapper.getBlogList();
		System.out.println(list.size());
		
	}
	
	/**
     * 测试用例: 测试getBlogListByCategoryId方法
     * 测试数据: categoryId为1的测试数据
     * 预期结果: 返回分类Id为1的博客列表
     */
	@Test
	public void testGetBlogListByCategoryId(){
		List<Blog> list = blogMapper.getBlogListByCategoryId(1);
		System.out.println(list.size());
		
	}
	
	/**
     * 测试用例: 测试insertBlog方法
     * 测试数据: 一个博客对象
     * 预期结果: 1 (影响数据的行数)
     */
	@Test
	public void testInsertBlog(){
		Blog blog = new Blog();
		blog.setBlogTitle("1");
		blog.setBlogAuthorId(1);
		blog.setBlogContent("2");
		blog.setMarkdownContent("3");
		blog.setCategoryId(1);
		int affectRows = blogMapper.insertBlog(blog);
		assertFalse(affectRows != 1);	
	}
	
	/**
     * 测试用例: 测试selectBlogByBid方法
     * 测试数据: 某个博客的id
     * 预期结果: 一个博客对象
     */
	@Test
	public void testSelectBlogByBid(){
		Blog blog = blogMapper.selectBlogByBid(15);
		System.out.println(blog.getBlogTitle());
		System.out.println(blog.getCatogory().getCategoryName());
	}
	
	/**
     * 测试用例: 测试deleteBlogByBid方法
     * 测试数据: 插入博客的Id
     * 预期结果: 1 (影响数据库的行数)
     */
	@Test
	public void testDeleteBlogByBid(){
		Blog blog = new Blog();
		blog.setBlogTitle("1");
		blog.setBlogAuthorId(1);
		blog.setBlogContent("2");
		blog.setMarkdownContent("3");
		blog.setCategoryId(1);
		blogMapper.insertBlog(blog);
		int affectRows = blogMapper.deleteBlogByBid(blog.getBid());
		assertFalse(affectRows != 1);
	}
	
	/**
     * 测试用例: 测试updateBlogByBid方法
     * 测试数据: 更新博客的内容
     * 预期结果: 1 (影响数据库的行数)
     */
	@Test
	public void testUpdateBlogByBid(){
		Blog blog = new Blog();
		blog.setBlogTitle("1");
		blog.setBlogAuthorId(1);
		blog.setBlogContent("2");
		blog.setMarkdownContent("3");
		blog.setCategoryId(1);
		blogMapper.insertBlog(blog);
		int affectRows = blogMapper.updateBlogByBid(blog.getBid(),
				"23", "32", "34", 1);
		assertFalse(affectRows != 1);
	}
	
	/**
     * 测试用例: 测试getBlogAndCommentList方法
     * 测试数据: 博客Id
     * 预期结果: 博客列表(包含评论列表)
     */
	@Test
	public void testGetBlogAndCommentList(){
		Blog blog = null;
		blog = blogMapper.getBlogAndCommentList(15);
		System.out.println(blog.getCommentList().size());
	}
	
	
	/**
	 * 自动装配的blogMapper对象
	 */
	@Autowired
	private BlogMapper blogMapper;
}
