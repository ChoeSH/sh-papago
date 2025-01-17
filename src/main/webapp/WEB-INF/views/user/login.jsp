<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Cute+Font&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous">
</script>
</head>
<style>
div{
font-style: italic;
font-family: 'Cute Font', cursive;
font-size:x-large;
}
#loginer{
box-sizing:border-box;
	position:absolute;
	top:45%;
	left:45%;
	margin:-150px 0px 0px -150px;
  padding: 30px;
  margin-bottom: 30px;
  width:400px;
  height:330px;
  border: 1px solid #bcbcbc;
  text-align: center;
}
#uiId{
margin-left: 7px;
}
button{
	margin: 5px;
    width:100px;
    height:40px;
    letter-spacing: 2px;
    border: none;
    border-radius: 2px;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
}

label{
margin: 8px;
}
::placeholder
{
  font-size: 0.7em;
  font-family: 'Georgia';
}
</style>
<body>
<div id="loginer" class="container">
      <h1>로그인</h1>
        <div class="inp_text">
          <label for="uiId" class="screen_out">아이디</label>
          <input type="text" id="uiId" name="ID" placeholder="ID">
        </div>
        <div class="inp_text">
          <label for="uiPwd" class="screen_out">비밀번호</label>
          <input type="password" id="uiPwd" name="Password" placeholder="Password" >
        </div>
      <button class="btn btn-success" id="btn_login">로그인</button>
      <button class="btn btn-success" id="btn_join">회원가입</button>
      <div class="login_append">
        <div class="inp_chk"> <!-- 체크시 checked 추가 -->
          <input type="checkbox" id="keepLogin" class="inp_radio"  name="keepLogin">
          <label for="keepLogin" class="lab_g">
<span class="txt_lab">로그인 상태 유지</span>
  </label>
        </div>
        <span class="txt_find">
           <a href="/member/find/loginId" class="link_find">아이디</a>
            / 
           <a href="/member/find/password" class="link_find">비밀번호 찾기</a>
        </span>
      </div>
     </div>
<script>
$('#btn_join').on('click',function(){
	location.href = '/views/user/join';
})

$(document).ready(function(){
	$('#btn_login').on('click',function(){
	var param = {
			uiId : $('#uiId').val(),
			uiPwd : $('#uiPwd').val()
	}
	param=JSON.stringify(param);
	$.ajax({
		url:'/login',
		method:'POST',
		data : param,
		beforeSend: function(xhr){
			xhr.setRequestHeader('x-ajax', 'true');
		},
		contentType:'application/json',
		success: function(res){
			if(res.msg){
				alert(res.msg);
			if(res.uv){
				location.href=res.url;
				}
			}
			console.log(res);
		},
		error: function(res){
			console.log(res);
		}
	})
	})
})
</script>
</body>
</html>