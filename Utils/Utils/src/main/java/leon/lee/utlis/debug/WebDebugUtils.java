package leon.lee.utlis.debug;


public class WebDebugUtils {
	
	private WebDebugUtils(){
		
	}
	
	/**
	 * <p>控制台输出session中的Attribute的名和值
	 * 
	 * @param request
	 *
	 * @author LeonLee
	 * @date 2017年2月23日 下午1:53:44
	 */
	/*public static void printSessionAttribute(HttpServletRequest request){
		HttpSession session = request.getSession();
		Enumeration<?> enumeration = session.getAttributeNames();
		System.out.println("------------------------------");
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement().toString();  
		    Object value = session.getAttribute(name);  
		    System.out.println(name + ":" + value);  
		}
		System.out.println("------------------------------");
	}*/
	
	/**
	 * <p>控制台输出request中的Parameter的名和值
	 * 
	 * @param request
	 *
	 * @author ly
	 * @date 2017年2月23日 下午2:10:18
	 */
	/*public static void printRequestParameter(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();  
	    Enumeration<String> paramNames = request.getParameterNames();  
	    while (paramNames.hasMoreElements()) {  
	        String paramName = (String) paramNames.nextElement();  
	        String[] paramValues = request.getParameterValues(paramName);  
	        if (paramValues.length == 1) {  
	            String paramValue = paramValues[0];  
	            if (paramValue.length() != 0) {  
	                map.put(paramName, paramValue);  
	            }  
	        }  
	    }  
	    Set<Map.Entry<String, String>> set = map.entrySet();  
	    System.out.println("------------------------------");  
	    for (Map.Entry<String, String> entry : set) {  
	        System.out.println(entry.getKey() + ":" + entry.getValue());  
	    }  
	    System.out.println("------------------------------"); 
	}*/
	
}
