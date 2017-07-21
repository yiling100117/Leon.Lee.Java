package leon.dungeons.controller.start;

import java.util.HashMap;
import java.util.Map;

import leon.dungeons.model.abst.MapAbst;

class StartUtils {

	static Map<String, MapAbst>	mapCache	= new HashMap<String, MapAbst>();

	static Map<String, MapAbst>	trapCache	= new HashMap<String, MapAbst>();

	void cacheMap(MapAbst map) {
		// 将缓存中没有的地图添加到缓冲中
		if (!mapCache.containsKey(map.getMapNo())) {
			mapCache.put(map.getMapNo(), map);
		}
	}

	MapAbst getCacheMap(String mapNo) {
		// 从缓存中去出地图，没有改地图就返回null
		if (mapCache.containsKey(mapNo)) {
			return mapCache.get(mapNo);
		}
		return null;
	}

	MapAbst createMap() {

		return null;
	}
}
