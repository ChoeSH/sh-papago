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
  crossorigin="anonymous"></script>
<script src="/res/js/ajax.js"></script>
</head>
<style>
body {
    font-style: italic;
	font-family: 'Cute Font', cursive;
    font-size: 20px;
    color: rgb(33, 33, 33);
    letter-spacing: 0.05em;
}
.container{
position:absolute;
	top:45%;
	left:45%;
	margin:-150px 0px 0px -150px;
}

table {
    width: 400px;
}

tr {
    height: 50px;
}
.btn btn-success{
font-size:15pt;
}

input[type=text], input[type=password] {
    padding: 5px 10px; /* 상하 우좌 */
    margin: 5px 0; /* 상하 우좌 */
    border: 1px solid #ccc; /* 999가 약간 더 진한 색 */
    font-size:15pt;
    letter-spacing: 0.05em;
    box-sizing: border-box;
    border-radius: 3px;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus, input[type=password]:focus {
    border: 2px solid #555;
}

input[type=submit],input[type=button] {
    margin: 5px;
    width:103px;
    height:43px;
    padding: 5px, 5px; /* 상하 우좌 */
    font-size: 20px;
    font-weight: normal;
    letter-spacing: 1px;
    border: none;
    cursor: pointer;
    border-radius: 3px;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
}
</style>
<body>
<div class="container">
<h2>회원가입</h2>
    <table>
        <tr>
            <td style='width:100px'>이름</td>
            <td><input type="text" size=40 id="uiName" name="uiName" value=""></td>
        </tr>
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" size=21 id="uiId" name="ID" value="">
                <input type="button" id="checkid" class="btn btn-success" value="중복체크">
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" size=40 id="uiPwd" name="Password"></td>
        </tr>
        <tr>
            <td>비밀번호(확인)</td>
            <td><input type="password" size=40 id ="PwdCheck" name="PwdCheck"></td>
        </tr>
        <tr>
            <td colspan='2' align='center'><input type="submit" id="join" class="btn btn-success" value="회원가입"></td>
        </tr>
    </table>
</div>
<script>
$(document).ready(function(){
	$('#join').on('click',function(){
		var param = 'uiId=' + $('#uiId').val();
		param += '&uiPwd=' + $('#uiPwd').val();
		param += '&uiName=' + $('#uiName').val();
		var conf={
			url:'/join',
			method:'POST',
			data:param,
			beforeSend: function(xhr){
				xhr.setRequestHeader('x-ajax', 'true');
			},
			success:function(res){
				if(res.msg){
					alert(res.msg);
				}if(res.uv){
					location.href=res.url;
				}
				console.log(res);
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