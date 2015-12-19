package com.myblog.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TestCategoryMapper {
	
	 /**
     * 测试用例: 测试getAllCategory方法
     * 测试数据: 查询所有category
     * 预期结果: 返回一个Category对象列表，列表非空
     */
	@Test
	public void testGetAllCategory(){
		ArrayList<Category> list = (ArrayList<Category>) categoryMapper.getAllCategory();
		System.out.println(list.size());
		assertNotNull(list);
	}
	
	 /**
     * 测试用例: 测试deleteCategoryByCid方法
     * 测试数据: 首先往数据库中插入一个分类，再根据此分类的Id删除该分类
     * 预期结果: 返回 1 (影响数据库的行数)
     */
	@Test
	public void testDeleteCategoryByCid(){
		Category category = new Category();
		category.setCategoryName("C++");
		categoryMapper.addOneCategory(category);
		int affectRows= categoryMapper.deleteCategoryByCid(category.getCid());
		assertFalse(affectRows!=1);
	}
	
	/**
     * 测试用例: 测试addOneCategory方法
     * 测试数据: 往数据库中插入一个名称为"c++"的分类
     * 预期结果: 返回 1 (影响数据库的行数)
     */
	@Test
	public void testAddOneCategory(){
		Category category = new Category();
		category.setCategoryName("C++");
		int affectRows = categoryMapper.addOneCategory(category);
		assertFalse(affectRows!=1);
	}
	
	/**
     * 测试用例: 测试addOneCategory方法
     * 测试数据: 往数据库中插入一个名称为"c++"的分类
     * 预期结果: 返回 1 (影响数据库的行数)
     */

	@Test
	public void testGetCatogoryByCid(){
		
		System.out.println(categoryMapper.getCatogoryByCid(2).getCategoryName());
	}
	
	
	/**
	 * 自动装配的用户管理Mapper层
	 */
	@Autowired
	private CategoryMapper categoryMapper;

}
