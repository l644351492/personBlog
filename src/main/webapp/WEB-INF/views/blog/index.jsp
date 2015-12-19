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
   <link href="assets/css/blog.css" rel="stylesheet">
   <script type="text/javascript" src="assets/js/jquery-1.11.2.min.js"></script>
   <title>博客列表</title>
</head>
<body>
<div class="container-fluid">
    <div class="nav">
        <ul class="nav .navbar-static-top nav-tabs container" role="tablist">
        <li role="presentation" class="navbar-right"><a href="blog/comming">关于我</a></li>
        <li role="presentation" class="navbar-right"><a href="message">留言</a></li>
        <li role="presentation" class="navbar-right active"><a href="blog">博客</a></li>
        </ul>
    </div>
</div>
<div class="container body">
<div class="row zhuti">
   ${info}
</div>
<div class="col-sm-9 col-md-10 col-sm-push-3 col-md-push-2">


    <c:forEach items="${blogList}" var="blog">
          <div class="row list">
           <div class="col-xs-2 col-sm-2 date"><fmt:formatDate value="${blog.finishTime}"
              type="date" pattern="MM-dd" /><br><div class="tag">${blog.catogory.categoryName}</div>
    </div> 
    <div class="col-xs-9 col-sm-9 shutiao">        
        <div class="row title"><a target="_blank" href="blog/${blog.bid }">${blog.blogTitle}</a>
        </div>                    
    </div>  
           
           </div>
        </c:forEach>
   


</div>
<div class="col-sm-3 col-md-2 col-sm-pull-9 col-md-pull-10">
<div class="list-group catagery">
          <div class="list-group-item active">
              Category
          </div>
           <c:forEach items="${categoryList}" var="item">
           <a href="blog/category/${item.cid}" class="list-group-item">
           ${item.categoryName}<span class="badge"></span></a>
        </c:forEach>
        <a href="blog/category/0" class="list-group-item">
                  未分类              <span class="badge"></span>
          </a>
                  </div>
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