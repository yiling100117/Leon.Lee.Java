package leon.lee.utlis.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtils {
	
	public StreamUtils() {
		
	}
	
	/**
	 * 用来关闭{@link InputStream}流，会处理{@link IOException}异常
	 *
	 * @param inputStream
	 * @author ly
	 * @date 2017年4月24日 上午10:32:27
	 */
	public static void closeInputStream(InputStream inputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
				inputStream = null;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				inputStream = null;
			}
		}
	}
	
	/**
	 * 用来关闭{@link OutputStream}流，会处理{@link IOException}异常
	 * 
	 * @param outputStream
	 * @author ly
	 * @date 2017年4月24日 上午10:35:07
	 */
	public static void closeOutputStream(OutputStream outputStream) {
		if (outputStream != null) {
			try {
				outputStream.close();
				outputStream = null;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				outputStream = null;
			}
		}
	}
}
