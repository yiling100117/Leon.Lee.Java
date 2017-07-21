package leon.lee.utlis.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public class BrowserUtils {
	
	private BrowserUtils() {
		
	}
	
	private final static String IE11 = "rv:11.0";
	private final static String IE10 = "MSIE 10.0";
	private final static String IE9 = "MSIE 9.0";
	private final static String IE8 = "MSIE 8.0";
	private final static String IE7 = "MSIE 7.0";
	private final static String IE6 = "MSIE 6.0";
	private final static String MAXTHON = "Maxthon";
	private final static String QQ = "QQBrowser";
	private final static String GREEN = "GreenBrowser";
	private final static String SE360 = "360SE";
	private final static String FIREFOX = "Firefox";
	private final static String OPERA = "Opera";
	private final static String CHROME = "Chrome";
	private final static String SAFARI = "Safari";
	private final static String OTHER = "其它";
	
	/**
	 * 判断发送请求的浏览器是否为IE
	 *
	 * @param request
	 * @return
	 * @author ly
	 * @date 2017年4月22日 上午11:19:20
	 */
	/*public static boolean isIE(HttpServletRequest request) {
		return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase()
				.indexOf("rv:11.0") > 0) ? true : false;
	}*/
	
	/**
	 * 判断发送请求的浏览器版本是否为指定的版本
	 *
	 * @param request
	 * @param brosertype
	 * @return
	 * @author ly
	 * @date 2017年4月22日 上午11:22:29
	 */
	/*private static boolean isBrowserType(HttpServletRequest request, String brosertype) {
		return request.getHeader("USER-AGENT").toLowerCase().indexOf(brosertype) > 0 ? true : false;
	}*/
	
	/**
	 * 获取发送请求的浏览器版本
	 *
	 * @param request
	 * @return
	 * @author ly
	 * @date 2017年4月22日 上午11:23:36
	 */
	/*public static Double getIEVersion(HttpServletRequest request) {
		Double version = 0.0;
		if (isBrowserType(request, IE11)) {
			version = 11.0;
		} else if (isBrowserType(request, IE10)) {
			version = 10.0;
		} else if (isBrowserType(request, IE9)) {
			version = 9.0;
		} else if (isBrowserType(request, IE8)) {
			version = 8.0;
		} else if (isBrowserType(request, IE7)) {
			version = 7.0;
		} else if (isBrowserType(request, IE6)) {
			version = 6.0;
		}
		return version;
	}*/
	
	/**
	 * 判断发送请求的是什么浏览器
	 *
	 * @param request
	 * @return
	 * @author ly
	 * @date 2017年4月22日 上午11:27:21
	 */
	/*public static String checkBrowse(HttpServletRequest request) {
		String userAgent = request.getHeader("USER-AGENT");
		if (regex(OPERA, userAgent))
			return OPERA;
		if (regex(CHROME, userAgent))
			return CHROME;
		if (regex(FIREFOX, userAgent))
			return FIREFOX;
		if (regex(SAFARI, userAgent))
			return SAFARI;
		if (regex(SE360, userAgent))
			return SE360;
		if (regex(GREEN, userAgent))
			return GREEN;
		if (regex(QQ, userAgent))
			return QQ;
		if (regex(MAXTHON, userAgent))
			return MAXTHON;
		if (regex(IE11, userAgent))
			return IE11;
		if (regex(IE10, userAgent))
			return IE10;
		if (regex(IE9, userAgent))
			return IE9;
		if (regex(IE8, userAgent))
			return IE8;
		if (regex(IE7, userAgent))
			return IE7;
		if (regex(IE6, userAgent))
			return IE6;
		return OTHER;
	}*/
	
	private static boolean regex(String regex, String str) {
		Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher m = p.matcher(str);
		return m.find();
	}

	public enum BrowserType {
		IE11, IE10, IE9, IE8, IE7, IE6, Firefox, Safari, Chrome, Opera, Camino, Gecko
	}
}
