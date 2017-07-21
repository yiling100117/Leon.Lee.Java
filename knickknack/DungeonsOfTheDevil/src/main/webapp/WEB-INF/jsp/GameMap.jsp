<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>Map</title>
		
		<link rel="stylesheet" href="<%=path%>/css/GameMap.css" type="text/css" />
		
		<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>/js/map.js"></script>
		
		<script type="text/javascript">
			$(function(){
				var map=${map};
				var mapNo=map.mapNo;
				
				/* -----加载地图----- */
				map=createMap(map,'<%=path%>');
				
				/* ----- 加载地图操作面板 ----- */
				var mapOperate=$("#mapOperate");
				var html="";
				html+="<div class='operate'><lable class='operateLabel'>地图操作</lable>";
				html+="</div>";
				mapOperate.append(html);
			});
		</script>
		
	</head>
	<body>
		<div id="mapDiv">
			<div id="map" class="map"></div>
		</div>
		<div id="operateDiv">
			<div id="mapOperate"></div>
		</div>
	</body> 
</html>

