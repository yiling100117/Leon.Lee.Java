package leon.special.instance.factory.test;

import java.util.HashMap;

import org.junit.Test;

import leon.special.instance.factory.BaseFactoryMethod;
import leon.special.test.TestClz;

@TestClz("baseFactoryMethod")
public class BaseFactoryMethodTest {
	
	@Test
	public void funcTest() {
		TestClass1 a1 = BaseFactoryMethod.getInstance(TestClass1.class);
		a1.setA(2);
		System.out.println(a1);
		TestClass1 a2 = BaseFactoryMethod.getInstance(TestClass1.class);
		System.out.println(a2);
		
		TestClass2 a3 = BaseFactoryMethod.getInstance(TestClass2.class);
		a3.setA(2);
		System.out.println(a3);
		TestClass2 a4 = BaseFactoryMethod.getInstance(TestClass2.class);
		System.out.println(a4);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("a", 100);
		TestClass2 a5 = null;
		try {
			a5 = BaseFactoryMethod
					.getInstance(Class.forName("leon.special.instance.factory.test.TestClass2"), map);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(a5);
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		TestClass2 a6 = null;
		try {
			a6 = BaseFactoryMethod
					.getInstance(Class.forName("leon.special.instance.factory.test.TestClass2"), map1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(a6);
		
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("a", 1000);
		TestClass2 a7 = null;
		try {
			a7 = BaseFactoryMethod
					.getInstance(Class.forName("leon.special.instance.factory.test.TestClass2"), map3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(a7);
		TestClass2 a8 = BaseFactoryMethod.getInstance(TestClass2.class);
		System.out.println(a8);
		
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("a", 10001);
		TestClass2 a9 = null;
		try {
			a9 = BaseFactoryMethod
					.getInstance(Class.forName("leon.special.instance.factory.test.TestClass2"), map4);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(a9);
		System.out.println(a8);
		System.out.println(a7);
	}
	
	@Test
	public void funcTest1() {//需要修改CACHE_MAX的值才能测试
		for (int i = 1; i < 40; i++) {
			String clzName = "leon.special.instance.factory.test.TestClass" + i;
			try {
				BaseFactoryMethod.getInstance(Class.forName(clzName));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
}