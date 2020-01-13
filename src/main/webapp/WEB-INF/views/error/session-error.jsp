<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<style>
*{margin 10px; padding 0;}
#wrap{
position:absolute;
	top:10%;
	left:15%;	
}
</style>
<body>
<div id=wrap>
<h2>로그인이 필요한 요청입니다!</h2><br>
<button id="login" class="btn btn-secondary btn-lg" >로그인 화면으로</button>
</div>
<script>
document.getElementById("login").onclick = function(){
		location.href='/views/user/login';
}
</script>
</body>
</html>