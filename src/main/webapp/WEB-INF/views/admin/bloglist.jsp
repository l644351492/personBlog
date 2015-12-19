<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
   <base href="/Myblog/"/>
   <meta charset="utf-8">
   <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<ol class="breadcrumb">
    <li>当前位置：</li>
    <li>博客列表</li>
</ol>
 <table class="table">
        <thead>
          <tr>
          <td>标题</td>
          <td>操作</td>
           <td>操作</td>
          </tr>
        </thead>
        
        <tbody>
        <c:forEach items="${blogList}" var="item">
        <tr>
        <td>${item.blogTitle} (<fmt:formatDate value="${item.finishTime}"
              type="date" pattern="yyyy年MM月dd日HH:mm" />)</td>
        <td><a href="admin/blog/edit/${item.bid}">编辑</a></td>
        <td><a href="admin/blog/delete/${item.bid}" onclick="return confirm('Are you sure?')">删除</a></td>
        </tr>
        </c:forEach>
        
       
        
        </tbody>
    </table>
   
</body>
 
</html>