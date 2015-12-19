package com.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.model.Blog;
import com.myblog.model.Category;
import com.myblog.model.User;
import com.myblog.service.BlogService;
import com.myblog.service.CategoryService;
import com.petebevin.markdown.MarkdownProcessor;

/**
 * 系统管理控制层
 * @author 2012216954
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/**
	 * 后台登录页面首页
	 * @param request - HttpServletRequest对象
	 * @return
	 */
    @RequestMapping("")
    public ModelAndView adminIndexView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("admin/index");
        return view;
    }
    
   /**
    * 后台界面的界面
    * @param request - HttpServletRequest对象
    * @return
    */
    @RequestMapping("/frame/top")
    public ModelAndView adminFrameTopView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("admin/top");
        return view;
    }
    
    /**
     * 后台界面的功能界面
     * @param request - HttpServletRequest对象
     * @return
     */
    @RequestMapping("/frame/menu")
    public ModelAndView adminFrameMenuView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("admin/menu");
        return view;
    }
    
    /**
     * 系统首页
     * @param request - HttpServletRequest对象
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView adminFrameMainView(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("admin/main");
        //创建用户session
        HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		view.addObject("username", user.getUsername());
        return view;
    }
    
    /**
     * 账户注销
     * @param request - HttpServletRequest对象
     * @return 跳转到用户登录界面
     */
    @RequestMapping("/logout")
    public ModelAndView adminLoginOut(HttpServletRequest request){
    	HttpSession session = request.getSession();
    	//使session失效
    	session.invalidate();
    	return new ModelAndView("redirect:" + "../user/login");
    }
    
    /**
     * 显示所有分类
     * @param request - HttpServletRequest对象
     * @return
     */
    @RequestMapping("/category")
    public ModelAndView showCategoryList(HttpServletRequest
    		request){
    	 ArrayList<Category> list = (ArrayList<Category>) categoryService.getAllCategory();
    	 ModelAndView view = new ModelAndView("category/list");
    	 view.addObject("categoryList", list);
    	 return view;
    }
    
    /**
     * 根据分类Id删除分类
     * @param cid - 分类Id
     * @return 删除成功之后跳转到分类列表页面
     */
    @RequestMapping(value="/deleteCategory/{cid}", method=RequestMethod.GET)
    public ModelAndView deleteCategoryByCid(
    		@PathVariable("cid") int cid
    		){
    	categoryService.deleteCategoryByCid(cid);
    	return new ModelAndView("redirect:" + "../category");
    	
    }
    
    /**
     * 添加一个分类
     * @param categoryName - 分类名称
     * @return 添加成功之后跳转到分类列表页面
     */
	@RequestMapping(value="/addOneCategory", method=RequestMethod.POST)
	public ModelAndView deletePurchaseModel(
			@RequestParam(value="categoryName") String categoryName
			){
		categoryService.addOneCategory(categoryName);
		return new ModelAndView("redirect:" + "category");
	}
    
	/**
	 * 展示博客编辑页面 
	 * @param request - HttpServletRequest对象
	 * @return
	 */
	@RequestMapping(value="/blog/add", method=RequestMethod.GET)
	public ModelAndView addBolg(HttpServletRequest
    		request){
		ModelAndView view = new ModelAndView("admin/addblog");
		List<Category> list = categoryService.getAllCategory();
		view.addObject("categoryList", list);
		return view;
	}
	
	/**
	 * 添加文章
	 * @param blogTitle - 博客标题
	 * @param categoryId - 分类Id
	 * @param markdownContent - markdown内容
	 * @param request - HttpServletRequest对象
	 * @param response - HttpServletResponse对象
	 * @return 添加成功之后跳转到博客列表页面
	 */
	@RequestMapping(value="/blog/add", method=RequestMethod.POST)
	public ModelAndView addBolgByForm(
			@RequestParam(value="blogTitle") String blogTitle,
			@RequestParam(value="categoryId", defaultValue="0", required=false) int categoryId,
			@RequestParam(value="markdownContent") String markdownContent,
			HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			blogService.insertBlog(blogTitle, categoryId, user.getUid(), markdownContent, request, response);
		} catch (UnsupportedEncodingException e) {
			ModelAndView view = new ModelAndView("goback");
			view.addObject("info", "添加文章失败!");
			return view;
		}
		return new ModelAndView("redirect:" + "../blog");
		
	}
	
	/**
	 * 展示博客编辑页面
	 * @param bid - 博客Id
	 * @return 展示博客编辑页面
	 */
	@RequestMapping(value="/blog/edit/{bid}", method=RequestMethod.GET)
	public ModelAndView showEditBlogPage(
			@PathVariable("bid") int bid
			){
		ModelAndView view = new ModelAndView("admin/editblog") ;
		Blog blog = new Blog();
		blog = blogService.selectBlogByBid(bid);
		view.addObject("blog", blog);
		view.addObject("categoryList", categoryService.getAllCategory());
		return view ;
		
	}
	
	/**
	 * 编辑博客
	 * @param bid - 博客Id
	 * @param blogTitle - 博客标题
	 * @param categoryId - 分类Id
	 * @param markdownContent - markdown内容
	 * @param request - HttpServletRequest对象
	 * @param response - HttpServletResponse对象
	 * @return 编辑成功之后挑战到博客列表页面
	 */
	@RequestMapping(value="/blog/edit/{bid}", method=RequestMethod.POST)
	public ModelAndView editBlog(
			@PathVariable("bid") int bid,
			@RequestParam(value="blogTitle") String blogTitle,
			@RequestParam(value="categoryId", defaultValue="0", required=false) int categoryId,
			@RequestParam(value="markdownContent") String markdownContent,
			HttpServletRequest request, HttpServletResponse response
			){
		try {
			blogService.updateBlogByBid(bid, blogTitle, categoryId, markdownContent, request, response);
		} catch (UnsupportedEncodingException e) {
			ModelAndView view = new ModelAndView("goback");
			view.addObject("info", "编辑文章失败!");
			return view;
		}
		return new ModelAndView("redirect:" + "../../blog");
		
	}
	
	/**
	 * 删除博客
	 * @param bid - 博客Id
	 * @return 删除成功之后，跳转到博客列表页面
	 */
	@RequestMapping(value="/blog/delete/{bid}", method=RequestMethod.GET)
	public ModelAndView deleteBlog(
			@PathVariable("bid") int bid
			){
		
		blogService.deleteBlogByBid(bid);
		return new ModelAndView("redirect:" + "../../blog");
		
	}
	
	/**
	 * 展示博客列表
	 * @param request - HttpServletRequest对象
	 * @return
	 */
	@RequestMapping(value="/blog", method=RequestMethod.GET)
	public ModelAndView showBlogList(HttpServletRequest
    		request){
		ModelAndView view = new ModelAndView("admin/bloglist");
		view.addObject("blogList", blogService.getBlogList());
		return view;
		
	}
	
	/**
	 * 根据markdown内容转换为html
	 * @param content - markdown内容
	 * @param request - HttpServletRequest对象
	 * @param response - HttpServletResponse对象
	 * @return 
	 * @throws UnsupportedEncodingExceptionaaa
	 */
	 @RequestMapping(value = "/markdownToHtml", method = RequestMethod.POST)
	    public @ResponseBody String markdownToHtml(@RequestParam String content, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
	    
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 MarkdownProcessor mp = new MarkdownProcessor();
		 String result = mp.markdown(content);
		 return URLEncoder.encode(result, "utf-8").replace("+", "%20");
	    }
	 
	 /**
	  * 
	  * @param myfiles - 浏览器发来的图片
	  * @param request - HttpServletRequest对象
	  * @param response - HttpServletResponse对象
	  * @return 根据将上传的图片保存到服务器，并返回结果信息
	  * @throws IOException
	  * @throws NoSuchAlgorithmException
	  */
	 @RequestMapping(value = "/uploadPicture")
	    public @ResponseBody String uploadPicture(@RequestParam MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
		 	
		 Date date = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    int year = cal.get(Calendar.YEAR);
		    int month = cal.get(Calendar.MONTH);
		    int day = cal.get(Calendar.DAY_OF_MONTH);
		    String storePath = "../upload/" + year + "/" +month + "/" + day;
		    String realPath = request.getSession().getServletContext().getRealPath("/" +storePath);  
	        //设置响应给前台内容的数据格式  
	        response.setContentType("text/plain; charset=UTF-8");  
	        //设置响应给前台内容的PrintWriter对象  
	        PrintWriter out = response.getWriter();  
	        //上传文件的原名(即上传前的文件名字)  
	        String originalFilename = null;  
	        String newFilename = null;
	        for(MultipartFile myfile : myfiles){  
	            if(myfile.isEmpty()){  
	                out.print("1`请选择文件后上传");  
	                out.flush();  
	                return null;  
	            }else{  
	                originalFilename = myfile.getOriginalFilename();  
	                String myString = null;
	            	Random rand = new Random();
	            	int  n = rand.nextInt(99999) + 1;
	            	myString = Integer.toString(n);
	            	byte[] bytesOfMessage = myString.getBytes("UTF-8");
	            	MessageDigest md = MessageDigest.getInstance("MD5");
	            	byte[] thedigest = md.digest(bytesOfMessage);
	            	long value = 0;
	            	for (int i = 0; i < thedigest.length; i++)
	            	{
	            	   value += ((long) thedigest[i] & 0xffL) << (8 * i);
	            	}
	            	value = Math.abs(value);
	            	newFilename = value + ".jpg";
	                try {  
	                    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, newFilename));  
	                } catch (IOException e) {  
	                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");  
	                    e.printStackTrace();  
	                    out.print("1`文件上传失败，请重试！！");  
	                    out.flush();  
	                    return null;  
	                }  
	            }  
	        }  
	        out.print("0`" + storePath + "/" + newFilename);  
	        out.flush();  
	        return null;  
	    }
	  
	
	/**
	 * 显示此功能模块还没有完成
	 * @return
	 */
    @RequestMapping("/comming")
    public ModelAndView showMessage(){
    	return new ModelAndView("admin/comming");
    }
    
    /**
     * 自动装配的blogService对象
     */
    @Autowired 
    private BlogService blogService;
    
    /**
     * 自动装配的categoryService对象
     */
    @Autowired
    private CategoryService categoryService;
    

}
