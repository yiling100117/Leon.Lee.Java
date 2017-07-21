package leon.base.utils.string.string_utils.test;

import org.junit.Test;

import leon.base.utils.string.StringUtils;

public class DelEndSameStrTest {
	
	private String	str		= "this this thisthis is a test string!";
	private String	sameStr	= "this ";
	
	@Test
	public void functionTest() {
		prnResult();
	}
	
	@Test
	public void strIsNull() {
		str = null;
		prnResult();
	}
	
	@Test
	public void sameStrIsNull() {
		sameStr = null;
		prnResult();
	}
	
	@Test
	public void strIsEmpty() {
		str = "";
		prnResult();
	}
	
	@Test
	public void sameStrIsEmpty() {
		sameStr = "";
		prnResult();
	}
	
	private void prnResult() {
		String result = StringUtils.delEndSameStr(str, sameStr);
		System.out.println(result);
	}
}
