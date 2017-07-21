package study.annotation;

/**
 * jdk5自带注解测试
 * 
 * @author ly
 * @date 2017年4月19日 上午11:44:20
 */
public class BaseAnnotationTest {
	
}

class A {
	
	public void say() {
		System.out.println("A");
	}
}
class B extends A{
	@Override//覆盖(重写)的标志，用来检测方法签名是否和父类中一致
	public void say() {
		System.out.println("A");
	}
	@Deprecated//过期方法，表示这个方法不建议使用，以后可能会删除
	public void oldSay(){
		
	}
	@SuppressWarnings("unused")//关闭编译器警告，必须有参数
	private void noSay(){
		
	}
}