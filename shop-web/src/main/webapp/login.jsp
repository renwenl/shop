<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/bootstrap/css/htmleaf-demo.css">
	<link href="<%=request.getContextPath()%>/js/bootstrap/css/signin.css" rel="stylesheet">

</head>
<body>
<div class="htmleaf-container">
	<%--<div class="signin">--%>
		<div class="signin-head"><img src="images/test/head_120.png" alt="" class="img-circle"></div>
		<div><span id="warnSpan"></span></div>
		<form class="form-signin" role="form">
			<input type="text" id="userName" class="form-control" placeholder="用户名" required autofocus />
			<input type="password" id="password" class="form-control" placeholder="密码" required />
			<input type="password" id="imageCode" class="form-control" placeholder="验证码" required />
			<img id="image" alt="验证码" src="<%=request.getContextPath()%>/image/code" onclick="checkImage()">&nbsp;&nbsp;&nbsp;&nbsp;<a href="JavaScript:checkImage()">看不清？换一张</a>
			<button id="login" class="btn btn-lg btn-warning btn-block" type="button">登录</button>
			<button onclick="addUser()" class="btn btn-lg btn-warning btn-block" type="button">注册</button>
			<label class="checkbox">
				<input type="checkbox" value="remember-me"> 记住我
			</label>
		</form>
	<%--</div>--%>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#login").bind("click",function(){
			var v_userName = $("#userName").val();
			var v_password = $("#password").val();
			var v_imageCode = $("#imageCode").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/user/login.jhtml",
				data:{
					"userName":v_userName,
					"password":str_md5(v_password),
					"imageCode":v_imageCode
				},
				type:"post",
				success:function(result){
					var v_code = result.code;
					var v_msg = result.message;
					if(v_code==200){
						location.href="<%=request.getContextPath()%>/user/showInfoPage.jhtml";
					}else{
						$("#warnSpan").html("<font color='red'>"+v_msg+"</font>")
					}
				}
			})
		})
	})
	
	//验证码切换
  	function checkImage(){
  		$("#image").get(0).src="<%=request.getContextPath()%>/image/code?"+Math.random();
  	}

  	function addUser(){
	    location.href="<%=request.getContextPath()%>/user/toAddUserPage.jhtml"
	}
</script>
</html>
