package leon.lee.utils.judge_utils_test;

import java.util.ArrayList;
import java.util.List;

import leon.lee.utlis.JudgeUtils;

public class IsEmpty {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		int[] arrInt = {};
		String str = "1";
		
		List list=new ArrayList();
		list.add(1);
		list.add("1");
		System.out.println(JudgeUtils.isEmpty(null));
		
		System.out.println("----方法基础功能测试----");
		System.out.println(JudgeUtils.isEmpty(arrInt));
		System.out.println(JudgeUtils.isEmpty(str));
		System.out.println("测试只有空格的字符串："+JudgeUtils.isEmpty(" "));
		
		System.out.println("----参数为空情况测试----");
		System.out.println(JudgeUtils.isEmpty(""));
		
		System.out.println("----参数为null情况测试----");
		System.out.println(JudgeUtils.isEmpty(null));
		
		System.out.println("----参数为\"null\"情况测试----");
		System.out.println(JudgeUtils.isEmpty("null"));
	}
}
