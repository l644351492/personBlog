<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
   <base href="/Myblog/"/>
   <meta charset="utf-8">
   <link href="assets/css/bootstrap.min.css" rel="stylesheet">
   <link href="assets/css/login.css" rel="stylesheet">
   <title>登录页面</title>
</head>
<body>
<ol class="breadcrumb">
    <li>当前位置：</li>
    <li>分类管理</li>
</ol>
 <table class="table">
        <thead>
          <tr>
          <td>分类名称</td>
          <td>操作</td>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoryList}" var="item">
        <tr>
        <td>${item.categoryName}</td>
        <td><a href="admin/deleteCategory/${item.cid}">删除</a></td>
        </tr>
        </c:forEach>
        <form action="admin/addOneCategory" method="post">
        <tr>
        <td><input type="text" name=categoryName class="form-control1" placeholder="输入新分类名称"></td>
        <td><button type="submit" class="btn btn-default">添加</button></td>
        </tr>
        </form>
        </tbody>
    </table>
</body>
</html>