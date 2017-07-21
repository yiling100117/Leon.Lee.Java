package leon.lee.utlis.string;

import java.util.UUID;

import leon.lee.exception.HintException;
import leon.lee.utlis.JudgeUtils;
import leon.lee.utlis.log.Log4JUtils;

/**
 * <p>字符串工具类
 * 
 * @author ly
 * @date 2017年3月4日 上午10:51:09
 */
public class StringUtils {
	
	private StringUtils() {
		
	}
	
	/**
	 * 1
	 * 
	 * <p>生成一个随机的UUID字符串，并去除了中间的"-"，长度为32
	 * 
	 * @return UUID字符串
	 */
	public static String getUUID32() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * <p>判断字符串(str)中是否包含特定数组(arr)中的某个元素
	 * 
	 * <p>检测到第一个包含时就会停止检测，无法判断是否包含多个
	 * 
	 * <p>任一参数为null则返回null
	 * 
	 * @param str 待检测字符串
	 * @param arr 特定数组
	 * @return 检测包含元素就返回这个元素，否则返回null(不是字符串"null")
	 */
	public static String includeOneOfArray(String str, String[] arr) {
		String result = null;
		if (arr != null && str != null) {
			int min = str.length();
			for (int i = 0, length = arr.length; i < length; i++) {
				int index = str.indexOf(arr[i]);
				if (index > -1 && index < min) {
					min = index;
					result = arr[i];
				}
			}
			result = min == str.length() ? null : result;
		}
		return result;
	}
	
	/**
	 * <p>从指定字符串(oldString)中截去从特定字符串(begin)开始到oldString末尾，
	 * 
	 * <p>若begin为空字符串则从oldString开始截去到oldString末尾即返回空字符串
	 * 
	 * <p>两个参数任一为null则返回原字符串
	 *
	 * @param oldString 指定字符串
	 * @param begin 开始截去的字符串，这部分也会被截去
	 * @return 截去后剩余的部分
	 * @throws HintException
	 * @author ly
	 * @date 2017年3月3日 上午10:25:52
	 */
	public static String cutOutBetweenString(String oldString, String begin) {
		return cutOutBetweenString(oldString, begin, "");
	}
	
	/**
	 * <p>从指定字符串(oldString)中截去一部分字符串，需要给出截去部分的开头(begin)和结尾字符串(end)，begin匹配第一个，end匹配最后一个，
	 * 
	 * <p>若begin为空字符串则从oldString开头开始截去，
	 * 
	 * <p>若end为空字符串则从begin截去到末尾，
	 * 
	 * <p>若begin,end都为空，就从头到尾截去，即返回空字符串
	 * 
	 * <p>三个参数任一为null则返回oldString
	 *
	 * @param oldString 指定字符串
	 * @param begin 开头，多个开头匹配第一个
	 * @param end 结尾，多个结尾匹配最后一个
	 * @return
	 * @author ly
	 * @date 2017年3月3日 上午10:28:17
	 */
	public static String cutOutBetweenString(String oldString, String begin, String end) {
		if (oldString != null && begin != null && end != null) {
			int beginIndex = oldString.indexOf(begin);
			int endIndex = oldString.lastIndexOf(end);
			if (beginIndex > -1 && endIndex > -1) {
				oldString = oldString.substring(0, beginIndex) + oldString.substring(endIndex + end.length());
			}
		}
		return oldString;
	}
	
	/**
	 * <p>从指定字符串(oldString)中截去一部分字符串，需要给出截去部分的开头(begin)的结尾字符串(end)，begin匹配第一个，end匹配开头后第一个，
	 * 
	 * <p>若begin为空字符串则从oldString开头开始截取，
	 * 
	 * <p>若end为空字符串则截去begin，
	 * 
	 * <p>若begin,end都为空，就返回原字符串
	 * 
	 * <p>三个参数任一为null则返回oldString
	 *
	 * @param oldString
	 * @param begin
	 * @param end
	 * @return
	 * @author ly
	 * @date 2017年3月6日 上午10:02:57
	 */
	public static String cutOutBetweenStringNext(String oldString, String begin, String end) {
		if (oldString != null && begin != null && end != null) {
			int beginIndex = oldString.indexOf(begin);
			int endIndex = oldString.indexOf(end);
			if (beginIndex > -1 && endIndex > -1) {
				int len = beginIndex + begin.length();
				while (endIndex < len) {
					endIndex = oldString.substring(endIndex + 1).indexOf(end) + oldString.substring(0, endIndex + 1).length();
				}
				oldString = oldString.substring(0, beginIndex) + oldString.substring(endIndex + end.length());
			}
		}
		return oldString;
	}
	
	/**
	 * <p>从oldString中截取一部分字符串，需要给出截取部分的开头(begin)和结尾字符串(end)，begin匹配第一个，end匹配开头后第一个
	 * 
	 * <p>包含begin
	 * 
	 * <p>若begin为空字符串则从oldString开头开始截取，到end
	 * 
	 * <p>若end为空字符串则截取begin，
	 * 
	 * <p>若begin,end都为空，就返回空字符串
	 * 
	 * <p>三个参数任一为null则返回oldString
	 *
	 * @param oldString
	 * @param begin
	 * @param end
	 * @return
	 * @author ly
	 * @date 2017年3月6日 上午10:02:57
	 */
	public static String cutBetweenStringNext(String oldString, String begin, String end) {
		if (oldString != null && begin != null && end != null) {
			int beginIndex = oldString.indexOf(begin);
			int endIndex = oldString.indexOf(end);
			;
			if (beginIndex > -1 && endIndex > -1) {
				int len = beginIndex + begin.length();
				while (endIndex < len) {
					endIndex = oldString.substring(endIndex + 1).indexOf(end) + oldString.substring(0, endIndex + 1).length();
				}
				oldString = oldString.substring(beginIndex, endIndex);
			}
		}
		return oldString;
	}
	
	/**
	 * <p>从oldString中截取一部分字符串，需要给出截取部分的开头(begin)和结尾字符串(end)，begin匹配第一个，end匹配开头后第一个
	 * 
	 * <p>不包含begin
	 * 
	 * <p>若begin为空字符串则从oldString开头开始截取，到end
	 * 
	 * <p>若end为空字符串则返回空字符串(本来应该返回begin，但是结果不能保护begin)，
	 * 
	 * <p>若begin,end都为空，就返回空字符串
	 * 
	 * <p>三个参数任一为null则返回oldString
	 *
	 * @param oldString
	 * @param begin
	 * @param end
	 * @return
	 * @author ly
	 * @date 2017年3月6日 上午10:02:57
	 */
	public static String cutBetweenStringNextWithOutBegin(String oldString, String begin, String end) {
		if (oldString != null && begin != null && end != null) {
			int beginIndex = oldString.indexOf(begin);
			int endIndex = oldString.indexOf(end);
			if (beginIndex > -1 && endIndex > -1) {
				int len = beginIndex + begin.length();
				while (endIndex < len) {
					endIndex = oldString.substring(endIndex + 1).indexOf(end) + oldString.substring(0, endIndex + 1).length();
				}
				System.out.println("endIndex:" + endIndex);
				oldString = oldString.substring(beginIndex + begin.length(), endIndex);
			}
		}
		return oldString;
	}
	
	/**
	 * <p>从指定字符串(oldStr)中去除开头特定的字符串(str)，若有多个str接连出现在开头，则全部截去
	 * 
	 * <p>若任一参数为null则返回oldStr
	 * 
	 * <p>若str为空则返回oldStr
	 *
	 * @param oldStr
	 * @param str
	 * @return
	 * @author ly
	 * @date 2017年3月3日 上午10:33:40
	 */
	public static String deleteOfStringBegin(String oldStr, String str) {
		if (oldStr != null && !JudgeUtils.isEmpty(str)) {
			if (oldStr.indexOf(str) == 0) {
				oldStr = oldStr.substring(str.length());
				return deleteOfStringBegin(oldStr, str);
			}
		}
		return oldStr;
	}
	
	/**
	 * <p>将代表数字的字符串(strNum)转换为int类型，并去除开头的0
	 * 
	 * <p>若字符串并非代表一串数字(包括为空位null的情况)，那么就返回0
	 * 
	 * <p>内联调用了方法<code>getInt(String strNum, int defval)</code>
	 *
	 * @param strNum
	 * @return
	 * @author ly
	 * @date 2017年3月3日 上午11:23:57
	 */
	public static int getInt(String strNum) {
		return getInt(strNum, 0);
	}
	
	/**
	 * <p>将代表数字的字符串(strNum)转换为int类型，并去除开头的0
	 * 
	 * <p>若字符串并非代表一串数字(包括为空位null的情况)，那么就返回默认值(defval)
	 * 
	 * <p>内联调用了方法<code>deleteOfStringBegin(String oldStr, String str)</code>
	 *
	 * @param strNum
	 * @param defval
	 * @return
	 * @author ly
	 * @date 2017年5月6日 下午3:13:31
	 */
	public static int getInt(String strNum, int defval) {
		int result = defval;
		if (!JudgeUtils.isEmpty(strNum)) {
			strNum = deleteOfStringBegin(strNum, "0");
			try {
				result = Integer.parseInt(strNum);
			} catch (NumberFormatException e) {
				Log4JUtils.error("字符串转换为int类型出错", e);
			}
		}
		return result;
	}
	
	/**
	 * <p>将代表数字的字符串数组(strArr)转换为int类型的数组，并去除各元素开头的0
	 * 
	 * <p>若某个元素并非代表一串数字，那么就返回默认值(defval)
	 * 
	 * <p>若数组为空或null都返回null
	 * 
	 * <p>内联调用了方法<code>getInt(String strNum, int defval)</code>
	 *
	 * @param strArr
	 * @param defval
	 * @return
	 * @author ly
	 * @date 2017年5月6日 下午3:39:54
	 */
	public static Integer[] getInt(String[] strArr, int defval) {
		Integer[] result = null;
		if (!JudgeUtils.isEmpty(strArr)) {
			result = new Integer[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				result[i] = getInt(strArr[i], defval);
			}
		}
		return result;
	}
	
	public static double getDouble(String str, double defval) {
		double result = defval;
		if (!JudgeUtils.isEmpty(str)) {
			try {
				result = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				Log4JUtils.error("字符串转换为double类型出错", e);
			}
		}
		return result;
	}
	
	/**
	 * <p>校验邮政编码
	 * 
	 * <p>(?!\d) ：又称为负向零宽度断言或者零宽度负预测先行断言，它断言自身位置的后面不能匹配\d，也就是后面不能再是数字
	 *
	 * @param zipcode
	 * @return
	 * @author ly
	 * @date 2017年3月16日 上午11:13:06
	 */
	public static boolean checkZipcode(String zipcode) {
		if (!JudgeUtils.isEmpty(zipcode)) {
			if (zipcode.matches("\\d{6}(?!\\d)")) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 1
	 * 
	 * <p>判断字符串是否为空或"null"
	 * 
	 * <p>若参数为null则认为为空返回true
	 *
	 * @param str
	 * @return
	 * @author ly
	 * @date 2017年3月16日 下午5:57:14
	 */
	public static boolean isEmpty(String str) {
		if (null != str) {
			return "".equals(str.trim()) || "null".equals(str.trim()) ? true : false;
		}
		return true;
	}
	
	/**
	 * <p>将一个字符串数组中的每个指定字符串中含有的oldElement替换为新的字符串newElement
	 *
	 * @param arr
	 * @param oldElement
	 * @param newElement
	 * @return
	 * @author ly
	 * @date 2017年4月20日 下午4:01:24
	 */
	public static String[] replaceAllElements(String[] arr, String oldElement, String newElement) {
		if (arr != null && !JudgeUtils.isEmpty(oldElement) && !JudgeUtils.isEmpty(newElement)) {
			for (int i = 0, j = arr.length; i < j; i++) {
				arr[i] = arr[i].replaceAll(oldElement, newElement);
			}
		}
		return arr;
	}
	
	/**
	 * <p>将编码格式为ISO-8859-1的字符串转换为UTF-8编码格式
	 * 
	 * <p>该方法调用了本类方法<code>transcoding</code>
	 *
	 * @param strIn
	 * @return
	 * @author ly
	 * @date 2017年5月5日 上午10:22:57
	 */
	public static String ISOToUTF(String str) {
		return transcoding(str, "ISO-8859-1", "UTF-8");
	}
	
	/**
	 * 将字符串由原编码格式(sourceCode)转换为目标编码格式(targetCode)
	 *
	 * @param str
	 * @param sourceCode
	 * @param targetCode
	 * @return
	 * @author ly
	 * @date 2017年5月5日 上午11:04:27
	 */
	public static String transcoding(String str, String sourceCode, String targetCode) {
		String result = null;
		if (!JudgeUtils.isEmpty(str)) {
			try {
				byte[] b = str.getBytes(sourceCode);
				result = new String(b, targetCode);
			} catch (Exception e) {
				e.printStackTrace();
				Log4JUtils.error("", e);
				return null;
			}
		}
		return result;
	}
}
