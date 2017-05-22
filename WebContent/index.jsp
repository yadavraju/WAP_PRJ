<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Goods Swap</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css_profile/reset.css">
<script src="js/jquery-1.8.2.js"></script>
<script src="js/layer.js"></script>
<script>
	$(function() {
		$('#btnPost').on('click', function() {
			layer.open({
				type : 1,
				title : 'Make a post',
				area : [ '500px', '276px' ],
				shadeClose : true,
				content : '' + $("#divid").html() + ''
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
			<%@ include file="profile.jsp"%>
		</div>
		<div id="divrightbody">
			<c:forEach items="${list_of_posted_data}" var="post_data">
				<div id="card">
					<div id="container">
						<div id="avatar-flip">
							<span><img src="css/images/photo.jpg" height="50" width="50"></img></span>
							<span><h4><b>John Doe</b></h4></span>
						</div>
						<p>
							OfferItem :
							<c:out value="${post_data.product_you_offer}"></c:out>
						</p>
						<p>
							OfferItem Description :
							<c:out value="${post_data.describe_your_offer}"></c:out>
						<p>
							Item you need :
							<c:out value="${post_data.product_you_need}"></c:out>
						</p>
						<p>
							Describe your need :
							<c:out value="${post_data.product_you_need}"></c:out>
						</p>
						<p>
							Posted Date :
							<c:out value="${post_data.date}"></c:out>
						</p>

						<div>
							<span>Like : <c:out value="${post_data.like_count}"></c:out></span>
							<span>Comment : <c:out value="${post_data.comment_count}"></c:out></span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- popup window -->
	<div id="divid" style="display: none">
		<%@ include file="postdata.jsp"%>
	</div>
</body>
</html>