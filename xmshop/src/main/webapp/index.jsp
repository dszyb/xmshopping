<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>index</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<style>
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h1{
        width: 220px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: deepskyblue;
        border-radius: 5px;
      }
    </style>
</head>
<body>
	<h1>
		<a href="${pageContext.request.contextPath}/logins/toLogin">
			<span id="seconds">2</span>秒后，进入后台管理界面
		</a>
	</h1>
	<script type="text/javascript">
		function timing(secs,url) {
			var seconds=document.getElementById('seconds');
			seconds.innerHTML=--secs;
			if(secs>0){
				setTimeout('timing('+secs+',\''+url+'\')',1000);
			}else{
				location.href=url;
			}
		};
		timing(2,'${pageContext.request.contextPath}/logins/toLogin');
	</script>
</body>
</html>