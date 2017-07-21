package leon.base.utils.array.array_utils;

import org.junit.Test;

import leon.base.utils.array.ArrayUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("getMergeArray")
public class GetMergeArrayTest {
	
	private Integer[]	arr1	= { 1, 2, 3 };
	private Integer[]	arr2	= { 4, 5, 6 };
	
	@Test
	public void funTest() {
		Object[] arg = { arr1, arr2 };
		@SuppressWarnings("rawtypes")
		Class[] clzs = { Integer[].class, Integer[].class };
		TstResultPrnUtils.prnResult(this.getClass(), arg, clzs);
	}
	
	@SuppressWarnings("unused")
	private Integer[] getMergeArray(Integer[] arr1, Integer[] arr2) {
		return ArrayUtils.getMergeArray(arr1, arr2);
	}
}
