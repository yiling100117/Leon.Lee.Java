package leon.special.instance.factory.test;

import leon.special.instance.factory.SingleFactoryCache;

@SingleFactoryCache
public class TestClass24 {
	
	private int a;
	
	public TestClass24() {}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public TestClass24(int a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "TestClass2 [a=" + a + "]";
	}
	
}
