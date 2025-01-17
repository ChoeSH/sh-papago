<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="/res/js/ajax.js"></script>
</head>

<style>
#wrap-container{
position: absolute;
top:5%;
left:20%;
}
select {
	width: 200px;
	padding: .5em .5em;
	border: 3px solid #3ADF00;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 25px;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}
button{
position:absolute;
top:50%;
left:47%;
background:#04B404; 
font-size:1.9em;
font-style: italic;
color:white;
font-family:'Arial','Gulim';
border-radius:0.5em;
padding:10px 18px;"
}
.sentence{
	font-size:2.2em;
	font-style: italic;
	color:white;
	font-family:'Arial','Gulim';
	padding:10px 5px;"
}

* {margin: 0; padding: 5px;}
#wrap{font-size: 16px; height: 100%; width: 1000px;}
#first{box-sizing: border-box; height: 100%; width: 990px; background-color: #04B404;}
#text{box-sizing: border-box; border-radius:0.3em; height: 200px; width: 980px;}
#second{box-sizing: border-box; height: 100%; width: 990px; background-color: #04B404;}
</style>

<body>
<div id="wrap-container">
<div id="wrap1">
<div id="selectbox">
<select id="source" name="selectLang">
  <option value="ko">한국어</option>
  <option value="en">영어</option>
  <option value="ja">일본어</option>
  <option value="zh-cn">중국어(간체)</option>
  <option value="zh-tw">중국어(번체)</option>
  <option value="es">스페인어</option>
  <option value="fr">프랑스어</option>
  <option value="de">독일어</option>
  <option value="pt">포르투갈어</option>
  <option value="it">이탈리아어</option>
  <option value="vi">베트남어</option>
  <option value="th">태국어</option>
  <option value="id">인도네시아어</option>
  <option value="hi">힌디어</option>
</select>
</div>
<div id="first" class="sentence">번역할 문장</div>
<div style="color: #2EFE2E" id="first">
<textarea name="text1" id="text" style="font-size:2.5em; font-family: 'SimHei','MingLiU','Nanum Pen Script'; "></textarea>
</div>
</div>
<div id="wrap3">
<button id="btn">번역</button>
</div>
<div id="wrap2">
<div id="selectbox">
<select id="target" name="selectLang">
  <option value="ko">한국어</option>
  <option value="en">영어</option>
  <option value="ja">일본어</option>
  <option value="zh-CN">중국어(간체)</option>
  <option value="zh-TW">중국어(번체)</option>
  <option value="es">스페인어</option>
  <option value="fr">프랑스어</option>
  <option value="de">독일어</option>
  <option value="ru">러시아어</option>
  <option value="pt">포르투갈어</option>
  <option value="it">이탈리아어</option>
  <option value="vi">베트남어</option>
  <option value="th">태국어</option>
  <option value="id">인도네시아어</option>
  <option value="hi">힌디어</option>
</select>
</div>
<div id="second" class="sentence">번역된 문장</div>
<div style="color: #2EFE2E" id="second">
<textarea name="text2" id="text" style="font-size:2.5em; font-family: 'SimHei','MingLiU','Nanum Pen Script';"></textarea>
</div>
</div>
</div>
<script>

$(document).ready(function(){
	$('#btn').on('click',function(){
		var param = 'source=' + $('#source').val();
		param += '&target=' + $('#target').val();
		param += '&text=' + $('#text').val();
		var conf={
			url:'/papago',
			method:'POST',
			data:param,
			success:function(res){
				console.log(res);
				document.querySelectorAll('#text')[1].value=res.result.translatedText;
			},
			error:function(res){
				console.log(res);
			}
		}
		ajax(conf);
	})
});
</script>
</body>
</html>