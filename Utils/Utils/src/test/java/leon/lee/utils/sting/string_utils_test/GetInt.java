package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class GetInt {
	public static void main(String[] args) {
		String num="00011111";
		String[] nums={"001","002","3330033"};
		String str="asdfsa";
		String[] strs={"001sdf","100233","3330ss033"};
		String empty="";
		String[] emptys={};
		String strNull=null;
		String[] Nulls=null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("纯数字字符串："+StringUtils.getInt(num));
		System.out.println("纯数字字符串："+StringUtils.getInt(num,1));
		Integer[] int1 = StringUtils.getInt(nums,1);
		for (Integer integer : int1) {
			System.out.println("纯数字字符串："+integer);
		}
		System.out.println("非纯数字字符串："+StringUtils.getInt(str));
		System.out.println("非纯数字字符串："+StringUtils.getInt(str,1));
		Integer[] int2 = StringUtils.getInt(strs,1);
		for (Integer integer : int2) {
			System.out.println("非纯数字字符串："+integer);
		}
		
		System.out.println("----参数为空情况测试----");
		System.out.println("空字符串："+StringUtils.getInt(empty));
		System.out.println("空字符串："+StringUtils.getInt(empty,1));
		Integer[] int3 = StringUtils.getInt(emptys,1);
		for (Integer integer : int3) {
			System.out.println("空字符串："+integer);
		}
		
		System.out.println("----参数为null情况测试----");
		System.out.println("null："+StringUtils.getInt(strNull));
		System.out.println("null："+StringUtils.getInt(strNull,1));
		Integer[] int4 = StringUtils.getInt(Nulls,1);
		for (Integer integer : int4) {
			System.out.println("null："+integer);
		}
	}
}
