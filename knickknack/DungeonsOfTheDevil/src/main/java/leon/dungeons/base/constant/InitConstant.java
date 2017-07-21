package leon.dungeons.base.constant;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import leon.dungeons.base.utils.MD5Utils;
import leon.dungeons.base.utils.StringUtils;

/**
 * 
 **************************************************
 *
 * @deprecated:		有关初始化的常量
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月17日 上午10:13:39
 * 
 **************************************************
 *
 */
public class InitConstant {

	private InitConstant() {}

	/**
	 * md5加密的盐
	 */
	public static final String				SALT			= "Leon.Lee";

	/**
	 * User类的全类名，工厂类创建对象时使用
	 */
	public static final String				USER_CLZ		= "leon.dungeons.model.User";

	/**
	 * GameMap类的全类名，工厂类创建对象时使用
	 */
	public static final String				GAME_MAP_CLZ	= "leon.dungeons.model.game.GameMap";

	/**
	 * 测试用创建User对象参数
	 */
	public static final Map<String, Object>	USER_ARG		= ImmutableMap.of(
			"userId", StringUtils.getUUID(), "userName", "admin", "userNickname",
			"admin", "userPassword", MD5Utils.sign("111111", SALT, "utf-8"));
}
