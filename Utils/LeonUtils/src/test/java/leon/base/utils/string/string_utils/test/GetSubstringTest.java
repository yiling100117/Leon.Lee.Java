package leon.base.utils.string.string_utils.test;

import leon.base.utils.string.StringUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

import org.junit.Test;

/**
 * 
 ********************************************************************************
 *
 * <p>该类是所属于类<i>(leon.base.utils.StringUtils.java)
 * </i>的方法<i>(public static String getSubstring(String str, String bgStr, int endStr))</i>的测试类
 * 
 * @author ly
 * @date 2017年5月16日 下午4:52:54 
 * 
 ********************************************************************************
 *
 */
@TestClz
public class GetSubstringTest {
	
	private String	str		= "这是一个测试字符串";
	private String	bgStr	= "是";
	private String	endStr	= "字";
	
	@Test
	public void funcTest() {
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void funcTest1() {
		Object[] arg = { str, bgStr, endStr };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class, String.class };
		TstResultPrnUtils.prnResult(this.getClass(), arg, clzs);
	}
	
	@Test
	public void ExTest() {
		bgStr = "字";
		endStr = "是";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void sameParaTest() {
		bgStr = "字";
		endStr = "字";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void strIsNull() {
		str = null;
		String[] strArr = { str, bgStr, endStr };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class, String.class };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr, clzs);
	}
	
	@Test
	public void BgStrIsNull() {
		bgStr = null;
		String[] strArr = { str, bgStr, endStr };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class, String.class };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr, clzs);
	}
	
	@Test
	public void endStrIsNull() {
		endStr = null;
		String[] strArr = { str, bgStr, endStr };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class, String.class };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr, clzs);
	}
	
	@Test
	public void strIsEmpty() {
		str = "";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void bgStrIsEmpty() {
		bgStr = "";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void bgStrEndStrIsEmpty() {
		bgStr = "";
		endStr = "";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@Test
	public void endStrIsEmpty() {
		endStr = "";
		String[] strArr = { str, bgStr, endStr };
		TstResultPrnUtils.prnResult(GetSubstringTest.class, strArr);
	}
	
	@SuppressWarnings("unused")
	private String testMeth(String str, String bgStr, String endStr) {
		return StringUtils.getSubstring(str, bgStr, endStr);
	}
}
