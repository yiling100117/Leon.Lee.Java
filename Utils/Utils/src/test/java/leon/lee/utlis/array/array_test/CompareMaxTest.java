package leon.lee.utlis.array.array_test;

import leon.lee.utlis.array.ArrayUtils;


public class CompareMaxTest {
	public static void main(String[] args) {
		String[] a={"ad","b","c","aa","ab"};
		System.out.println(ArrayUtils.compareMax(a));
		ComTest[] a1={new ComTest(2),new ComTest(1),new ComTest(4),new ComTest(7) };
		System.out.println(ArrayUtils.compareMax(a1));
	}
}

class ComTest implements Comparable<ComTest>{

	int a;
	
	public ComTest(int a) {
		this.a=a;
	}
	
	@Override
	public int compareTo(ComTest o) {
		return this.a-o.a;
	}

	@Override
	public String toString() {
		return "ComTest [a=" + a + "]";
	}
	
}