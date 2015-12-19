package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.mapper.CategoryMapper;
import com.myblog.model.Category;

/**
 * 分类管理Service层
 * @author 2012216954
 *
 */
@Service
public class CategoryService {
	
	/**
	 * 通过查询数据库获取所有分类对象
	 * @return 所有分类对象
	 */
	public List<Category> getAllCategory(){
		return categoryMapper.getAllCategory();
	}
	
	/**
	 * 根据分类Id获得分类对象
	 * @param cid - 分类Id
	 * @return - 分类对象
	 */
	public Category getCatogoryByCid(int cid){
		return categoryMapper.getCatogoryByCid(cid);
	}
	
	/**
	 * 根据分类Id删除分类
	 * @param cid - 分类Id
	 * @return
	 */
	public int deleteCategoryByCid(int cid){
		return categoryMapper.deleteCategoryByCid(cid);
	}

	/**
	 * 根据分类名称，添加分类
	 * @param categoryName -  分类名称
	 * @return
	 */
	public int addOneCategory(String categoryName){
		Category category = new Category();
		category.setCategoryName(categoryName);
		return categoryMapper.addOneCategory(category);
	}
	
	/**
	 * 自动装配的分类管理Mapper层
	 */
	@Autowired
	private CategoryMapper categoryMapper;
}

