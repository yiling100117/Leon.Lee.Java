package leon.base.constant;

import java.lang.reflect.Method;

import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

/**
 * 
 ********************************************************************************
 *
 * <p>用来定义所有有关异常信息的类
 * 
 * <p>所有的异常抛出信息都应该从该类中获取，不应该用字面量定义
 * 
 * @author LeonLee
 * @date 2017年5月16日 下午5:05:17 
 * 
 ********************************************************************************
 *
 */
public class ExInfoConstant {
	
	private ExInfoConstant() {}
	
	/**
	 * 参数非法，用于各种参数传递错误，例如类型错误，格式错误，但不包括参数为空
	 */
	public static final String ILLEGAL_ARG_INFO = "参数非法";
	
	/**
	 * 传入参数为空，通常这个空对于字符串、数组等特殊对象有不同的含义，
	 * 需要具体定义不是仅仅代表参数为<code>(NULL)</code>
	 */
	public static final String ARG_NON_NULL_INFO = "参数不能为空(Null)";
	
	/**
	 * 表示使用日志输出类时，传入了INFO、ERRO、WARN、DEBUG以外的非法参数，
	 * 是<code>{@link #ILLEGAL_ARG_INFO}</code>的一种
	 */
	public static final String LOG_EXPORT_ERROE = "日志输出类型有误";
	
	/**
	 * 表示测试调用类出现异常，通常是由于<code>{@link Method #invoke(Object, Object...)}
	 * 或{@link Class #getDeclaredMethod(String, Class...)}</code>方法抛出异常
	 */
	public static final String TEST_UTILS_PRNRESULT_DEBUG = "测试调用工具类反射调用出现异常";
	
	/**
	 * 表示在一个没有使用<code>({@link TestClz})</code>注解的类中
	 * 调用测试工具方法<code>({@link TstResultPrnUtils #prnResult(Class, Object[], int, Class[])})</code>
	 * 或其重载方法
	 */
	public static final String NON_IS_TEST_CLASS = "调用测试方法的类不是一个测试类";
	
	/**
	 * 表示对象实例化失败，一般用在工厂方法中
	 */
	public static final String CAN_NOT_INSTANCE = "实例化失败";
	
}
