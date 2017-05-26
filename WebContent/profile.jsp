<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pure CSS Profile Card Hover Effect</title>
<link rel="stylesheet" href="css_profile/reset.css">
<link rel="stylesheet" href="css_profile/style.css">

</head>
<script>

 

function  img_onclick(){
	  layer.open({
		  type: 1,
		  area: ['600px', '360px'],
		  shadeClose: true, //点击遮罩关闭
		  title:'<h3 style="font-size:25px;font-weight:bold">upload avatar</h3>',
		  content: $("#div_img").html()+''
		  });
}


function divfunc(){
	 $("#img_id_id").attr("src","<%=request.getContextPath() %>/AvatarUpload/user_${sessionScope.id}_100.jpg?"+Math.random());
	 $('#layui-layer-moves, div[id^="layui-layer-shade"],div[id^="layui-layer-shade"],div[id^="layui-layer"]').remove();
 }
</script>
<body>

	<%
		Map<String, String> map1 = (Map<String, String>) request.getSession().getAttribute("AllData");
	%>

	<div class="container">
		<div class="avatar-flip">
			<a style="cursor: pointer" id="img_id" onclick="img_onclick()">
			<img src="<%=request.getContextPath() %>/AvatarUpload/user_<%=(String)request.getSession().getAttribute("id") %>_100.jpg" id="img_id_id" height="100" width="100"></a>
		</div>
		<h2><%=map1.get("fname") + " " + map1.get("lname")%></h2>
		<h4><%=map1.get("email")%></h4>
		<h4><%="Address: " + map1.get("address")%></h4>
		<h4><%="contactno: " + map1.get("contactno")%></h4>

		<a href="#"><h4>EDIT PROFILE</h4></a>
		<p>LOGOUT</p>

	</div>


	<div id="div_img" style="display: none">
		<iframe src="AvatarUpload/index.html"   name="mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="320" width="100%" style="overflow-x:hidden;overflow-y:hidden;"></iframe>
	</div>
 

</body>
</html>
