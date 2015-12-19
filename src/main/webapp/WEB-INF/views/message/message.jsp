<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
   <base href="/Myblog/"/>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0, maximum-scale=3.0">
   <link href="assets/css/bootstrap.min.css" rel="stylesheet">
   <link href="assets/css/my.css" rel="stylesheet">
   <link href="assets/css/message.css" rel="stylesheet">
   <link href="assets/css/blog.css" rel="stylesheet">
   <script type="text/javascript" src="assets/js/jquery-1.11.2.min.js"></script>
   <title>留言列表</title>
</head>
<body>
<div class="container-fluid">
    <div class="nav">
        <ul class="nav .navbar-static-top nav-tabs container" role="tablist">
        <li role="presentation" class="navbar-right"><a href="blog/comming">关于我</a></li>
        <li role="presentation" class="navbar-right active"><a href="message">留言</a></li>
        <li role="presentation" class="navbar-right"><a href="blog">博客</a></li>
        </ul>
    </div>
</div>
<div class="container body">


<div class="col-sm-9 col-md-10 col-sm-push-3 col-md-push-2">
<br><br><br>

               <c:forEach items="${messageList}" var="item">
                       <ul class="comment_ul" >    <li class="comment_list">
        <div class="comment_body">
            <div class="comment_user">
                <span >${item.messagerNickname }</span>
                &nbsp;&nbsp;<fmt:formatDate value="${item.messageTime}"
              type="date" pattern="yyyy-MM-dd日 HH:mm" />           </div>
            <div class="comment_content">${item.messageContent }</div>
            <div class="comment_fn">
            
            </div>
        </div>
        </li>
        </ul>
        <hr><br><br>
       
        </c:forEach>
        
        
        
    
<form  method="post">
  <div class="form-group">
    <input class="form-control"   name="nickName" placeholder="请输入你的昵称">
  </div>
  
 <textarea class="form-control" rows="5" placeholder="留言内容" name="messageContent"></textarea>
  <br>
 
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>

</div>
<div class="container-fluid footer">
<center>
Copyright © 2014-2015<br>
liujunming<br>
All Right Reserved<br>
</center>
</div>
</body>
</html>