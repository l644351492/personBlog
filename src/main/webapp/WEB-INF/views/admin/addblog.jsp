<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <base href="/Myblog/" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="assets/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
    function doAjaxPreview() {
    	
     var content = $("#markdownContent").val();
      $.ajax({
        url: 'admin/markdownToHtml',
        type: 'POST',
        data: ({content : content}),
        success: function(data) {
        	var data = decodeURIComponent(data);
          $('#article').html(data);
        }
      });
    }
    
    function ajaxFileUpload(){  
        //开始上传文件时显示一个图片,文件上传完成将图片隐藏  
        //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});  
        //执行上传文件操作的函数  
        $.ajaxFileUpload({  
            //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
            url:'admin/uploadPicture',  
            secureuri:false,                           //是否启用安全提交,默认为false   
            fileElementId:'myBlogImage',               //文件选择框的id属性  
            dataType:'text',                           //服务器返回的格式,可以是json或xml等  
            success:function(data, status){            //服务器响应成功时的处理函数  
                data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀  
                data = data.replace(/<PRE.*?>/g, '');  
                data = data.replace("<PRE>", '');  
                data = data.replace("</PRE>", '');  
                data = data.replace("<pre>", '');  
                data = data.replace("</pre>", '');     //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]  
                if(data.substring(0, 1) == 0){         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)  
                    //$("img[id='uploadImage']").attr("src", data.substring(2));  
                   // $('#result').html("图片上传成功<br/>");  
                   //alert(data);
                   var content = $('#markdownContent').val();
                   content = content +"\n![alternate text]" + "(" +  data.substring(2) + ")";
                   $('#markdownContent').val(content);
                }else{  
                    $('#result').html('图片上传失败，请重试！！');  
                }  
            },  
            error:function(data, status, e){ //服务器响应失败时的处理函数  
                $('#result').html('图片上传失败，请重试！！');  
            }  
        });  
    }  
  </script>
</head>
<body>
<ol class="breadcrumb">
    <li>当前位置：</li>
    <li>添加博客</li>
</ol>
<form method="post" class="form-horizontal">
    <div class="form-group">
        <label for="blogTitle" class="col-sm-2 control-label">博客标题:</label>
        <div class="col-sm-4">
          <input class="form-control" name="blogTitle" id="blogTitle" placeholder="博客标题" ">
        </div>
      </div>
     
    <div class="form-group">
    <label for="category" class="col-sm-2 control-label">博客分类:</label>
     <div class="col-sm-4">
    <select name="categoryId" id="category" class="form-control">
                      <option value="0"></option>
                      <c:forEach items="${categoryList}" var="category">
                          <option value="${category.cid}">${category.categoryName}</option>   
                      </c:forEach>
                    </select>
    </div>
    </div>
    
    <div class="form-group">
     <label class="col-sm-4 control-label">文章内容（请使用MarkDown语法）</label>
    </div>
                
              <div class="form-group">
              <input type="file" name="myfiles" id="myBlogImage" class="col-sm-5 col-sm-push-1 ">
                </div>
                
                 <div class="form-group">
                <input type="button" value="上传" class="col-sm-1 col-sm-push-1 btn btn-primary" onclick="ajaxFileUpload()">
                </div>
                
                
                <div class="form-group">
                <textarea class="form-control col-sm-8 col-sm-push-1" rows="10" id="markdownContent" name="markdownContent" ></textarea>
                </div>
                
                
                <div class="form-group">
                <input type="button" value="预览" id="preview" class="btn btn-info col-sm-1 col-sm-push-1" onclick="doAjaxPreview()">
                </div>
                
                <div class="form-group">
                  <input type="submit" class="btn btn-success col-sm-1 col-sm-push-1">
                </div>
                 <div class="form-group article" id="article">
                
                 
                 </div>
                </form>

               
</body>
</html>