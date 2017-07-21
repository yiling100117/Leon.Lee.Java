package leon.special.instance.factory.test;

import leon.special.instance.factory.SingleFactoryCache;

@SingleFactoryCache
public class TestClass17 {
	
	private int a;
	
	public TestClass17() {}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public TestClass17(int a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "TestClass2 [a=" + a + "]";
	}
	
}
