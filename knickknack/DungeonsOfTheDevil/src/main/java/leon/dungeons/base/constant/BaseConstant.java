package leon.dungeons.base.constant;

/**
 * 
 **************************************************
 *
 * @deprecated:		系统的基础常量
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月17日 上午10:13:16
 * 
 **************************************************
 *
 */
public class BaseConstant {

	private BaseConstant() {}

	/**
	 * 地形的种类
	 */
	public static final int		LAND_TYPE_NUM	= 2;

	/**
	 * session中存放登录信息的KEY使用
	 */
	public static final String	LOGIN_INFO		= "userLoginInfo";

	/**
	 * 地图参数，地图的高度(y值，表示有多少行row)
	 */
	public static final int		MAP_HEIGHT		= 10;

	/**
	 * 地图参数，地图的宽度(x值，表示有多少列col)
	 */
	public static final int		MAP_WIDTH		= 10;
}
