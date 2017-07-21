package leon.special.thread;

/**
 * **************************************
 * <p>该类用于输出方法调用信息，默认信息格式为："类:["+clzName+"]--方法:["+methName+"]--行号:("+lineNumber+")"
 * 
 * <p>也可以使用其他在模板类<code>({@link InfoTemplate InfoTemplate})</code>中定义的模板
 * 
 * <p>关于获取堆栈信息的下标<code>(Thread.currentThread().getStackTrace()[stackIndex])中的stackIndex</code>:
 * 		<pre>0---类:[java.lang.Thread]--方法:[getStackTrace]</pre>
 * 		<pre>1---类:[调用输出信息方法的方法所在的类]--方法:[调用输出信息方法的方法]</pre>
 * 		<pre>2---类:[调用输出信息方法的方法的方法所在的类]--方法:[调用输出信息方法的方法的方法]</pre>
 * 		<pre>以此类推：为1时输出的是调用输出信息方法的方法信息，下标每加1就输出调用上级</pre>
 * 
 * @author LeonLee
 * @date 2017年6月13日 上午9:40:17 
 ***************************************
 */
public class ThreadUtils {
	
	private ThreadUtils() {}
	
	/**
	 * **************************************
	 * <p>KW:默认模板，输出方法信息
	 *
	 * <p>使用默认模板输出调用方法的信息
	 * 
	 * @param stackTraceEle
	 * @return
	 * @author LeonLee
	 * @date 2017年6月13日 上午9:44:11 
	 ***************************************
	 */
	public static void printCalledInfo(StackTraceElement stackTraceEle) {
		InfoTemplate.BASE_TEMPLATE.getResult(stackTraceEle);
	}
	
	/**
	 * **************************************
	 * <p>KW:输出方法信息，指定模板
	 *
	 * <p>使用指定模板输出调用方法的信息
	 * 
	 * @param stackTraceEle
	 * @param template 模板只能是<code>({@link InfoTemplate})</code>的实例
	 * @return
	 * @author LeonLee
	 * @date 2017年6月13日 上午9:45:25 
	 ***************************************
	 */
	public static void printCalledInfo(StackTraceElement stackTraceEle, InfoTemplate template) {
		template.getResult(stackTraceEle);
	}
	
}
