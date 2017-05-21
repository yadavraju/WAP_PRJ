<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goods Swap - Login</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.8.2.js"></script>
<script src="js/layer.js"></script>
</head>
<body>

<button id="test2" class="button">运行上述例子</button>
<script>

//弹出一个页面层
$('#test2').on('click', function(){
  layer.open({
  type: 1,
  area: ['600px', '360px'],
  shadeClose: true, //点击遮罩关闭
  content: '\<\div style="padding:20px;">自定义内容\<\/div>'+$("#divid").html()+''
  });
});
</script>

<div id="divid" style="display:none">
<form action="">
00000000000000
</form>
</div>
</body>
</html>

