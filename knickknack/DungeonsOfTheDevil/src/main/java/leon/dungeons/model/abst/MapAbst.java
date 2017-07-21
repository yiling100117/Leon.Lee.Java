package leon.dungeons.model.abst;

import leon.dungeons.model.game.GameMap;
import leon.dungeons.model.game.Landform;

/**
 * 
 **************************************************
 *
 * @deprecated:		所有种类地图的父类
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月18日 下午3:28:46
 * 
 **************************************************
 *
 */
public abstract class MapAbst {

	protected String		mapNo;		// 无论和种地图都必须有地图编号

	protected Landform[][]	landform;	// 无论和种地图都必须有地形

	public String getMapNo() {
		return mapNo;
	}

	// 获取landform字段的真实数据代替getLandform()方法
	public Landform[][] getOriginalLandform() {
		return landform;
	}

	// 地图的是否相等，根据地图编号判断
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapNo == null) ? 0 : mapNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameMap other = (GameMap) obj;
		if (mapNo == null) {
			if (other.mapNo != null)
				return false;
		} else if (!mapNo.equals(other.mapNo))
			return false;
		return true;
	}
}
