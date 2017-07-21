package leon.base.utils.array.array_utils;

import org.junit.Test;

import leon.base.utils.array.ArrayUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("replaceAllEle")
public class ReplaceAllEleTest {
	
	private String[]	arr		= { "1", "2", "3", "4" };
	private String		oldEle	= "";
	private String		newEle	= "1";
	
	@Test
	public void funTest() {
		oldEle = "1";
		newEle = "";
		Object[] arg = { arr, oldEle, newEle };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String[].class, String.class, String.class };
		TstResultPrnUtils.prnResult(this.getClass(), arg, clzs);
	}
	
	@SuppressWarnings("unused")
	private String[] replaceAllEle(String[] arr, String newEle, String oldEle) {
		return ArrayUtils.replaceAllEle(arr, newEle, oldEle);
	}
}
