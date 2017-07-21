/* -----地图载入相关的js----- */


/* -----加载地图----- */
function createMap(gameMap,path){
	
	var mapNo=gameMap.mapNo;//地图编号
	var grid=gameMap.landform;//地图json
	var map=$("#map");//地图div
	var html="";
	
	for(var i=0;i<grid.length;i++){
		html+="<div class='row'>";
		for(var j=0;j<grid[i].length;j++){
			html+=('<div class="grid"><img src="'+path+'/img/d'+grid[i][j].landType
					+'.jpg"/></div>');
		}
		html+="</div>";
	}
	map.append(html);
	
	/* -----异步加载地图陷阱----- */
	map=lodingTrap(map,mapNo,path);
	
	return map;
}

/* -----异步加载地图陷阱----- */
function lodingTrap(map,mapNo,path){
	$.ajax({
		type:'POST',
	    url:'getTrap' ,
	    data:{"mapNo":mapNo},
	    dataType:'json',
	    success: function(data) {
	    	var traps=data.traps;
	    	var trapElem="";
	    	var left=0;//整数
			var top=0;
	    	for(var i=0;i<traps.length;i++){
	    		trapElem+="<div class='trap' style='z-index:920;position:absolute;left:"
	    			+(traps[i].x*32+left)+"px;top:"+(traps[i].y*32+top)
	    			+"px;' ><img src='"+path+"/img/t"+traps[i].trapType+
	    			".jpg' /></div>";
	    	}
	    	map.append(trapElem);
	    	return map;
	    },
	    error : function() { 
	    	alert("error");
	    }
	});
}
