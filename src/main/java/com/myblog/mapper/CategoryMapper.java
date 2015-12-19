package com.myblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.model.Category;

/**
 * 分类管理Mapper层
 * @author 2012216954
 *
 */
public interface CategoryMapper {
	
	/**
	 * 通过查询数据库获取所有分类对象
	 * @return 所有分类对象
	 */
	public List<Category> getAllCategory();
	
	/**
	 * 根据分类Id删除分类
	 * @param cid - 分类Id
	 * @return 影响数据库的行数
	 */
	public int deleteCategoryByCid(@Param("cid") int cid);
	
	/**
	 * 添加一个分类
	 * @param category - 分类对象
	 * @return 影响数据库的行数
	 */
	public int addOneCategory(Category category);
	
	/**
	 * 根据分类Id获取分类对象
	 * @param cid - 分类Id
	 * @return
	 */
	public Category getCatogoryByCid(int cid);

}
