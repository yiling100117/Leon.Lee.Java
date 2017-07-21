package leon.lee.utlis.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import leon.lee.utlis.JudgeUtils;

public class MapUtils {
	
	public <K, V> Map<K, V> removeValIsNull(Map<K, V> map) {
		Set<Entry<K, V>> set = map.entrySet();
		Iterator<Entry<K, V>> it = set.iterator();
		while (it.hasNext()) {
			Entry<K, V> e = it.next();
			if (JudgeUtils.isEmpty(e.getValue())) {
				it.remove();
			}
		}
		return map;
	}
	
	@Test
	public void test1() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", null);
		map.put("3", 2);
		map.put("4", 3);
		map = removeValIsNull(map);
		for (Entry<String, Integer> e : map.entrySet()) {
			System.out.println("K:" + e.getKey());
			System.out.println("V:" + e.getValue());
		}
	}
}
