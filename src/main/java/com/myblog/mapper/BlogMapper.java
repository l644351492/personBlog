package com.myblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.model.Blog;
/**
 * 博客管理Mapper层
 * @author 2012216954
 *
 */
public interface BlogMapper {

	/**
	 * 获得博客列表
	 * @return
	 */
	public List<Blog> getBlogList();
	
	/**
	 * 插入博客
	 * @param blog - 博客对象
	 * @return - 影响数据库的行数
	 */
	public int insertBlog(Blog blog);
	
	/**
	 * 根据博客Id选择博客
	 * @param bid - 博客Id
	 * @return 所选博客对象
	 */
	public Blog selectBlogByBid(int bid);
	
	/**
	 * 根据博客Id删除博客
	 * @param bid - 博客Id
	 * @return - 影响数据库的行数
	 */
	public int deleteBlogByBid(int bid);
	
	/**
	 * 更新博客内容
	 * @param bid - 博客Id
	 * @param blogTitle - 博客标题
	 * @param markdownContent - markdown内容
	 * @param blogContent -博客内容
	 * @param categoryId - 分类Id
	 * @return 影响数据库的行数
	 */
	public int updateBlogByBid(@Param("bid") int bid, @Param("blogTitle") String blogTitle, 
			@Param("markdownContent") String markdownContent, @Param("blogContent") String blogContent
			, @Param("categoryId") int categoryId);
	
	/**
	 * 根据分类Id筛选博客列表
	 * @param cid - 分类Id
	 * @return
	 */
	public List<Blog> getBlogListByCategoryId(int cid);
	
	/**
	 * 根据博客Id选择文章和评论列表
	 * @param bid - 博客Id
	 * @return
	 */
	public Blog getBlogAndCommentList(int bid);
	
	
	
}
