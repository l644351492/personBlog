<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="/Myblog/" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <base href="/Myblog/" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style>
        body{
            background-color: #337ab7;
            color: #fff;
        }
      
        #exit{
      position: absolute;
      right: 30px;
      top: 20px;
        }
    </style>
</head>
<body>

<h2 align="center">个人博客系统</h2>
<a href="admin/logout" target="_parent" class="btn btn-default" id="exit" role="button">注销</a>

</body>

</html>