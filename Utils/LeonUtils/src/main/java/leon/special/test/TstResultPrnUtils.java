package leon.special.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import leon.base.constant.ExInfoConstant;
import leon.base.utils.BaseUtils;
import leon.base.utils.array.ArrayUtils;
import leon.special.log.Log4JUtils;
import leon.special.thread.ThreadUtils;

public class TstResultPrnUtils {
	
	/*
	 * 这是一个方法名，每个测试类内都应该有以这个名字命名的方法，并在这个方法内调用待测方法
	 * 具体示例如下
	 * eg:
	 * private String testMeth(String str, String bgStr, String endStr) {//私有方法 返回值与待测方法一致 方法名必须问TEST_METH_FIELD_NAME的值
	 * 		return StringUtils.getSubstring(str, bgStr, endStr);//待测试方法
	 * }
	 */
	private static final String	DEFAULT_TEST_METH_FIELD_NAME	= "testMeth";
	private static String		testMethFieldName;
	
	/**
	 * <p>输出有关线程、类名、方法名的信息有关的下标
	 * 
	 * <p><code>({@link Thread #currentThread()})</code>  <code>({@link Thread #getStackTrace()})</code>
	 * 
	 * <p>Thread.currentThread().getStackTrace()[stackIndex]
	 */
	private static final int DEF_STACKINDEX = 4;
	
	private TstResultPrnUtils() {}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:测试工具类、参数非null
	 *
	 * <p>用于测试有参数值，且参数不为<code>(null)</code>情况下的方法
	 * 
	 * <p>内联调用了{@link #prnResult(Class clz, Object[] arg, Class[] clzs)}
	 * 
	 * @param clz 测试类的类型
	 * @param arg 测试方法的参数
	 * @author LeonLee
	 * @date 2017年5月20日 上午10:07:58 
	 * 
	 ********************************************************************************
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static void prnResult(Class clz, Object[] arg) {
		prnResult(clz, arg, DEF_STACKINDEX);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:测试工具类、指定参数类型
	 *
	 * <p>用于测试有参数值，参数可以为<code>(null)</code>，但是必须指定参数类型<code>clzs</code>
	 * 
	 * <p>内联调用了{@link #prnResult(Class clz, Object[] arg, int stackIndex, Class[] clzs) }
	 * 
	 * @param clz 测试类的类型
	 * @param arg 测试方法的参数
	 * @param clzs 测试方法的参数类型
	 * @author LeonLee
	 * @date 2017年5月20日 上午10:11:02 
	 * 
	 ********************************************************************************
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static void prnResult(Class clz, Object[] arg, Class[] clzs) {
		prnResult(clz, arg, DEF_STACKINDEX, clzs);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:测试工具类、指定参数、指定{@link #DEF_STACKINDEX}下标
	 *
	 * <p>用于测试有参数值，参数不为<code>(null)</code>
	 * 
	 * <p>内联调用了{@link #prnResult(Class clz, Object[] arg, int stackIndex, Class[] clzs) }
	 * 
	 * @param clz 测试类的类型
	 * @param arg 测试方法的参数
	 * @param stackIndex 输出线程信息的下标
	 * @author LeonLee
	 * @date 2017年5月20日 上午10:14:10 
	 * 
	 ********************************************************************************
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static void prnResult(Class clz, Object[] arg, int stackIndex) {
		Class[] argClzs = new Class[arg.length];
		for (int i = 0; i < argClzs.length; i++) {
			if (arg[i] == null) {
				throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
			}
			argClzs[i] = arg[i].getClass();
		}
		prnResult(clz, arg, DEF_STACKINDEX, argClzs);
	}
	
	/**
	 ******************************************************************************
	 * <p>KW:测试工具类、指定参数、指定{@link #DEF_STACKINDEX}下标、指定参数类型
	 *
	 * <p>用于测试有参数值，参数可以为<code>(null)</code>，但是必须指定参数类型<code>clzs</code>
	 * 
	 * @param clz 测试类的类型
	 * @param arg 测试方法的参数
	 * @param stackIndex 输出线程信息的下标
	 * @param clzs 测试方法的参数类型
	 * @author LeonLee
	 * @date 2017年6月13日 上午10:45:21 
	 ******************************************************************************
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void prnResult(Class clz, Object[] arg, int stackIndex, Class[] clzs) {
		System.out.println();
		ThreadUtils.printCalledInfo(Thread.currentThread().getStackTrace()[stackIndex]);
		try {
			hasAnnotation(clz);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return;
		}
		Field[] fields = clz.getDeclaredFields();
		Object result = null;
		try {
			prnArgInfo(arg, fields);
			Class[] argClzs = new Class[arg.length];
			for (int i = 0; i < clzs.length; i++) {
				argClzs[i] = clzs[i];
			}
			Method method = clz.getDeclaredMethod(testMethFieldName, clzs);
			method.setAccessible(true);//抑制Java的访问控制检查
			result = method.invoke(clz.newInstance(), arg);
			prnResult(result, method.getReturnType());
		} catch (Exception e) {
			Log4JUtils.debug(ExInfoConstant.TEST_UTILS_PRNRESULT_DEBUG, e);
		}
	}
	
	/*
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>用来输出方法运行结果(返回值)
	 * 
	 * @param result
	 * @param method
	 * @author LeonLee
	 * @date 2017年6月13日 下午2:55:37 
	 * *******************************************************************************
	 */
	private static void prnResult(Object result, Class<?> returnType) {
		if ("void".equals(returnType.toString())) {//此处应该优化
			System.out.println("该方法为无返回值(void)方法");
			System.out.println();
		} else if (returnType.isArray()) {
			ArrayUtils.prnArray((Object[]) result);
		} else {
			System.out.println("result	:	" + result);
			System.out.println();
		}
	}
	
	/*
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>用来输出参数
	 * 
	 * @param arg
	 * @param fields
	 * @author LeonLee
	 * @date 2017年6月13日 下午2:53:59 
	 * *******************************************************************************
	 */
	private static void prnArgInfo(Object[] arg, Field[] fields) {
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String fieldName = fields[i].getName();
			System.out.print("参数:		" + fieldName + "		:		");
			if (fields[i].getType().isArray()) {
				ArrayUtils.prnArray((Object[]) arg[i]);
			} else {
				System.out.println(arg[i]);
			}
		}
	}
	
	/*
	 ******************************************************************************
	 * <p>KW:
	 *
	 * <p>用来判断传入的类是否有<code>(TestClz)</code>注解
	 * 
	 * <p>若有则把注解的值赋给<code>(testMethFieldName)</code>
	 * 
	 * <p>否则把默认值<code>(DEFAULT_TEST_METH_FIELD_NAME)</code>赋给<code>(testMethFieldName)</code>
	 * 
	 * @param clz
	 * @author LeonLee
	 * @date 2017年6月13日 下午2:39:12 
	 ******************************************************************************
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void hasAnnotation(Class clz) {
		if (clz.isAnnotationPresent(TestClz.class)) {
			TestClz annotation = (TestClz) clz.getAnnotation(TestClz.class);
			testMethFieldName = annotation.value().trim();
			if (BaseUtils.isEmpty(testMethFieldName)) {
				testMethFieldName = DEFAULT_TEST_METH_FIELD_NAME;
			}
		} else {
			throw new RuntimeException(ExInfoConstant.NON_IS_TEST_CLASS);
		}
	}
	
}
