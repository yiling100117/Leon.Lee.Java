package leon.special.instance.factory.test;

import leon.special.instance.factory.SingleFactoryCache;

@SingleFactoryCache
public class TestClass1 {
	
	private int a = 0;
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "TestClass1 [a=" + a + "]";
	}
	
}
