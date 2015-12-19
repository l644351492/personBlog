<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>

    <meta charset="utf-8">
    <base href="/Myblog/" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .list-group-item{
            border-radius: 0 !important;
        }
        .active{
            background-color: #e6e6e6 !important;
            border-color: #e6e6e6 !important;
            color: #333 !important;
        }
        a.list-group-item{
            padding-left: 25px;
        }
    </style>
</head>
<body>
<div class="list-group">
    <a class="list-group-item" href="admin/main" target="main_frame">系统首页</a>
    <li class="list-group-item list-group-item-info">博客管理</li>
    <a class="list-group-item" href="admin/blog/add" target="main_frame">添加博客</a>
    <a class="list-group-item" href="admin/blog" target="main_frame">博客列表</a>
    <li class="list-group-item list-group-item-info">资讯管理</li>
    <a class="list-group-item" href="admin/comming" target="main_frame">评论列表</a>
    <a class="list-group-item" href="admin/comming" target="main_frame">留言列表</a>
    <li class="list-group-item list-group-item-info">系统管理</li>
    <a class="list-group-item" href="admin/comming" target="main_frame">系统日志查看</a>
    <a class="list-group-item" href="admin/category" target="main_frame">分类管理</a>
</div>
<script src="assets/js/jquery-1.11.2.min.js"></script>
<script>
    $("a.list-group-item").click(function () {
        $(".active").removeClass("active");
        $(this).addClass("active");
    })
</script>
</body>
</html>