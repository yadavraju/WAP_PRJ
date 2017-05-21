<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Goods Swap</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.8.2.js"></script>
<script src="js/layer.js"></script>
<script>
	$(function() {
		$('#btnPost').on('click', function(){
			  layer.open({
			  type: 1,
			  title:'Make a post',
			  area: ['600px', '360px'],
			  shadeClose: true, 
			  content: ''+$("#divid").html()+''
			  });
			});
	})

	</script>
</head>
<body>
	<div id="divheader">
		<p>
			<img id="imglogo" src="" /> <input id="search"
				placeholder="Enter product id" />
			<button id="btnPost" class="button">Post</button>
		</p>
	</div>
	<div id="divbody">
		<div id="divleftbody">
		<%@ include file="profile.html" %>
		</div>
		<div id="divrightbody"></div>
	</div>
	
	<!-- popup window -->
	<div id="divid" style="display: none">
		


	</div>
</body>
</html>