package leon.base.utils.map.map_utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import leon.base.utils.map.MapUtils;
import leon.special.test.TestClz;
import leon.special.test.TstResultPrnUtils;

@TestClz("prnMap")
public class PrnMapTest {
	
	private Map<String, String> map = new HashMap<String, String>();
	
	@Test
	public void funTest() {
		map.put("1", "1");
		map.put("2", "2");
		Object[] arg = { map };
		TstResultPrnUtils.prnResult(this.getClass(), arg);
	}
	
	@SuppressWarnings("unused")
	private <K, V> void prnMap(HashMap<K, V> map) {
		MapUtils.prnMap(map);
	}
}
