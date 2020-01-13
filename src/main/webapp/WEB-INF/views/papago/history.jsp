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
tr{
background-color: #04B404;
color: white;
font-size:20px;
}

button{
position:relative;
left:45%;
width:150px;
height:100px;
margin-bottom:10px;
}
#pagination{
	font-size:15pt;
	cursor: pointer;
}
#container{
	position:absolute;
	top:10%;
	left:10%;
  margin-bottom: 30px;
  width:1500px;
  height:900px;
}

</style>
<body>
<div id=container>
<button id=lookup class="btn btn-success" style="font-size: 40px; font-family: 'Cute Font'; border-radius: 5em;">조회하기</button>
<table id=layer class="table table-hover" data-id="all" style="visibility:hidden;">
  <thead>
     <tr>
      <th scope="col" data-order="ps_num desc">기록 번호▼</th>
      <th scope="col" data-order="ps.ui_num desc">검색한 ID번호▼</th>
      <th scope="col" data-order="ui_Id desc">검색한 ID▼</th>
      <th scope="col" data-order="pi_num desc">검색 번호▼</th>
      <th scope="col" data-order="ps.credat desc">검색 날짜▼</th>
    </tr>
  </thead>
  <tbody id="tBody">
  </tbody>
</table>
<div id="pagination" align="center" style="visibility:hidden;"></div>
</div>
<script>
var rowCount=10;

function dataLoad(data){
	var conf={
		url:'/papago/stats',
		method:'GET',
		data:(data==2)? 'page.page='+data : data,
		beforeSend: function(xhr){
			xhr.setRequestHeader('x-ajax', 'true');
		},
		success:function(res){
			var statList = res.list;
			var tBody=document.getElementById('tBody');
			var html ='';
			for(var stat of statList){
				html += '<tr class="table-default">';
				html += '<td>' + stat.psNum+ '</td>';
				html += '<td>' + stat.uiNum + '</td>';
				html += '<td>' + stat.uiId + '</td>';
				html += '<td>' + stat.piNum + '</td>';
				html += '<td>' + stat.credat +'</td>';
				html += '</tr>';
				}
			$('#tBody').html(html);
			//document.querySelector('#tBody').innerHTML = html; 같은 의미
			var totalPage = Math.ceil(res.page.totalCount/rowCount);
			var sPage = Math.floor((res.page.page-1)/10)*10+1;
			var ePage = sPage + 9;
			if(ePage>totalPage){
				ePage=totalPage;
			}
			var html2 = '';
			if(sPage!=1){
				html2 += '<a data-page="'+(sPage-1) +'">◀</a>';
			}
			for(var i=sPage;i<=ePage;i++){
				if(i==res.page.page){
					html2+='<b>['+i+']</b>';
				}else{
					html2 += '<a data-page="'+i+'">[' + i + ']</a>';
				}
			}
			if(ePage!=totalPage){
				html2 += '<a data-page="'+ (sPage+10) +'">▶</a>';
			}
			$('#pagination').html(html2);
			setEvent();
			console.log(res);
		},
		error:function(res){
			console.log(res);
		}
	}
	ajax(conf);
}

$(document).ready(function() {
	
	$('#lookup').on('click',function (){
		layer.style.visibility="visible";
		pagination.style.visibility="visible";
		this.style.display = 'none';
	})
			$('th[data-order]').on('click', function() {
				var ord = this.getAttribute('data-order');
				var text = this.innerText;
				var symbol = text.substring(text.length - 1, text.length);
				if (symbol == '▼') {
					this.innerText = text.substring(0, text.length - 1) + '▲';
					this.setAttribute('data-order',ord.substring(0,ord.length-4)+' asc');
				} else {
					this.innerText = text.substring(0, text.length - 1) + '▼';
					this.setAttribute('data-order',ord.substring(0,ord.length-4)+' desc');
				}
				var param = 'order=' + this.getAttribute('data-order');
				dataLoad(param);
			})
			$('#pagination').on('click', function() {
			dataLoad(2);
		})
		dataLoad(1);
	})

function setEvent(){
	$('a[data-page]').on('click',function(){
		dataLoad(this.getAttribute('data-page'));
	})
	$('td[data-name]').on('click',function(){
		var num = this.getAttribute('data-name');
		location.href='/?page=test-view&tiNum='+num;	
	}) 
}

</script>
</body>
</html>
