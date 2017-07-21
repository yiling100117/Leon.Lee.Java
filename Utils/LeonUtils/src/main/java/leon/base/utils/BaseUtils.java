package leon.base.utils;

import java.lang.reflect.Array;
import java.util.List;

import leon.base.utils.string.StringUtils;

/**
 * *******************************************************************************
 * <p>基础的、通用的工具类，包括各种判断方法
 * 
 * @author LeonLee
 * @date 2017年6月15日 下午2:36:39 
 * *******************************************************************************
 */
public class BaseUtils {
	
	private BaseUtils() {}
	
	/**
	 * 
	 * *******************************************************************************
	 *
	 * <p>KW:Empty,判断是否为空,null
	 *
	 * <p>判断一个对象<code>(obj)</code>是否为指定类型的对象<code>(clz)</code>
	 * 
	 * <p>基本类型和对应的包装类返回<code>(true)</code>
	 * 
	 * <p>任一参数为<code>(null)</code>则返回<code>(false)</code>
	 *
	 * @param obj 待判断的对象
	 * @param clz 指定对象
	 * @return boolean值，是指定类型返回<code>(true)</code>，否则返回<code>(false)</code>
	 * @author LeonLee
	 * @date 2017年2月27日14:13:39
	 * 
	 * *******************************************************************************
	 */
	public static <T> boolean isClass(T obj, Class<?> clz) {
		if (obj != null && clz != null) {
			return clz.isAssignableFrom(obj.getClass());
		}
		return false;
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:非空判断
	 *
	 * <p>判断一个对象<code>(obj)</code>是否为空
	 * 
	 * <p>若待判断的对象<code>(obj)</code>为字符串,则判断这个字符串是否空字符串或字符串<code>("null")</code>，
	 * 空字符串或<code>("null")</code>时返回<code>(true)</code>
	 * 
	 * <p>字符串的判断调用了<code>({@link StringUtils #isEmpty(String)})</code>
	 * 
	 * <p>若待判断的对象<code>(obj)</code>为数组,则判断这个数组长度是否为0，长度为0返回<code>(true)</code>
	 * 
	 * <p>参数为<code>(null)</code>则返回<code>(true)</code>
	 * 
	 * <p>内联调用了<code>({@link #isClass(Object, Class)})</code>
	 * 
	 * @param obj 待判断的对象
	 * @return 若空返回<code>(true)</code>，否则返回<code>(false)</code>
	 * @author LeonLee
	 * @date 2017年6月13日 上午8:54:33 
	 * *******************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	public static <T> boolean isEmpty(T obj) {
		if (obj != null) {
			if (isClass(obj, String.class)) {
				return StringUtils.isEmpty((String) obj);
			} else if (isClass(obj, List.class)) {
				return 0 == ((List) obj).size() ? true : false;
			} else {
				Class<? extends Object> objClz = obj.getClass();
				if (objClz.isArray()) {
					return !(boolean) (Array.getLength(obj) > 0) ? true : false;
				}
			}
			return false;
		}
		return true;
	}
}
