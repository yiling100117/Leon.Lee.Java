package study.effectivejava;

/**
 * 这个类用来测试clone方法
 * 
 * 这个方法非常不建议使用，应该用拷贝构造方法或其工厂方法代替，除非用于数组的拷贝
 * 
 * @author ly
 * @date 2017年4月15日 下午3:55:20
 */
public class Title11Clone {
	
	public static void main(String[] args) {
		A a = new A(1);
		System.out.println("this is a:" + a);
		A aClone = a.clone();
		System.out.println("a.getClass()==aClone.getClass():" + (a.getClass() == aClone.getClass()));//两对象的类型一致
		System.out.println("this is aClone:" + aClone);//拷贝的对象数据应该与被拷贝对象一致
		System.out.println("a.equals(aClone):" + a.equals(aClone));//因为数据一致，所以两对象应该是逻辑相等的
		System.out.println("a==aClone:" + (a == aClone));//但是并非同一对象
	}
}

class A implements Cloneable {//要使用clone的类必须实现Cloneabel接口
	
	private int	a;
	
	public A(int a){
		this.a=a;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (a != other.a)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
	@Override
	public A clone() {//要使用clone的类必须重载Object类中的clone方法(因为Object类中的clone方法为protected的)
		try {
			return (A) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}//注意：这个最基本的实现只能用于该类的域中只包含不可变的变量(基本类型，或者指向不可变对象的引用)，否则就会出问题(P48:克隆对象和被克隆对象引用至同一对象，改变一个对象会伤害(改变)另一个对象)！！
}

class B implements Cloneable {
	
	private int	b;
	private int[] elements;
	
	public B(int b,int[] elements){
		this.b=b;
		this.elements=elements;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		B other = (B) obj;
		if (b != other.b)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "B [b=" + b + "]";
	}
	
	@Override
	public B clone() {//这是一个数组的简单实现,其他引用类型也可以这样做(散列桶的实现见P49)
		try {
			B b=(B) super.clone();
			b.elements=elements.clone();//递归的调用clone
			return b;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}