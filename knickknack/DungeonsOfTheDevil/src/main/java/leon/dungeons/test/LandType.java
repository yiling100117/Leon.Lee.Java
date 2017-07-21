package leon.dungeons.test;

/**
 * 
 **************************************************
 *
 * @deprecated:		枚举表示地形(没有使用)
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月17日 上午11:15:42
 * 
 **************************************************
 *
 */
public enum LandType {

	EMPTY(0), WALL(1);

	private LandType(int type) {
		this.type = type;
	}

	private int	type;

	public int getType() {
		return type;
	}

	public static LandType getLandType(int type) {
		if (type == 1) {
			return WALL;
		} else {
			return EMPTY;
		}
	}
	
}
