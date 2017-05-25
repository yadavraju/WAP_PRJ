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
	
	function toggleComment(postid) {
		var divid = "#div" + postid;
		if($(divid).css("display") == "none") {
			$(divid).css("display","block");
		}
		else
			$(divid).css("display","none");
	}
	
	function updateComment(userid, postid) {
		var comment = $("#writecomment"+postid).val();
// 		var url = "CommentController?userid=" + userid + "&postid=" + postid + "&comment=" + comment;
// 		console.log("url=" + url);
		if(comment != "")
		{
			$.get("CommentController" ,{userid:userid,postid:postid,comment:comment})
			.done(function(data) {
				console.log("Comments added successfully");
				$("#writecomment"+postid).val("");
				$("#divcomments"+postid).append("<span><em style=color:blue>" + userid + "</em> " + comment + "</span><br/>");
				//$("html,body").animate({scrollTop:$("#wc"+postid).offset().top},1000);
// 				$("#divcomments"+postid).html($("#divcomments"+postid).html()+"<span>" + comment + "</span><br/>");

			})
		}
	}
	
	function updateLikes(userid, postid) {
// 		var url = "IncrementLikeServlet?postid=" + postid;
// 		console.log("url=" + url);
		$.get("IncrementLikeServlet" ,{userid:userid, postid: postid})
		.done(function(data) {
			console.log("Likes added successfully----" + data);
			if(data == 1) {
				console.log("data----" + data);
				var curLikeCount = parseInt($("#likesvalue"+postid).text());
				$("#likesvalue"+postid).text(curLikeCount + 1);
			}
		})

	}
</script>
</head>
<body>
	<div id="divheader">
		<div id="divlogo">
			<img id="imglogo" src="" />
		</div>
		<div id="divfuncontop">
			<input id="inputsearch" placeholder="Enter product id" style="width: 280px"/>
			<a href=""><img src="css/images/Search.png" style="vertical-align: bottom"/></a>
			<button id="btnPost" class="button" style="margin-left:50px">Post</button>
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
										<a style="cursor: pointer" onclick="updateLikes(${sessionScope.id},${post_data.pid})"><img src="css/images/Likes.png"> <span id="likesvalue${post_data.pid}" style="margin-top: 1px;vertical-align: middle;display: inline-block;height: 30px"> <c:out value="${post_data.like_count}"></c:out></span></a>
										</span>
										<span style="margin-left:30px">
										<a style="cursor: pointer" onclick="toggleComment(${post_data.pid})"><img src="css/images/Comments.png" >  Comment</a>
										</span>
									</span>
								</div>
								<div id="div${post_data.pid}" class="cdivcomment" style="display:none;width:50%;border: 1px solid gray;border-radius:10px">
									<div id="divcomments${post_data.pid}" style="margin-left:15px">
										<c:forEach items="${post_data.listCommentModel}" var="post_comment_data">
											<span><em style="color:blue">${post_comment_data.userid}</em> ${post_comment_data.comment}</span><br/>
										</c:forEach>
									</div>
<%-- 									<div id="appendcomment${post_data.pid}" style="margin-left:15px"> --%>
<!-- 									</div> -->
									<span>
										<input id="writecomment${post_data.pid}" style="margin-left:15px" id="inputcomment" placeholder="Write a comment..." />
										<button onclick="updateComment(${sessionScope.id},${post_data.pid})">Enter</button><br/><br/>
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