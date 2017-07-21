package leon.special.instance.factory;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import leon.base.constant.ExInfoConstant;

/**
 * *******************************************************************************
 * <p>工厂方法
 * 
 * @author LeonLee
 * @date 2017年6月16日 上午11:32:48 
 * *******************************************************************************
 */
public class BaseFactoryMethod {
	
	private BaseFactoryMethod() {}
	
	/**
	 * 单例缓存
	 */
	@SuppressWarnings("rawtypes")
	private static Map<Class, Object>	cache		= new LinkedHashMap<Class, Object>();
	/**
	 * 缓存的最大对象数，如果已经缓存了最大对象数<code>(CACHE_MAX)</code>的对象，想要缓存新对象时，
	 * 就会将最早缓存的<code>(CACHE_MAX/2-1)</code>个对象移出缓存
	 */
	private static final int			CACHE_MAX	= 50;
	
	/**
	 * *******************************************************************************
	 * <p>KW:静态工厂方法
	 *
	 * <p>静态工厂方法，生成一个目标类型<code>(clz)</code>的对象
	 * 
	 * <p>如果目标类型<code>(clz)</code>使用了<code>({@link SingleFactoryCache})</code>注解就会生成单例对象
	 * 即：每次调用该方法返回的都是同一个对象
	 * 
	 * @param clz 想要生成对象的类型
	 * @return 一个目标类型<code>(clz)</code>的对象
	 * @author LeonLee
	 * @date 2017年6月16日 上午11:33:48 
	 * *******************************************************************************
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getInstance(Class clz) {
		if (clz != null) {
			if (clz.isAnnotationPresent(SingleFactoryCache.class)) {
				return (T) useCache(clz);
			} else {
				return (T) instanceObject(clz);
			}
		}
		throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:带参静态工厂方法
	 *
	 * <p>带参静态工厂方法，生成一个全局变量自定义的目标类型<code>(clz)</code>的对象
	 * 
	 * <p>如果目标类型<code>(clz)</code>使用了<code>({@link SingleFactoryCache})</code>注解就会生成单例对象
	 * 即：每次调用该方法返回的都是同一个对象
	 * 
	 * <p>第一次使用该方法为全局变量赋值后，不想改变全局变量的值可以调用<code>({@link #getInstance(Class)})</code>
	 * 方法获取对象，想要改变全局变量的值时再次调用该方法并传入新的全局变量参数<code>(args)</code>即可
	 * 
	 * @param clz 想要生成全局变量自定义对象的类型
	 * @param args 全局变量的名和值组成的map集合
	 * @return 一个<code>(clz)</code>类型的对象
	 * @author LeonLee
	 * @date 2017年6月16日 上午11:39:13 
	 * *******************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T getInstance(Class clz, Map<String, Object> args) {
		if (clz != null && args != null) {
			try {
				@SuppressWarnings("unchecked")
				T t = (T) getInstance(clz);
				Set<Entry<String, Object>> entrySet = args.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					Field field = t.getClass().getDeclaredField(entry.getKey());
					field.setAccessible(true);
					field.set(t, entry.getValue());
				}
				return t;
			} catch (Exception e) {
				throw new RuntimeException(ExInfoConstant.CAN_NOT_INSTANCE, e);
			}
		}
		throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
	}
	
	/*
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>查看缓存中有没有指定类型的对象，若有返回缓存中的对象，没有则创建新的对象并放入缓存
	 * 
	 * <p>创建新对象前会判断缓存有没有达到最大缓存数，如果达到就移除最早缓存的一部分对象
	 * 
	 * @param clz
	 * @return
	 * @author LeonLee
	 * @date 2017年6月16日 下午3:36:05 
	 * *******************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	private static Object useCache(Class clz) {
		Object instance = null;
		if (cache.containsKey(clz)) {
			instance = cache.get(clz);
		} else {
			instance = instanceObject(clz);
			if (cache.size() == CACHE_MAX) {
				removeCacheEle();
			}
			cache.put(clz, instance);
		}
		return instance;
	}
	
	/*
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>实例化指定类型的对象
	 * 
	 * @param clz
	 * @return
	 * @author LeonLee
	 * @date 2017年6月16日 下午3:40:11 
	 * *******************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	private static Object instanceObject(Class clz) {
		try {
			return clz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(ExInfoConstant.CAN_NOT_INSTANCE, e);
		}
	}
	
	/*
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>移除缓存中的CACHE_MAX/2-1个最早缓存的对象
	 * 
	 * @author LeonLee
	 * @date 2017年6月16日 下午3:40:52 
	 * *******************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	private static void removeCacheEle() {
		Set<Entry<Class, Object>> entrySet = cache.entrySet();
		Iterator<Entry<Class, Object>> it = entrySet.iterator();
		int index = 0;
		while (it.hasNext()) {
			it.next();
			if (index > CACHE_MAX / 2) {
				break;
			}
			it.remove();
			index++;
		}
	}
	
}
