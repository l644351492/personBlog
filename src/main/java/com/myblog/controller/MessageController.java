package com.myblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.model.Message;
import com.myblog.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	/**
	 * 展示留言列表
	 * @param request - HttpServletRequest对象
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView showMessage(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("message/message");
        List<Message> list = messageService.getMessageList();
        view.addObject("messageList", list);
        return view;
       
    }
	/**
	 * 插入留言
	 * @param request - HttpServletRequest对象
	 * @param nickName - 留言者昵称
	 * @param messageContent - 留言内容
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView insertMessage(HttpServletRequest request,
			@RequestParam(value="nickName") String nickName, 
			@RequestParam(value="messageContent") String messageContent
			) {
        messageService.insertMessage(nickName, messageContent);
        return new ModelAndView("redirect:" + "/message");
       
    }
	
	/**
	 * 自动装配的messageService对象
	 */
	@Autowired
	private MessageService messageService;
	

}
