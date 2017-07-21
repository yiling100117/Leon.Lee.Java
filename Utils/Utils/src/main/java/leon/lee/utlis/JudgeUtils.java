package leon.lee.utlis;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import leon.lee.utlis.string.StringUtils;

/**
 * <p>用于各种逻辑判断的工具类
 * 
 * @author ly
 * @date 2017年2月3日 下午5:33:35
 */
public class JudgeUtils {
	
	private JudgeUtils() {
		
	}
	
	/**
	 * <p>用来判断指定的数组(arr)中是否有特定的某个元素(obj)
	 * 
	 * <p>支持包装类数组和基本类型的查询
	 * 
	 * <p>引用类型是否为同一对象要看equals方法是否相等，即大多数对象可能需要重写equals方法才能得到正确的结果
	 * 
	 * <p>任一参数为空则返回null
	 * 
	 * <p>支持String数组中查询int和Integer
	 * 
	 * <p>数组不支持基本类型数组，需要手动换成对应的包装类数组
	 * 
	 * @param arr 指定的数组
	 * @param obj 特定的元素
	 * @return 指定的数组中包含特定的元素返回该元素，否者返回null
	 * <p>任一参数为null则返回null
	 *
	 * @author LeonLee
	 * @date 2017年2月23日 下午2:44:53
	 */
	public static <T> T inArray(T[] arr, T obj) {
		if (arr != null && obj != null) {
			for (T ar : arr) {
				if (ar.equals(obj)) {
					return obj;
				}
			}
		}
		return null;
		/*
		if(obj==null){
			for(T ar:arr){
				if(ar==null){
					return obj;
				}
			}
		}else{
			for(T ar:arr){
				if(ar.equals(obj)){
					return obj;
				}
			}
		}
		return null;*/
	}
	
	/**
	 * <p>判断一个对象(obj)是否为指定对象(clz)
	 * 
	 * <p>基本类型和对应的包装类返回true
	 * 
	 * <p>任一参数为null则返回false
	 * 
	 * @param obj 待判断的对象
	 * @param clz 指定对象
	 * @return boolean值，是字符串返回true，否则返回false
	 * @author LeonLee
	 * @date 2017年2月27日14:13:39
	 */
	public static <T> boolean isClass(T obj, Class<?> clz) {
		if (obj != null && clz != null) {
			return clz.isAssignableFrom(obj.getClass());
		}
		return false;
	}
	
	/**
	 * <p>判断一个对象(obj)是否为空
	 * <p>若obj为字符串则判断这个字符串是否空字符串或字符串"null"，空字符串或"null"时返回true
	 * <p>若obj为数组则判断这个数组长度是否为0，长度为0返回true
	 * <p>任一参数为null则返回true
	 * 
	 * @param obj 待判断的对象
	 * @return 若空返回true，否则返回false
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
	
	/**
	 * <p>判断指定的map中是否包含指定的key，若包含就返回它对应的value，若没有就返回null
	 * 
	 * <p>任一参数为空就返回null
	 *
	 * @param map
	 * @param key
	 * @return
	 * @author ly
	 * @date 2017年3月4日 下午3:10:15
	 */
	public static <K, V> V inMap(Map<K, V> map, K key) {
		if (map != null && key != null) {
			if (map.containsKey(key)) {
				return map.get(key);
			}
		}
		return null;
	}
}
