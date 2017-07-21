package leon.base.utils.string.string_utils.test;

import org.junit.Test;

import leon.base.utils.string.StringUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("replaceAllEle")
public class ReplaceAllEleTest {
	
	private String	str			= "this is a test method!";
	private String	regex		= "t\\smethod";
	private String	replacement	= "";
	
	@Test
	public void funTest() {
		Object[] arg = { str, regex, replacement };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { String.class, String.class, String.class };
		TstResultPrnUtils.prnResult(this.getClass(), arg, clzs);
	}
	
	@SuppressWarnings("unused")
	private String replaceAllEle(String str, String regex, String replacement) {
		return StringUtils.replaceAllEle(str, regex, replacement);
	}
}
