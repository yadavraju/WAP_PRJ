<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" border=1 cellspacing="0">
<tr>
<td>pid</td>
<td>product_you_offer</td>
<td>describe_your_offer</td>
<td>product_you_need</td>
<td>describe_your_need</td>
<td>like_count</td>
<td>comment_count</td>
<td>userid</td>
<td>date</td>
<td>delete</td>
</tr>
<c:forEach items="${postdataList}" var="postdata" varStatus="st">
<tr>
<td>${postdata.pid}</td>
<td>${postdata.product_you_offer}</td>
<td>${postdata.describe_your_offer}</td>
<td>${postdata.product_you_need}</td>
<td>${postdata.describe_your_need}</td>
<td>${postdata.like_count}</td>
<td>${postdata.comment_count}</td>
<td>${postdata.userid}</td>
<td>${postdata.date}</td>
<td><a href="DeletePostdata?pid=${postdata.pid}">delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>