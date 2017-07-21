package leon.lee.utils.judge_utils_test;

import leon.lee.utlis.JudgeUtils;

public class IsClassTest {
	public static void main(String[] args) {
		String str="This is a test String";
		String str2=new String();
		String strEmpty="";
		String strNull=null;
		
		int i=0;
		Integer I=0;
		
		A a= new IsClassTest().new A();
		B b= new B();
		
		System.out.println("----方法基础功能测试----");
		System.out.println("str,String:"+JudgeUtils.isClass(str,String.class));
		System.out.println("str2,String:"+JudgeUtils.isClass(str2,String.class));
		System.out.println("str,Integer:"+JudgeUtils.isClass(str2,Integer.class));
		System.out.println("int,Integer:"+JudgeUtils.isClass(i,Integer.class));
		System.out.println("Integer,String:"+JudgeUtils.isClass(I,String.class));
		System.out.println("a,A:"+JudgeUtils.isClass(a,A.class));
		System.out.println("b,A:"+JudgeUtils.isClass(b,A.class));
		System.out.println("b,B:"+JudgeUtils.isClass(b,B.class));
		System.out.println("测试数组判断："+JudgeUtils.isClass(new int[10], int[].class));
		
		
		System.out.println("----参数为空情况测试----");
		System.out.println("str为空:"+JudgeUtils.isClass(strEmpty,String.class));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("str为null:"+JudgeUtils.isClass(strNull,String.class));
		System.out.println("Class为null:"+JudgeUtils.isClass(str,null));
		System.out.println("str为null,Class为null:"+JudgeUtils.isClass(strNull,null));
		
	}
	
	class A{}
}

class B{}