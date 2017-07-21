package study.effectivejava;

/**
 * 用来测试重写方法的执行顺序
 * 
 * @author ly
 * @date 2017年4月17日 上午9:31:19
 */
public class Title14OverrideMethodOrder {
	public static void main(String[] args) {
		B1 b=new B1();
		b.getA();
	}
}
class A1{
	
	public void getA(){
		System.out.println("这个是类A1的getA()方法...准备调用getB()方法");
		getB();
	}
	
	public void getB(){
		System.out.println("这个是类A1的getB()方法");
	}
	
}

class B1 extends A1{
	
	public void getA(){
		System.out.println("这个是类B1的getA()方法...准备调用类A的getA()方法");
		super.getA();
	}
	
	public void getB(){
		System.out.println("这个是类B1的getB()方法...准备调用类A的getB()方法");
		super.getB();
	}
	
}