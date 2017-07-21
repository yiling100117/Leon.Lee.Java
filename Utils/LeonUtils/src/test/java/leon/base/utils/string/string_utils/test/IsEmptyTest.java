package leon.base.utils.string.string_utils.test;

import org.junit.Test;

import leon.base.utils.string.StringUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("isEmpty")
public class IsEmptyTest {

	private String str = "";

	@Test
	public void funcTest1() {
		str = "测试是否为空";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest2() {
		str = "";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest3() {
		str = "   ";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest4() {
		str = " 11  ";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest5() {
		str = " null  ";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest6() {
		str = " null s  ";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@Test
	public void funcTest7() {
		str = "null";
		String[] arg = { str };
		TstResultPrnUtils.prnResult(IsEmptyTest.class, arg);
	}

	@SuppressWarnings("unused")
	private boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}
}
