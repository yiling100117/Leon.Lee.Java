package leon.lee.utils.judge_utils_test;

import leon.lee.utlis.JudgeUtils;

public class InArrayTest {
	public static void main(String[] args) {
		
		Integer[] integerArray = { 1, 2, 3 };//代表包装类
		A[] AArray = { new A(1), new A(2), new A(3) };//代表引用类型
		String[] strArry={"1","2","3"};
		String[] strArryEmpty={};
		String[] strArryNull=null;
		
		int i = 1;
		Integer I=1;
		Double D=1.0;
		String str="1";
		String strEmpty="";
		String strNull=null;
		A a1 = new A(1);
		A a5 = new A(5);
		C c1 = new C(1);
		
		System.out.println("----方法基础功能测试----");
		System.out.println("方法基础功能测试(Integer[],int)结果:"+JudgeUtils.inArray(integerArray, i));
		System.out.println("方法基础功能测试(Integer[],Integer)结果:"+JudgeUtils.inArray(integerArray, I));
		System.out.println("方法基础功能测试(Integer[],Double)结果:"+JudgeUtils.inArray(integerArray, D));
		System.out.println("方法基础功能测试(Integer[],a1)结果:"+JudgeUtils.inArray(integerArray, a1));
		System.out.println("方法基础功能测试(Integer[],str)结果:"+JudgeUtils.inArray(integerArray, str));
		
		System.out.println("方法基础功能测试(strArry[],int)结果:"+JudgeUtils.inArray(integerArray, i));
		System.out.println("方法基础功能测试(strArry[],Integer)结果:"+JudgeUtils.inArray(integerArray, I));
		System.out.println("方法基础功能测试(strArry[],Double)结果:"+JudgeUtils.inArray(integerArray, D));
		System.out.println("方法基础功能测试(strArry[],a1)结果:"+JudgeUtils.inArray(integerArray, a1));
		System.out.println("方法基础功能测试(strArry[],str)结果:"+JudgeUtils.inArray(strArry, str));
		
		System.out.println("方法基础功能测试(A[],int)结果:"+JudgeUtils.inArray(AArray, i));
		System.out.println("方法基础功能测试(A[],Integer)结果:"+JudgeUtils.inArray(AArray, I));
		System.out.println("方法基础功能测试(A[],a1)结果:"+JudgeUtils.inArray(AArray, a1));
		System.out.println("方法基础功能测试(A[],a5)结果:"+JudgeUtils.inArray(AArray, a5));
		System.out.println("方法基础功能测试(A[],b1)结果:"+JudgeUtils.inArray(AArray, c1));
		System.out.println("方法基础功能测试(A[],str)结果:"+JudgeUtils.inArray(AArray, str));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("参数(\"arr\")为空情况测试结果:"+JudgeUtils.inArray(strArryEmpty, str));
		System.out.println("参数(\"obj\")为空情况测试结果:"+JudgeUtils.inArray(strArry, strEmpty));
		System.out.println("参数(\"arr,obj\")为空情况测试结果:"+JudgeUtils.inArray(strArryEmpty, strEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("参数(\"arr\")为null情况测试结果:"+JudgeUtils.inArray(strArryNull, str));
		System.out.println("参数(\"obj\")为null情况测试结果:"+JudgeUtils.inArray(strArry, strNull));
		System.out.println("参数(\"arr,obj\")为null情况测试结果:"+JudgeUtils.inArray(strArryNull, strNull));
	}
}

class A {
	private int a;

	public A(int a) {
		this.a = a;
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
}

class C{
	private int a;
	
	public C(int a) {
		this.a = a;
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
		C other = (C) obj;
		if (a != other.a)
			return false;
		return true;
	}
	
}
