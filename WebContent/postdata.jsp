<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.wap.dao.imp.postdataDaoImplementation"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.8.2.js"></script>

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
	
<script type="text/javascript">

var locationX;
var locationY;

	$(function(){
		navigator.geolocation.getCurrentPosition(function(position) {

// 			console.log(position.coords.latitude)
// 			console.log(position.coords.longitude)

			var coords = position.coords;
			// 设定地图参数，将当前位置的经纬度设置为中心点
			locationX = coords.latitude;
			locationY = coords.longitude;
	  		$("#locationX_id").val(locationX);
	 		$("#locationY_id").val(locationY);
		 
		});
	})

</script>
</head>
<body>
	<form action="PostdataController" method="post" id="myform" name="myform">
	
		<div id="divpost">
			<table id="tblpost">
				<tbody>
					<tr>
						<td>Product you offer</td>
						<td><input type=text name="product_you_offer" ></td>
					</tr>
					<tr>
						<td>Description you offer</td>
						<td><input type=text name="describe_your_offer"></td>
					</tr>
					<tr>
						<td>Product you need</td>
						<td><input type=text name="product_you_need"></td>
					</tr>
					<tr>
						<td>Description you need</td>
						<td><input type=text name="describe_your_need"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						
						<button id="btnpost" type="submit" >Submit</button>
								</td>
					</tr>
				</tbody>
			</table>
		</div>
		
			<input type="hidden" name="locationX" id="locationX_id" value="" />
			<input type="hidden" name="locationY" id="locationY_id" value="" />
	</form>
</body>
</html>