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
   <link href="assets/css/style.css" rel="stylesheet">
   <link href="assets/css/message.css" rel="stylesheet">
   <style type="text/css">
   .replyer{
   color:red;
   }
   </style>
   <script type="text/javascript" src="assets/js/jquery-1.11.2.min.js"></script>
   <title>博客列表</title>
</head>
<body>
<div class="container-fluid">
    <div class="nav">
        <ul class="nav .navbar-static-top nav-tabs container" role="tablist">
        <li role="presentation" class="navbar-right"><a href="blog/comming">关于我</a></li>
        <li role="presentation" class="navbar-right"><a href="blog/comming">留言</a></li>
        <li role="presentation" class="navbar-right active"><a href="blog">博客</a></li>
        </ul>
    </div>
</div>
<div class="container body">
<div class="col-sm-9 col-md-10 col-sm-push-3 col-md-push-2">

<!--  <h1>${blog.commentList.size() }</h1>-->
<div class="article">
<div class="row" id="title">
  ${blog.blogTitle }
</div>
<div class="row" id="info">
            作者：${blog.author.username }&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${blog.finishTime}"
              type="date" pattern="yyyy-MM-dd hh:mm" />&nbsp;&nbsp;&nbsp;&nbsp;分类：${blog.catogory.categoryName}        <hr>
        </div>
${blog.blogContent }

</div>
<div class="row" id="comment_area">
            <div id="pinlunqu">
                评论区<button class="btn btn-primary" type="button" id="comment" onclick="reply(0)">发表评论</button>
            </div>  
            <div id="bottom_border">
            </div>    
            
        </div>
        
         <c:forEach items="${blog.commentList}" var="comment">
         <div class="comment_body" id="id_${comment.cid }">
            <div class="comment_user">
                <span id="usr_${comment.cid }">${comment.commentNickname}</span>
                &nbsp;&nbsp;<c:if test="${not empty comment.targetComment}" >回复&nbsp;<span class="replyer">${comment.targetComment.commentNickname }</span>&nbsp;</c:if>
                <fmt:formatDate value="${comment.commentTime}"
              type="date" pattern="yyyy-MM-dd hh:mm" />         </div>
            <div class="comment_content">${comment.commentContent }</div>
            <div class="comment_fn">
            <a href="javascript:void(0);" onclick="reply('${comment.cid }')">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                <span class="">回复</span>
            </a>
            </div>
        </div>
           <hr>
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
<script type="text/javascript">
function reply(id) {
    
    $('#reply').remove();
    var reply_html = '\
    <div id="reply">\
        <div class="col-xs-12 col-sm-12 col-md-10 col-lg-9">\
            <div class="panel panel-default">\
                <div class="panel-heading">\
                    发表评论<a href="javascript:void(0);"><span id="close" class="pull-right">X</span></a>\
                </div>\
                <div class="panel-body">\
                    <div class="input-group">\
                        <span class="input-group-addon" id="sizing-addon1">昵称</span>\
                        <input type="text" id="sub_user" class="form-control" placeholder="输入您的昵称" aria-describedby="sizing-addon1">\
                    </div>\
                    <textarea class="form-control" id="re_content" placeholder="" rows="5"></textarea>\
                    <button type="button" class="btn btn-lg btn-success pull-right" id="sub_reply">确定</button>\
                </div>\
            </div>\
        </div>\
    </div>'; 
    if (id == 0) {
        $('#pinlunqu').after(reply_html);
        $('#re_content').text("").attr("placeholder", "说点什么...");
    } else {
        $('#id_'+id).after(reply_html);
        var usrName = $('#usr_'+id).text();
        $('#re_content').text("").attr("placeholder", "评论"+usrName);
    }
    
    $('#close').click(function() {
        $('#reply').remove();
    });
    $('#sub_reply').click(function() {
        $('.ajax_error').remove();
        var username = $('#sub_user').val();
        var content = $('#re_content').val();
        if (username == '') {
            var error='<div class="alert alert-danger ajax_error" role="alert">请输入您的昵称</div>';
            $('#sub_reply').before(error);
            return 0;
        }
        if (content == '') {
            var error='<div class="alert alert-danger ajax_error" role="alert">请填写评论</div>';
            $('#sub_reply').before(error);
            return 0;
        }
        $('#sub_reply').text('提交评论...').addClass('disabled');

        $.ajax({
            type: 'POST',
            url: 'blog/comment',
            dataType: 'json',
            data:{
            	targetBlogId: ${blog.bid},
                targetCommentId: id,
                username: username,
                content: content
              
            },
            success: function(data) {
            	if(data != 0){
            		 $('#sub_reply').text('等待跳转...');
                     var error='<div class="alert alert-success ajax_error" role="alert">提交成功</div>';
                     $('#sub_reply').before(error).removeClass('disabled');
                     setTimeout(function() {
                         location.reload(true);
                     }, 1000);
            	}
            	else{
                    var error='<div class="alert alert-danger ajax_error" role="alert">提交失败，请重试</div>';
                    $('#sub_reply').before(error).removeClass('disabled');
               }
            },
            error: function() {
                var error='<div class="alert alert-danger" ajax_error" role="alert">连接失败，请重试</div>';
                $('#sub_reply').before(error).removeClass('disabled');
            }
        });
    });
}
</script>

</html>