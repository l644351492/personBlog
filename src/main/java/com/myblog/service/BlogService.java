package com.myblog.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.mapper.BlogMapper;
import com.myblog.mapper.CommentMapper;
import com.myblog.model.Blog;
import com.petebevin.markdown.MarkdownProcessor;
/**
 * 博客管理服务层
 * @author 2012216954
 *
 */
@Service
public class BlogService {
	
	/**
	 * 插入博客
	 * @param blogTitle - 博客标题
	 * @param categoryId - 分类Id
	 * @param blogAuthorId - 作者Id
	 * @param markdownContent - markdwon内容
	 * @param request - HttpServletRequest对象
	 * @param response - HttpServletResponse对象
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Transactional
	public int insertBlog(String blogTitle, int categoryId, int blogAuthorId, String markdownContent, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 MarkdownProcessor mp = new MarkdownProcessor();
		 String blogContent = mp.markdown(markdownContent);
		 Blog blog = new Blog();
		 blog.setBlogTitle(blogTitle);
		 blog.setBlogAuthorId(blogAuthorId);
		 blog.setMarkdownContent(markdownContent);
		 blog.setBlogContent(blogContent);
		 blog.setCategoryId(categoryId);
		 return blogMapper.insertBlog(blog);
	}
	
	/**
	 * 更新博客内容
	 * @param bid - 博客Id
	 * @param blogTitle - 文章标题
	 * @param categoryId - 分类Id
	 * @param markdownContent - markdown内容
	 * @param request - HttpServletRequest对象
	 * @param response - HttpServletResponse对象
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Transactional
	public int updateBlogByBid(int bid, String blogTitle,
			int categoryId, String markdownContent,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 MarkdownProcessor mp = new MarkdownProcessor();
		 String blogContent = mp.markdown(markdownContent);
		 return blogMapper.updateBlogByBid(bid, blogTitle, markdownContent, blogContent, categoryId);
	}
	
	/**
	 * 获取博客列表
	 * @return
	 */
	public List<Blog> getBlogList(){
		return blogMapper.getBlogList();
	}

	/**
	 * 根据博客Id选取博客
	 * @param bid - 博客Id
	 * @return 博客对象
	 */
	public Blog selectBlogByBid(int bid){
		return blogMapper.selectBlogByBid(bid);
	}
	
	/**
	 * 根据博客Id删除博客
	 * @param bid - 博客Id
	 * @return
	 */
	public int deleteBlogByBid(int bid){
		commentMapper.deleteCommentListByTargrtBlogId(bid);
		return blogMapper.deleteBlogByBid(bid);
	}
	
	/**
	 * 根据分类Id选择博客列表
	 * @param cid - 分类Id
	 * @return
	 */
	public List<Blog> getBlogListByCategoryId(int cid){
		return blogMapper.getBlogListByCategoryId(cid);
	}
	
	/**
	 * 获得博客和对应于这个博客的评论
	 * @param bid - 博客Id
	 * @return
	 */
	public Blog getBlogAndCommentList(int bid){
		return blogMapper.getBlogAndCommentList(bid);
	}
	
	/**
	 * 自动装配的blogMapper对象
	 */
	@Autowired
	private BlogMapper blogMapper;
	
	/**
	 * 自动装配的commentMapper对象
	 */
	@Autowired
	private CommentMapper commentMapper;
}
