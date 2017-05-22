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

<body>

	<%
		Map<String, String> map1 = (Map<String, String>) request.getSession().getAttribute("AllData");
	%>

	<div class="container">
		<div class="avatar-flip">
			<img src="css/images/photo.jpg" height="100" width="100"> <img
				src="css/images/photo.jpg" height="100" width="100">
		</div>
		<h2><%=map1.get("fname") + " " + map1.get("lname")%></h2>
		<h4><%=map1.get("email")%></h4>
		<h4><%="Address: " + map1.get("address")%></h4>
		<h4><%="contactno: " + map1.get("contactno")%></h4>

		<a href="#"><h4>EDIT PROFILE</h4></a>
		<p>LOGOUT</p>

	</div>





</body>
</html>
