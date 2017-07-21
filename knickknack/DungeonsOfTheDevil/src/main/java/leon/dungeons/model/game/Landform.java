package leon.dungeons.model.game;

import java.util.Random;

import leon.dungeons.base.constant.BaseConstant;

/**
 * 
 **************************************************
 *
 * @deprecated:		表示一个格子的地形
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017-7-6 下午3:57:17
 * 
 **************************************************
 *
 */
public class Landform {

	//表示地形
	private int landType;

	public Landform() {
		Random ran = new Random();
		//根据地形数量随机生成地形
		landType = ran.nextInt(BaseConstant.LAND_TYPE_NUM);
	}

	public int getLandType() {
		return landType;
	}

}
