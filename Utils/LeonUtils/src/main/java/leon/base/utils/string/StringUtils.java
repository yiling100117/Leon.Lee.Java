package leon.base.utils.string;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import leon.base.constant.ExInfoConstant;
import leon.base.utils.BaseUtils;

/**
 * 
 ********************************************************************************
 *
 * <p>字符串基础工具类
 * 
 * <p>包含了字符串应该有的基础功能
 * 
 * @author LeonLee
 * @date 2017年5月16日 下午4:30:32 
 * 
 ********************************************************************************
 *
 */
public class StringUtils {
	
	private StringUtils() {}
	
	/**
	 *
	 ********************************************************************************
	 *
	 * <p>KW:UUID,32位UUID,生成UUID
	 *
	 * <p>生成一个随机的UUID字符串，并去除了中间的"-"，长度为32
	 * 
	 * @return 生成32位的UUID
	 * @author LeonLee
	 * @date 2017年5月16日 下午4:31:55 
	 * 
	 ********************************************************************************
	 *
	 */
	public static String getUUID32() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 
	 ********************************************************************************
	 *
	 * <p>KW:Empty,判断是否为空,空,空字符串,null
	 *
	 * <p>判断字符串<i>(str)</i>是否为空、<i>"null"</i>或<i>null</i>
	 * 
	 * <p>注意:只有空格的字符也会被认为是空字符串
	 * 
	 * <p>注意:待判断的字符串会先去除两端的空格<code>({@link String #trim()})</code>然后再判断
	 *
	 * @param str 待判断字符串
	 * @return 参数<i>(str)</i>为空、<i>"null"</i>或<i>null</i>时返回<i>true</i>,否则返回<i>false</i>
	 * @author LeonLee
	 * @date 2017年5月16日 下午4:32:30 
	 * 
	 ********************************************************************************
	 *
	 */
	public static boolean isEmpty(String str) {
		if (null != str) {
			return "".equals(str.trim()) || "null".equals(str.trim()) ? true : false;
		}
		return true;
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:subString,基础截取字符串,按给定字符串截取
	 *
	 * <p>从字符串<i>(str)</i>中截取开头部分为<i>(bgStr)</i>，结尾部分为<i>(endStr)</i>的自字符串，并将结果返回
	 * 
	 * <p>若<i>(str)</i>为空字符串<i>("")</i>则返回空字符串<i>("")</i>
	 * <p>若<i>(bgStr)</i>为空字符串<i>("")</i>则从第一个字符开始截取，
	 * <p>若<i>(endStr)</i>为空字符串<i>("")</i>则截取到最后一个字符串
	 * 
	 * <p>三个参数只要有一个为<i>null</i>则返回原字符串<i>(str)</i>
	 * 
	 * <p>注意：该截取方式包含<i>(bgStr)</i>而不包含<i>(endStr)</i>
	 * 
	 * @param str 将要被截取的字符串
	 * @param bgStr 截取部分的开头(结果包括此部分)
	 * @param endStr 截取部分的结尾(结果不包括此部分)
	 * @return 截取下的字符串(子字符串)
	 * @exception RuntimeException:<i>(bgStr)</i>下标大于等于<i>(endStr)</i>的下标时，会抛出<i>(RuntimeException)</i>
	 * @author LeonLee
	 * @date 2017年5月17日 上午9:19:36 
	 * 
	 ********************************************************************************
	 *
	 */
	public static String getSubstring(String str, String bgStr, String endStr) {
		if (null != str && null != bgStr && null != endStr) {
			if (!"".equals(str)) {
				int bgIndex = str.indexOf(bgStr);
				int endIndex = "".equals(endStr) ? str.length() : str.indexOf(endStr);
				if (bgIndex > endIndex) {
					throw new RuntimeException(ExInfoConstant.ILLEGAL_ARG_INFO);
				}
				str = str.substring(bgIndex, endIndex);
			}
			return str;
		}
		throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:删除开头重复字符,del,删除重复字符
	 *
	 * <p>将字符串<i>(str)</i>开头连续的<i>(sameStr)</i>全部删除
	 * 
	 * <p><i>(sameStr)</i>必须在字符串开头，不在开头的不会删除
	 * 
	 * <p>多段<i>(sameStr)</i>连续出现在开头就全部删除
	 * 
	 * <p>任何参数为<i>(null)</i>则返回原字符串<i>(str)</i>
	 * 
	 * @param str 待处理的字符串
	 * @param sameStr 想要从<i>(str)</i>开头删除的字符串
	 * @return 返回代表删除了开头所有<i>(sameStr)</i>的<i>(str)</i>字符串
	 * @author LeonLee
	 * @date 2017年5月17日 下午2:55:12 
	 * 
	 ********************************************************************************
	 *
	 */
	public static String delBeSameStr(String str, String sameStr) {
		if (str != null && !isEmpty(sameStr)) {
			if (str.indexOf(sameStr) == 0) {
				str = str.substring(sameStr.length());
				return delBeSameStr(str, sameStr);
			}
		}
		return str;
	}
	
	/**
	 * 
	 ********************************************************************************
	 * 
	 * <p>KW:删除末尾重复字符,del,删除重复字符
	 *
	 * <p>将字符串<i>(str)</i>末尾连续的<i>(sameStr)</i>全部删除
	 * 
	 * <p><i>(sameStr)</i>必须在字符串末尾，不在末尾的不会删除
	 * 
	 * <p>多段<i>(sameStr)</i>连续出现在末尾就全部删除
	 * 
	 * <p>任何参数为<i>(null)</i>则返回原字符串<i>(str)</i>
	 * 
	 * @param str 待处理的字符串
	 * @param sameStr 想要从<i>(str)</i>末尾删除的字符串
	 * @return 返回代表删除了末尾所有<i>(sameStr)</i>的<i>(str)</i>字符串
	 * @author LeonLee
	 * @date 2017年5月17日 下午2:55:12 
	 * 
	 ********************************************************************************
	 *
	 */
	public static String delEndSameStr(String str, String sameStr) {
		if (str != null && !isEmpty(sameStr)) {
			if (str.indexOf(sameStr) == str.length()) {
				str = str.substring(sameStr.length());
				return delEndSameStr(str, sameStr);
			}
		}
		return str;
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:替换字符串中部分字符串，正则表达试匹配
	 *
	 * <p>将给定字符串<code>(str)</code>中的所有与正则表达式<code>(regex)</code>匹配的部分替换为
	 * 新字符串<code>(replacement)</code>
	 * 
	 * <p>当给定字符串为空或正则表达式为空时，返回给定字符串
	 * 
	 * <p>当新字符串为空时，将正则匹配的字符串移除(替换为空字符串)
	 * 
	 * <p>替换的方法为<code>{@link String #replaceAll(String, String)}</code>
	 * 
	 * @param str 给定的原有字符串
	 * @param regex 表示待替换部分的正则表达式
	 * @param replacement 将要替换为的新字符串
	 * @return 返回一个替换内容后的字符串
	 * @author LeonLee
	 * @date 2017年6月15日 上午11:15:02 
	 * *******************************************************************************
	 */
	public static String replaceAllEle(String str, String regex, String replacement) {
		if (str != null && !BaseUtils.isEmpty(regex)) {
			replacement = BaseUtils.isEmpty(replacement) ? "" : replacement;
			str = str.replaceAll(regex, replacement);
		}
		return str;
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:正则截取字符串，获得匹配的部分
	 *
	 * <p>使用正则表达式<code>(regex)</code>截取给定字符串<code>(str)</code>，获得匹配的部分
	 * 
	 * <p>若两个参数任意一个为空，则返回原字符串<code>(str)</code>
	 * 
	 * @param str 给定的待截取的字符串
	 * @param regex 表示截取部分的正则表达式
	 * @return 和正则表达式匹配的字符串
	 * @author LeonLee
	 * @date 2017年6月15日 上午11:29:05 
	 * *******************************************************************************
	 */
	public static String getPortionByRegex(String str, String regex) {
		if (str != null && !BaseUtils.isEmpty(regex)) {
			Matcher matcher = Pattern.compile(regex).matcher(str);
			if (matcher.find()) {
				str = matcher.group(0);
			}
		}
		return str;
	}
}
