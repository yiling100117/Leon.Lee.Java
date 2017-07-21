package leon.base.utils.base_utils.test;

import org.junit.Test;

import leon.base.utils.BaseUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

/**
 * 
 ********************************************************************************
 * 
 * <p>测试方法：isEmpty(T obj)
 *
 * @author ly
 * @date 2017年5月24日 下午4:34:41 
 *
 ********************************************************************************
 *
 */
@TestClz("testMeth1")
public class IsEmtyTest {
	
	private int	arg	= 1;
	
	@Test
	public void functionTest() {
		Object[] arr = { arg };
		TstResultPrnUtils.prnResult(IsEmtyTest.class, arr);
	}
	
	@SuppressWarnings("unused")
	private boolean testMeth1(Integer obj) {
		return BaseUtils.isEmpty(obj);
	}
}
