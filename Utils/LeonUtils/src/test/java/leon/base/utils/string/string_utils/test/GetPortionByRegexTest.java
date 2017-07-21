package leon.base.utils.string.string_utils.test;

import org.junit.Test;

import leon.base.utils.string.StringUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("getPortionByRegex")
public class GetPortionByRegexTest {
	
	private String	str		= "this is a test method!";
	private String	regex	= "s\\sis\\sa";
	
	@Test
	public void funTest() {
		Object[] arg = { str, regex };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class };
		TstResultPrnUtils.prnResult(this.getClass(), arg, clzs);
	}
	
	@SuppressWarnings("unused")
	private String getPortionByRegex(String str, String regex) {
		return StringUtils.getPortionByRegex(str, regex);
	}
}
