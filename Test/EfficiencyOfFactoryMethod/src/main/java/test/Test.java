package test;

import java.util.HashMap;
import java.util.Map;

import leon.special.instance.factory.BaseFactoryMethod;

/**
 * Hello world!
 *
 */
public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		for (int j = 0; j < 10; j++) {
			System.out.println("-----------------------------------");
			Thread thread=new Thread(() -> {
				long start = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
					new A();
				}
				System.out
						.println("正常创建对象耗时：" + (System.currentTimeMillis() - start));

				start = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
					try {
						BaseFactoryMethod.getInstance(Class.forName("test.A"));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println(
						"工厂方法创建对象耗时：" + (System.currentTimeMillis() - start));

				start = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
					new A(1, 2);
				}
				System.out.println(
						"有参构造创建对象耗时：" + (System.currentTimeMillis() - start));

				start = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
					A a = null;
					try {
						a = BaseFactoryMethod.getInstance(Class.forName("test.A"));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					a.setA(1);
					a.setB(2);
					a = null;
				}
				System.out.println(
						"set方法构造创建对象耗时：" + (System.currentTimeMillis() - start));

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("a", 1);
				map.put("b", 2);

				start = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
					try {
						BaseFactoryMethod.getInstance(Class.forName("test.A"), map);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println(
						"反射造创建对象耗时：" + (System.currentTimeMillis() - start));
			});
			thread.start();
			thread.sleep(10000);
		}
	}

}