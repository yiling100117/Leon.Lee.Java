package leon.dungeons.base.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 有关MD5加密的类
 * 
 * 需要引入"Apache Commons Codec"的jar包
 * 
 * @author ly
 * @date 2017年4月20日 上午10:43:10
 */
public class MD5Utils {
	
	private MD5Utils() {
		
	}
	
	/**
	 * <p>将一个字符串进行MD5加密，需要提供"盐" 
	 * 
	 * <p>"盐"将用来配合字符串加密，同一字符串使用不同的"盐"得到的结果不同
	 *
	 * @param text 需要加密的字符串
	 * @param salt 盐
	 * @param input_charset 编码格式，如果编码格式为null，则默认使用"ISO-8859-1"
	 * @return 加密后的字符串(32位)
	 * @author ly
	 * @date 2017年4月20日 上午10:29:43
	 */
	public static String sign(String text, String salt, String input_charset) {
		return DigestUtils.md5Hex(getContentBytes(text + salt, input_charset));
	}
	
	/**
	 * <p>判断加密后的字符串sign未加密前是否为text
	 * 
	 * <p>注意传入的"盐"必须和加密sign时"盐"一直否则判断为不同
	 *
	 * @param text 需要加密的字符串
	 * @param sign 加密后的字符串
	 * @param salt 盐
	 * @param input_charset 编码格式，如果编码格式为null，则默认使用"ISO-8859-1"
	 * @return sign是text加密后的状态返回true，否则返回false
	 * @author ly
	 * @date 2017年4月20日 上午10:30:38
	 */
	public static boolean verify(String text, String sign, String salt, String input_charset) {
		if (sign(text, salt, input_charset).equals(sign)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5加密过程中出现错误,指定的编码集(" + charset + ")为找到");
		}
	}
}
