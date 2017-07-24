package leon.base.utils.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import leon.base.constant.ExInfoConstant;
import leon.base.utils.BaseUtils;

import java.util.Set;
import java.util.TreeMap;

/**
 * *******************************************************************************
 * <p>Map集合相关的基础、通用工具类
 * 
 * @author LeonLee
 * @date 2017年6月15日 下午3:03:06 
 * *******************************************************************************
 */
public class MapUtils {
	
	private MapUtils() {}
	
	/**
	 * *******************************************************************************
	 * <p>KW:map,移除空值元素
	 *
	 * <p>移除map中值<code>(value)</code>为空的键值对<code>(entry)</code>
	 * 
	 * <p>判断是否为空的方法引用了<code>({@link BaseUtils #isEmpty(T obj)})</code>
	 * 
	 * @param map 待移除空值元素的map集合
	 * @return 返回移除空值后的map集合
	 * @author LeonLee
	 * @date 2017年6月12日 下午4:54:17 
	 * *******************************************************************************
	 */
	public static <K, V> Map<K, V> removeNullVal(Map<K, V> map) {
		if (map != null) {
			Set<Entry<K, V>> entrySet = map.entrySet();
			Iterator<Entry<K, V>> it = entrySet.iterator();
			while (it.hasNext()) {
				Entry<K, V> e = it.next();
				if (BaseUtils.isEmpty(e.getValue())) {
					it.remove();
				}
			}
		}
		return map;
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:遍历输出map集合
	 *
	 * <p>遍历输出map集合中的键值对
	 * 
	 * @param map 待遍历输出的map集合
	 * @author LeonLee
	 * @date 2017年6月15日 下午3:07:55 
	 * *******************************************************************************
	 */
	public static <K, V> void prnMap(Map<K, V> map) {
		if (map != null) {
			Set<Entry<K, V>> entrySet = map.entrySet();
			Iterator<Entry<K, V>> it = entrySet.iterator();
			System.out.println("-----开始输出map中的内容-----");
			while (it.hasNext()) {
				Entry<K, V> e = it.next();
				System.out.println("Key:" + e.getKey() + " --- Value:" + e.getValue());
			}
			System.out.println("-----map中的内容输出结束-----");
		} else {
			throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
		}
	}
	
	/**
	 * 
	 **************************************************
	 *
	 * @deprecated:		根据Map中的Key值来对Map中的内容进行排序
	 * 					<p>使用的是{@link java.util.TreeMap}来实现的
	 * 					<p>返回的Map实质上是一个TreeMap
	 *
	 *
	 * @author:			Leon
	 * @version:		1.0
	 * @date:			2017年7月21日 下午4:59:21
	 *
	 * @param map
	 * @return 
	 **************************************************
	 *
	 */
	public static <K,V> Map<K,V> srotByKey(Map<K,V> map){
		Map<K,V> result = new TreeMap<K,V>();
		result.putAll(map);
		return  result;
	}
}
