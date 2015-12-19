package com.myblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.model.Blog;
import com.myblog.model.Category;
import com.myblog.service.BlogService;
import com.myblog.service.CategoryService;
import com.myblog.service.CommentService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	/**
	 * 前端博客首页
	 * @param request - HttpServletRequest对象
	 * @return
	 */
    @RequestMapping("")
    public ModelAndView showBlog(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("blog/index");
        	 List<Category> list = categoryService.getAllCategory();
             view.addObject("categoryList", list);
             List<Blog> blogList = blogService.getBlogList();
             view.addObject("blogList", blogList);
             view.addObject("info", "博客");
             return view;
       
    }
    
    /**
     * 根据分类显示博客列表
     * @param request - HttpServletRequest对象
     * @param categoryId - 分类Id
     * @return
     */
    @RequestMapping("category/{cid}")
    public ModelAndView showBlogByCategoryId(HttpServletRequest request,
    		@PathVariable("cid") int categoryId) {
        ModelAndView view = new ModelAndView("blog/index");
        List<Category> list = categoryService.getAllCategory();
        view.addObject("categoryList", list);
        view.addObject("info", categoryService.getCatogoryByCid(categoryId).getCategoryName());
        List<Blog> blogList = blogService.getBlogListByCategoryId(categoryId);
        view.addObject("blogList", blogList);
        return view;
        
    }
    
    /**
     * 根据博客Id显示博客的详细内容
     * @param request - HttpServletRequest对象
     * @param blogId -  博客Id
     * @return
     */
    @RequestMapping("/{bid}")
    public ModelAndView showBlogDetail(HttpServletRequest request,
    		@PathVariable("bid") int blogId) {
        ModelAndView view = new ModelAndView("blog/detail");
        
        List<Category> list = categoryService.getAllCategory();
        view.addObject("categoryList", list);
        Blog blog = blogService.getBlogAndCommentList(blogId);
        view.addObject("blog", blog);
        return view;
        
    }
    
    /**
     * 根据前端传来的评论，将其保存到数据库中
     * @param targetBlogId - 目标博客Id
     * @param targetCommentId - 目标评论Id
     * @param username - 评论者昵称
     * @param content - 评论内容 
     * @param request - HttpServletRequest对象
     * @return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public @ResponseBody String insertComment(
    		@RequestParam int targetBlogId, @RequestParam int targetCommentId
    		,@RequestParam String username, @RequestParam String content
    		, HttpServletRequest request
    		) {
    	
    	int currentCommentId;
    	try{
    	currentCommentId = commentService.insertComment(targetBlogId, targetCommentId, username, content);
    	}
    	catch(Exception ex){
    		return "0";
    	}
    	return "1" + currentCommentId;
        
    }
    /**
	 * 显示此功能模块还没有完成
	 * @return
	 */
    @RequestMapping("/comming")
    public ModelAndView showMessage(){
    	return new ModelAndView("comming");
    }
    
    /**
     * 自动装配的categoryService对象
     */
    @Autowired
    private CategoryService categoryService;
    
    /**
     * 自动装配的commentService对象
     */
    @Autowired
    private CommentService commentService;
    
    /**
     * 自动装配的blogService对象
     */
    @Autowired
    private BlogService blogService;

}
