package leon.lee.utlis.log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import leon.lee.utlis.config.ReadConfig;
import leon.lee.utlis.constant_quantity.CommonsString;

/**
 * <p>用来输出日志的类
 * 
 * <p>该类默认读取"src/config.properties"中的"filePath"属性来获取日志输出路径
 * 
 * <p>若"src/config.properties"配置文件不存在，则将日志输出至"src/log_yyyy_MM_dd.txt"文件中
 * 
 * @author ly
 * @date 2017年4月19日 下午3:23:10
 */
public enum LogUtils {
	
	LOGUTILS;
	
	private LogUtils() {
		ReadConfig rc = null;
		try {
			rc = ReadConfig.getInstance(DEFAULT_PROPERTIES_PATH);
			String path = rc.getProperty(DEFAULT_FILE_NAME);
			this.logPath = processPath(path);
		} catch (IOException e) {
			logPath = DEFAULT_LOG_PATH;
		}
	}
	
	private static final String	DEFAULT_PROPERTIES_PATH	= "src/config.properties";
	private static final String	DEFAULT_LOG_PATH		= "src/";
	private static final String	DEFAULT_FILE_NAME		= "filePath";
	private String				logPath;
	
	/**
	 * 按天输出日志文件
	 *
	 * @param pushWord
	 * @author ly
	 * @date 2017年4月19日 下午7:09:26
	 */
	public void logPushDay(String pushWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(logPath + "log_"
					+ new SimpleDateFormat(CommonsString.DEFAULT_DATE_FROMAT_TXT_NAME).format(new Date()) + ".txt", true);
			writer.write(pushPrefix(pushWord));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String pushPrefix(String pushWord) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String className = stackTrace[2].getClassName();
		String methodName = stackTrace[2].getMethodName();
		int lineNumber = stackTrace[2].getLineNumber();
		return new SimpleDateFormat(CommonsString.DEFAULT_DATE_FROMAT).format(new Date()) + " : [" + className + "--" + methodName
				+ " : " + lineNumber + "] " + pushWord + "\r\n";
	}
	
	private String processPath(String path) {
		return path.endsWith("/") || path.endsWith("\\") ? path : path + "\\";
	}
}
