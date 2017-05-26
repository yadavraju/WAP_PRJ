<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>Google Map</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
	var locationX;// 经度
	var locationY;// 纬度
	
	
	function init() {
		// 获取当前位置
		navigator.geolocation.getCurrentPosition(function(position) {
			var coords = position.coords;
			// 设定地图参数，将当前位置的经纬度设置为中心点
			locationX = coords.latitude;
			locationY = coords.longitude;
			var xy = document.getElementById("locationXY");
			xy.innerHTML = "Latitude: " + locationX + " ,    Longitude: " + locationY;

			var geocoder = new google.maps.Geocoder();
			//2.地理反解析过程
			//请求数据GeocoderRequest为location，值类型为LatLng因此我们要实例化经纬度
			geocoder.geocode({
				location : new google.maps.LatLng(locationX, locationY)
			}, function geoResults(results, status) {
				//这里处理结果和上面一模一样
				if (status == google.maps.GeocoderStatus.OK) {
					// alert('地理反解析结果：' + results[0].formatted_address);
					//alert('地理反解析结果：' + results[0].geometry.location);
					var Lname = document.getElementById("locationName");
					Lname.innerHTML = results[0].formatted_address;
				} else {
					//alert("：error " + status);
				}
			});

			var latlng = new google.maps.LatLng(locationX, locationY);
			var myOptions = {
				// 放大倍数
				zoom : 14,
				// 标注坐标
				center : latlng,
				// 地图类型
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			var map1;
			// 显示地图
			map1 = new google.maps.Map(document.getElementById('map'),
					myOptions);
			// 创建标记
			var marker = new google.maps.Marker({
				position : latlng,
				map : map1
			});
			// 设定标注窗口，附上注释文字
			var infowindow = new google.maps.InfoWindow({
				content : "You are here!"
			});
			// 打开标注窗口
			infowindow.open(map1, marker);
		});
	}
</script>
</head>
<body onload="init()">
	<div id="map" style="width: 400px; height: 400px"></div>
	<div id="locationXY" style="width: 400px; height: 30px"></div>
	<div id="locationName" style="width: 400px; height: 30px"></div>
</body>
</html>