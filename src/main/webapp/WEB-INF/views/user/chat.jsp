<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous">
</script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
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

#chatForm {
    display: block;
    width: 100%;
    height: 80px;
    border-top: 2px solid #f0f0f0;
}

#message {
    width: 85%;
    height: calc(100% - 1px);
    border: none;
    padding-bottom: 0;
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
    <div id="chatWrap">
            <div id="chatHeader">CHAT</div>
            <div id="chatLog">
            </div>
            <form id="chatForm">
                <input type="text" autocomplete="off" size="30" id="message" placeholder="메시지를 입력하세요">
                <input type="submit" value="전송">
            </form>
        </div>
    </body>
<script>
$(function () {
$chatForm.submit(function (e) {
    e.preventDefault();
    let msg = $("#message");
    if (msg.val() === "") {
        return false;
    } else {
        let data = {
            uiId: uiId,
            msg: msg.val()
        };
        socket.emit("send message", data);
        msg.val("");
        msg.focus();
    }
});

$joinForm.submit(function (e) {
    e.preventDefault();
    let id = $("#joinId");
    let pw = $("#joinPw");
    if (id.val() === "" || pw.val() === "") {
        alert("check validation");
        return false;
    } else {
        socket.emit('join user', {
            id: id.val(),
            pw: pw.val()
        }, function (res) {
            if (res.result) {
                alert(res.data);
                id.val("");
                pw.val("");
                $("#loginBtn").click();
            } else {
                alert(res.data);
                return false;
            }
        });
    }
});

socket.on('new message', function (data) {
    if (data.socketId === socketId) {
        $chatLog.append(`<div class="myMsg msgEl"><span class="msg">${data.msg}</span></div>`)
    }else {
        $chatLog.append(`<div class="anotherMsg msgEl"><span class="anotherName">${data.name}</span><span class="msg">${data.msg}</span></div>`)
    }
    $chatLog.scrollTop($chatLog[0].scrollHeight - $chatLog[0].clientHeight);
});
});

</script>
</html>