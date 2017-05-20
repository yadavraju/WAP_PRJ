<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.wap.dao.imp.postdataDaoImplementation"  %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="PostdataController" method="post">
		<div>
			Product you offer: <input type=text name="product_you_offer"><br>
			Description you offer: <input type=text name="describe_your_offer"><br>
			Product you need: <input type=text name="product_you_need"><br>
			Description you need: <input type=text name="describe_your_need"><br>
			Like count: <input type=text name="like_count"><br>
			Comment count<input type=text name="comment_count"><br>
			User ID<input type=text name="userid"><br>
		</div>
		<div>
		<button type=submit name="submit">Submit</button>
		</div>
	</form>
	<div>
		
		    Product you offer: <br>
			Description you offer: <br>
			Product you need: <br>
			Description you need: <br>
			Like count: <br>
			Comment count:<br>
			User ID:<br>
		</div>
</body>
</html>