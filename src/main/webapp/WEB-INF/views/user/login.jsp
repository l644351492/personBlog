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
<div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>Welcome to myblog</h2>
        </div>
        
    </div>

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Please login with your Username and Password.
            </div>
            <form class="form-horizontal" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" name="username" class="form-control" placeholder="Username">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="clearfix"></div>

                  
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
            </form>
            <c:if test="${not empty info}">
                <div class="alert alert-danger" >${info}</div>
            </c:if>
            
        </div>
        
    </div>
</div>


</div>
</body>
</html>