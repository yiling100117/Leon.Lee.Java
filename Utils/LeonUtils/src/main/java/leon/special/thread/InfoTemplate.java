package leon.special.thread;

/**
 * **************************************
 * <p>输出方法调用信息的模板
 * 
 * @author LeonLee
 * @date 2017年6月13日 上午9:39:35 
 ***************************************
 */
public enum InfoTemplate {
	/**
	 * 默认的模板
	 * "类:["+clzName+"]--方法:["+methName+"]--行号:("+lineNumber+")"
	 */
	BASE_TEMPLATE {
		
		void getResult(StackTraceElement stackTraceEle) {
			System.out.println("类:[" + stackTraceEle.getClassName() + "]--方法:["
					+ stackTraceEle.getMethodName() + "]--行号:(" + stackTraceEle.getLineNumber() + ")");
		}
	};
	
	abstract void getResult(StackTraceElement stackTraceEle);
}
