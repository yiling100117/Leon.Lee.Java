package leon.special.log;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import leon.base.constant.ExInfoConstant;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 ********************************************************************************
 * 
 * <p>有关日志输出的类
 *
 * @author LeonLee
 * @date 2017年5月16日 下午6:03:50 
 *
 ********************************************************************************
 *
 */
public class Log4JUtils {
	
	private static Logger objLog;
	
	/*
	 * 以下是四种日志输出等级
	 */
	private static final String	INFO	= "INFO";
	private static final String	ERROR	= "ERROR";
	private static final String	WARN	= "WARN";
	private static final String	DEBUG	= "DEBUG";
	
	private static Logger getLogger() {
		if (objLog == null) {
			objLog = LogManager.getLogger(Log4JUtils.class);
		}
		return objLog;
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:info,两参,信息,异常
	 *
	 * <p>输出等级为info的日志文件
	 * 
	 * @param message 输出信息
	 * @param exception 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:04:10 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void info(Object message, Exception exception) {
		try {
			log(INFO, message, exception);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:info,一参,信息
	 *
	 * <p>输出等级为info的日志文件
	 * 
	 * @param message 输出信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:05:13 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void info(Object message) {
		try {
			log(INFO, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:error,两参,信息,异常
	 *
	 * <p>输出等级为error的日志文件
	 * 
	 * @param message 输出信息
	 * @param exception 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:05:54 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void error(Object message, Exception exception) {
		try {
			log(ERROR, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:error,一参,信息
	 *
	 * <p>输出等级为error的日志文件
	 * 
	 * @param message 输出信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:06:25 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void error(Object message) {
		try {
			log(ERROR, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:warning,两参,信息,异常
	 *
	 * <p>输出等级为warning的日志文件
	 * 
	 * @param message 输出信息
	 * @param exception 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:06:42 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void warning(Object message, Exception exception) {
		try {
			log(WARN, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:warning,一参,信息
	 *
	 * <p>输出等级为warning的日志文件
	 * 
	 * @param message 输出信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:06:56 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void warning(Object message) {
		try {
			log(WARN, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:debug,两参,信息,异常
	 *
	 * <p>输出等级为debug的日志文件
	 * 
	 * @param message 输出信息
	 * @param exception 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:07:10 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void debug(Object message, Exception exception) {
		try {
			log(DEBUG, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:debug,一参,信息
	 *
	 * <p>输出等级为debug的日志文件
	 * 
	 * @param message 输出信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:07:24 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void debug(Object message) {
		try {
			log(DEBUG, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:指定等级,信息
	 *
	 * <p>输出指定等级不带异常信息的日志文件
	 * 
	 * @param level 日志输出等级
	 * @param msg 输出信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:07:38 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void log(String level, Object msg) {
		log(level, msg, null);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:指定等级,异常
	 *
	 * <p>输出指定等级带异常信息的日志文件
	 * 
	 * @param level 日志输出等级
	 * @param e 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:08:20 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void log(String level, Throwable e) {
		log(level, null, e);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:指定等级,信息,异常
	 *
	 * <p>输出指定等级带和异常信息的日志文件
	 * 
	 * @param level 日志输出等级
	 * @param msg 输出信息
	 * @param e 打印异常信息
	 * @author LeonLee
	 * @date 2017年5月16日 下午6:08:44 
	 * 
	 ********************************************************************************
	 *
	 */
	public static void log(String level, Object msg, Throwable e) {
		if (INFO.equals(level) || ERROR.equals(level) || WARN.equals(level) || DEBUG.equals(level)) {
			try {
				StringBuilder sb = new StringBuilder();
				Throwable t = new Throwable();
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);//向文本输出流打印对象的格式化表示形式
				t.printStackTrace(pw);
				String input = sw.getBuffer().toString();
				StringReader sr = new StringReader(input);
				BufferedReader br = new BufferedReader(sr);
				for (int i = 0; i < 4; i++) {
					br.readLine();
				}
				String line = br.readLine();
				int paren = line.indexOf("at ");
				line = line.substring(paren + 3);
				paren = line.indexOf('(');
				String invokeInfo = line.substring(0, paren);
				int period = invokeInfo.lastIndexOf('.');
				sb.append('[');
				sb.append(invokeInfo.substring(0, period));
				sb.append(':');
				sb.append(invokeInfo.substring(period + 1));
				sb.append("():");
				paren = line.indexOf(':');
				period = line.lastIndexOf(')');
				sb.append(line.substring(paren + 1, period));
				sb.append(']');
				sb.append(" - ");
				sb.append(msg);
				getLogger().log(Level.toLevel(level), sb.toString(), e);
			} catch (Exception ex) {
				leon.special.log.Log4JUtils.info(ex.getLocalizedMessage());
			}
		} else {
			throw new RuntimeException(ExInfoConstant.LOG_EXPORT_ERROE);
		}
	}
}
