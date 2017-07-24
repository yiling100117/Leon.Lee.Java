package leon.base.utils.map.map_utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import leon.base.utils.map.MapUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("srotByKey")
public class SrotByKey {

	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	@Test
	public void funTest() {
		for(int i=0;i<100;i++) {
			map.put(i, i);
		}
		System.out.println(map);
		Object[] arg = { map };
		TstResultPrnUtils.prnResult(this.getClass(), arg);
	}

	@SuppressWarnings("unused")
	private <K, V> Map<K,V> srotByKey(HashMap<K, V> map) {
		return MapUtils.srotByKey(map);
	}

}
