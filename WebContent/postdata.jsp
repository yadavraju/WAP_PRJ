<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.wap.dao.imp.postdataDaoImplementation"  %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form action="PostdataController" method="post">
		<div id="divpost">
			<table id="tblpost"><tbody>
				<tr><td>Product you offer</td><td><input type=text name="product_you_offer"></td></tr>
				<tr><td>Description you offer</td><td><input type=text name="describe_your_offer"></td></tr>
				<tr><td>Product you need</td><td><input type=text name="product_you_need"></td></tr>
				<tr><td>Description you need</td><td><input type=text name="describe_your_need"></td></tr>
				<tr><td colspan="2" align="center"><button id="btnpost" type=submit name="submit">Submit</button></td></tr>
			</tbody></table>
		</div>
	</form>
</body>
</html>