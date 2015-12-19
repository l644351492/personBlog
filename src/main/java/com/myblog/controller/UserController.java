package com.myblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.model.User;
import com.myblog.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 用户登录界面
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLoginPage() {
		return new ModelAndView("/user/login");
	}
	
	/**
	 * 账户登录
	 * @param username - 用户名
	 * @param password - 密码
	 * @param request - HttpServletRequest对象
	 * @return 
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelAndView loginAction(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password,
			HttpServletRequest request) {
			HttpSession httpSession = request.getSession();
			User user;
			user = userService.getTargetUserByUsernameAndPassword(username, password);
			//如果登录成功，则跳转到后台管理界面
			if(user != null){
				httpSession.setAttribute("user", user);
				return new ModelAndView("redirect:" + "../admin");
			}
			//如果登录失败，则提示错误信息
			ModelAndView viewview = new ModelAndView("user/login");
			viewview.addObject("info", "用户名或密码错误");
			return viewview;

		
	}
	
	/**
	 * 自动装配的用户管理服务层
	 */
	@Autowired
	private UserService userService;
	
	
}
