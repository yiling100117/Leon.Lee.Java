package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class DeleteOfStringBeginTest {
	public static void main(String[] args) {
		
		String oldStr = "111111111112222222";
		String oldStrEmpty="";
		String oldStrNull=null;
		String str = "1";
		String strEmpty="";
		String strNull=null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("方法基础功能测试结果:"+StringUtils.deleteOfStringBegin(oldStr, str));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("参数(\"oldStr\")为空情况测试结果:"+StringUtils.deleteOfStringBegin(oldStrEmpty, str));
		System.out.println("参数(\"str\")为空情况测试结果:"+StringUtils.deleteOfStringBegin(oldStr, strEmpty));
		System.out.println("参数(\"oldStr,str\")为空情况测试结果:"+StringUtils.deleteOfStringBegin(oldStrEmpty, strEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("参数(\"oldStr\")为null情况测试结果:"+StringUtils.deleteOfStringBegin(oldStrNull, str));
		System.out.println("参数(\"str\")为null情况测试结果:"+StringUtils.deleteOfStringBegin(oldStr, strNull));
		System.out.println("参数(\"oldStr,str\")为null情况测试结果:"+StringUtils.deleteOfStringBegin(oldStrNull, strNull));
	}
}
