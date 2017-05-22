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
		<div id="divlogo">
			<img id="imglogo" src="" />
		</div>
		<div id="divfuncontop">
			<input id="search" placeholder="Enter product id" />
			<button id="btnPost" class="button">Post</button>
		</div>
	</div>
	<div id="divbody">
		<div id="divleftbody">
			<%@ include file="profile.jsp"%>
		</div>
		<div id="divrightbody">
			<c:forEach items="${list_of_posted_data}" var="post_data">
				<div id="card">
					<div id="container">
						<div id="avatar-flip" style="position: absolute;">
							<span style="display: inline-block; width: 80px; height: 50px"><img
								src="css/images/photo.jpg" height="50" width="50"></img></span> <span
								style="display: inline-block; width: 100px; height: 50px; position: absolute; top: 50%; left: 80px;"><b>John
									Doe</b></span>
						</div>
						<div id="abc" style="margin-top: 80px">
							<div>
								<span>OfferItem</span>
								<c:out value="${post_data.product_you_offer}"></c:out>
							</div>
							<div>
								<span>OfferItem Description</span>
								<c:out value="${post_data.describe_your_offer}"></c:out>
								<div>
									<span>Item you need</span>
									<c:out value="${post_data.product_you_need}"></c:out>
								</div>
								<div>
									<span>Describe your need</span>
									<c:out value="${post_data.product_you_need}"></c:out>
								</div>
								<div>
									<span>Posted Date</span>
									<c:out value="${post_data.date}"></c:out>
								</div>
								<div>
									<span style="display: inline-block;margin-left:10px" >
										<span >
										<a href=""><img src="css/images/Likes.png"> <span style="margin-top: 1px;vertical-align: middle;display: inline-block;height: 30px"> <c:out value="${post_data.like_count}"></c:out></span></a>
										</span>
										<span style="margin-left:30px">
										<a href=""><img src="css/images/Comments.png" >  Comment</a>
										</span>
									</span>
								</div>
							</div>
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