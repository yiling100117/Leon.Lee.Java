package leon.lee.utlis.log;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4JUtils {
	
	private static Logger		objLog;
	
	private static final String	INFO	= "INFO";
	private static final String	TRACE	= "TRACE";
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
	 * 输出等级为info的日志文件
	 *
	 * @param message
	 * @param exception
	 * @author ly
	 * @date 2017年5月5日 下午12:01:13
	 */
	public static void info(String message, Exception exception) {
		try {
			log(INFO, message, exception);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为info的日志文件
	 *
	 * @param message
	 * @author ly
	 * @date 2017年5月5日 下午12:01:13
	 */
	public static void info(Object message) {
		try {
			log(INFO, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为trace的日志文件
	 *
	 * @param message
	 * @author ly
	 * @date 2017年5月5日 下午12:01:13
	 */
	public static void trace(String message) {
		try {
			log(TRACE, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为trace的日志文件
	 *
	 * @param message
	 * @param exception
	 * @author ly
	 * @date 2017年5月5日 下午12:01:13
	 */
	public static void trace(String message, Exception exception) {
		try {
			log(TRACE, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为error的日志文件
	 *
	 * @param message
	 * @param exception
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void error(String message, Exception exception) {
		try {
			log(ERROR, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为error的日志文件
	 *
	 * @param message
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void error(String message) {
		try {
			log(ERROR, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为warning的日志文件
	 *
	 * @param message
	 * @param exception
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void warning(String message, Exception exception) {
		try {
			log(WARN, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为warning的日志文件
	 *
	 * @param message
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void warning(String message) {
		try {
			log(WARN, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为debug的日志文件
	 *
	 * @param message
	 * @param exception
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void debug(String message, Exception exception) {
		try {
			log(DEBUG, message, exception);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出等级为debug的日志文件
	 *
	 * @param message
	 * @author ly
	 * @date 2017年5月5日 下午4:35:16
	 */
	public static void debug(String message) {
		try {
			log(DEBUG, message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 输出指定等级不带异常信息的日志文件
	 *
	 * @param level
	 * @param msg
	 * @author ly
	 * @date 2017年5月5日 下午4:43:44
	 */
	public static void log(String level, Object msg) {
		log(level, msg, null);
	}
	
	/**
	 * 输出指定等级带异常信息的日志文件
	 *
	 * @param level
	 * @param e
	 * @author ly
	 * @date 2017年5月5日 下午4:43:57
	 */
	public static void log(String level, Throwable e) {
		log(level, null, e);
	}
	
	/**
	 * 输出指定等级带和异常信息的日志文件
	 *
	 * @param level
	 * @param msg
	 * @param e
	 * @author ly
	 * @date 2017年5月5日 下午4:56:37
	 */
	public static void log(String level, Object msg, Throwable e) {
		if (INFO.equals(level) || TRACE.equals(level) || ERROR.equals(level) || WARN.equals(level) || DEBUG.equals(level)) {
			try {
				StringBuilder sb = new StringBuilder();
				Throwable t = new Throwable();
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
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
				leon.lee.utlis.log.Log4JUtils.info(ex.getLocalizedMessage());
			}
		} else {
			throw new RuntimeException("日志输出类型有误");
		}
	}
}
