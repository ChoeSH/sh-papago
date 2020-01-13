<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<style>
#chatWrap {
	top:5%;
	left:30%;
    width: 500px;
    border: 1px solid #ddd;
    position: absolute;
}

#chatHeader {
    height: 60px;
    text-align: center;
    line-height: 60px;
    font-size: 25px;
    font-weight: 900;
    border-bottom: 1px solid #ddd;
}

#chatLog {
    height: 600px;
    overflow-y: auto;
    padding: 10px;
    font-size: 18pt;
}

.myMsg {
    text-align: right;
}

.anotherMsg {
    text-align: left;
    margin-bottom: 5px;
}

.msg {
    display: inline-block;
    border-radius: 15px;
    padding: 7px 15px;
    margin-bottom: 10px;
    margin-top: 5px;

}

.anotherMsg > .msg {
    background-color: #f1f0f0;

}

.myMsg > .msg {
    background-color: #0084FF;
    color: #fff;
}

.anotherName {
    font-size: 12px;
    display: block;
}
button{
	width: 200px;
	height: 150px;
	top:30%;
	left:40%;
	position: absolute;
}
#open{
	font-size: 18pt;
}
#chatForm {
    display: block;
    width: 100%;
    height: 80px;
    border-top: 2px solid #f0f0f0;
}

#msg {
    width: 85%;
    height: calc(100% - 1px);
    border: none;
    padding-bottom: 0;
    font-size: 15pt;
}

#message:focus {
    outline: none;
}

#chatForm > input[type=submit] {
    outline: none;
    border: none;
    background: none;
    color: #0084FF;
    font-size: 17px;
}
</style>
<body>
<button class="btn btn-dark" id="open">채팅에 접속</button>

<div id=chatWrap style="display:none">
            <div id="chatHeader">CHAT</div>
            <div id="chatLog">
            </div>
            <div id=chatForm>
            <input type="text" autocomplete="off" size="30" id="msg" placeholder="메시지를 입력하세요" onkeypress="press();">
            <input type="submit" id="send" value="전송">
            </div>
        </div>
<script>

var ws;
window.onload = function(){
	document.querySelector('button').onclick = function(){
		var host = location.hostname;
		var url = 'ws://'+host+'//wst';	// /ws/chat
		var chat='';
		ws= new WebSocket(url);
		ws.onopen = function(evt){
			if(evt && evt.isTrusted){
				document.querySelector('#open').style.display = 'none';
				document.querySelector('#chatWrap').style.display = '';
				document.querySelector('#send').onclick = function(){
					var msg = document.querySelector('#msg').value;
					ws.send(msg);
				}
			}
		}
		ws.onmessage = function(evt){
			chat += evt.data + '<br>';
			document.querySelector('#chatLog').innerHTML = chat;
			document.querySelector('#msg').value = '';
		}
	}
}

function press(){ 
	 if(event.keyCode == 13){ //javascript에서는 13이 enter키를 의미함 
		var msg = document.querySelector('#msg').value;
		ws.send(msg);
	}
}
</script>
</body>
</html>