<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CommentController" method="post">
<div>
postid: <input type=text name=postid><br>
userid: <input type=text name=userid><br>
comment:<textarea rows="10" cols="10" name=comment></textarea><br>
<button type="submit" name=submit>Submit</button>
</div>

</form>
</body>
</html>