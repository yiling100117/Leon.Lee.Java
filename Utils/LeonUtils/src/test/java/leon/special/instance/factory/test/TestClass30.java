package leon.special.instance.factory.test;

import leon.special.instance.factory.SingleFactoryCache;

@SingleFactoryCache
public class TestClass30 {
	
	private int a;
	
	public TestClass30() {}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public TestClass30(int a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return "TestClass2 [a=" + a + "]";
	}
	
}
