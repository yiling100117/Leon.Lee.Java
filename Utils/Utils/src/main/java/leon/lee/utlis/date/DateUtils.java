package leon.lee.utlis.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private DateUtils() {
		
	}
	
	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	public static final String	DATE_NO_SYMBOL			= "yyyyMMddHHmmss";
	
	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	public static final String	DATE_DEFAULT			= "yyyy-MM-dd HH:mm:ss";
	
	/** 年月日(无下划线) yyyyMMdd */
	public static final String	DATE_SHORT_NO_SYMBOL	= "yyyyMMdd";
	
	/**
	 * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
	 *
	 * @return
	 * @author ly
	 * @date 2017年4月20日 上午11:55:42
	 */
	public static String getNewDateWithoutSymbol() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(DATE_NO_SYMBOL);
		return df.format(date);
	}
	
	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 * @author ly
	 * @date 2017年4月20日 上午11:55:34
	 */
	public static String getNewDefaultDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(DATE_DEFAULT);
		return df.format(date);
	}
	
	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 *
	 * @return
	 * @author ly
	 * @date 2017年4月20日 上午11:55:07
	 */
	public static String getNewShortDateWithoutSymbol() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(DATE_SHORT_NO_SYMBOL);
		return df.format(date);
	}
}
