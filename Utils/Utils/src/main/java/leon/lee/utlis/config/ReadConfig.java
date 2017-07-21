package leon.lee.utlis.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import leon.lee.utlis.JudgeUtils;

/**
 * <p>读取配置文件，使用getProperty方法获取配置文件中的信息
 * 
 * @author ly
 * @date 2017年2月24日 上午8:56:34
 */
public class ReadConfig {
	
	/**
	 * <p>私有构造器，在构造对象时加载配置文件
	 * 
	 * <p>配置文件路径为默认路径"src/config.properties"
	 *
	 * @author ly
	 * @throws IOException 当前路径下没有指定配置文件或文件读取出错会抛出的异常
	 * @date 2017年2月24日 上午8:57:41
	 */
	private ReadConfig() throws IOException {
		InputStream in = new FileInputStream(DEFAULT_PATH + DEFAULT_FILE_NAME);
		prop = new Properties();
		prop.load(in);
	}
	
	/**
	 * <p>私有构造器，在构造对象时加载配置文件
	 * 
	 * <p>配置文件路径为默认路径为参数
	 *
	 * @author ly
	 * @throws IOException 当前路径下没有指定配置文件或文件读取出错会抛出的异常
	 * @date 2017年4月19日 下午7:17:33
	 */
	private ReadConfig(String path) throws IOException {
		InputStream in = new FileInputStream(path);
		prop = new Properties();
		prop.load(in);
	}
	
	private static Properties	prop;
	private static final String	DEFAULT_PATH		= "src/";
	private static final String	DEFAULT_FILE_NAME	= "config.properties";
	
	/**
	 * <p>获取ReadConfig的对象
	 * 
	 * @return ReadConfig实例
	 *
	 * @author ly
	 * @throws IOException 
	 * @date 2017年2月24日 上午8:55:54
	 */
	public static ReadConfig getInstance(String filePath) throws IOException {
		return SingletonClassInstance.getReadConfig(filePath);
	}
	
	public static ReadConfig getInstance() throws IOException {
		return SingletonClassInstance.getReadConfig(null);
	}
	
	public String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}
	
	private static class SingletonClassInstance {
		
		//private static final ReadConfig	SINGLETON = new ReadConfig();
		private static ReadConfig getReadConfig(String filePath) throws IOException {
			ReadConfig rc = null;
			if (!JudgeUtils.isEmpty(filePath)) {
				rc = new ReadConfig(filePath);
			} else {
				rc = new ReadConfig();
			}
			return rc;
		}
	}
}
