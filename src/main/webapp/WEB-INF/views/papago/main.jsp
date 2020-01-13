<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Cute+Font&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="/res/js/ajax.js"></script>
</head>
<body>
</head>
<style>
*{padding:0px; margin: 0px;}
#chat{
position:relative;
	margin-top:10px;
	margin-left:20px;
	width:150px;
	height:100px;
	font-size:25pt;
	font-family: 'Cute Font';
}
#papago{
position:relative;
	margin-top:10px;
	margin-left:20px;
	width:150px;
	height:100px;
	font-size:25pt;
	font-family: 'Cute Font';
}
#stat{
position:relative;
	margin-top:10px;
	margin-left:20px;
	width:150px;
	height:100px;
	font-size:25pt;
	font-family: 'Cute Font';
}
#logout{
	position:absolute;
	top:20%;
	left:22%;
	margin-top: 30px;
	width:100px;
	height:50px;
}

#container{
	position:absolute;
	top:20%;
	left:30%;
  width:1000px;
  height:1000px;
}


</style>
<body>
<div id=container>
<button class="btn btn-outline-success" id="chat">채팅방 가기</button>
<button class="btn btn-outline-success" id="papago">번역기 가기</button>
<button class="btn btn-outline-success" id="stat">로그 확인</button>
<button class="btn btn-success" id="logout">로그아웃</button>
</div>

<script>
$(document).ready(function() {
	$('#chat').on('click',function(){
		location.href = '/views/socket';
	})
	$('#papago').on('click',function(){
		location.href = '/views/papago/papago';
	})
	$('#stat').on('click',function(){
		location.href = '/views/papago/history';
	})
	$('#logout').on('click',function(){
		if(window.confirm("로그아웃 하시겠습니까?"))
		{
			window.location.href="/logout";
		}
	})
})

</script>
</body>
</html>