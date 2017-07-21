package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class CutBetweenStringNext {
	public static void main(String[] args) {
		String oldString="<p align=\"center\"><img src=\"http://inews.gtimg.com/newsapp_bt/0/1219280237/641\" style=\"display:block;\"></p>";
		String oldStringEmpty="";
		String oldStringNull=null;
		String begin="http://";
		String beginEmpty="";
		String beginNull=null;
		String end="\"";
		String endEmpty="";
		String endNull=null;
		
		System.out.println("----新增功能：从开始后的第一个结尾单词截取测试----");
		System.out.println("新增功能：从开始后的第一个结尾单词截取测试的结果："+StringUtils.cutBetweenStringNext(oldString,begin,end));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("新增功能：oldString为空情况测试："+StringUtils.cutBetweenStringNext(oldStringEmpty,begin,end));
		System.out.println("新增功能：begin为空情况测试："+StringUtils.cutBetweenStringNext(oldString,beginEmpty,end));
		System.out.println("新增功能：end为空情况测试："+StringUtils.cutBetweenStringNext(oldString,begin,endEmpty));
		System.out.println("新增功能：oldString,begin为空情况测试："+StringUtils.cutBetweenStringNext(oldStringEmpty,beginEmpty,end));
		System.out.println("新增功能：oldString,end为空情况测试："+StringUtils.cutBetweenStringNext(oldStringEmpty,begin,endEmpty));
		System.out.println("新增功能：begin,end为空情况测试："+StringUtils.cutBetweenStringNext(oldString,beginEmpty,endEmpty));
		System.out.println("新增功能：oldString,begin,end为空情况测试："+StringUtils.cutBetweenStringNext(oldStringEmpty,beginEmpty,endEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("新增功能：oldString为null情况测试："+StringUtils.cutBetweenStringNext(oldStringNull,begin,end));
		System.out.println("新增功能：begin为null情况测试："+StringUtils.cutBetweenStringNext(oldString,beginNull,end));
		System.out.println("新增功能：end为null情况测试："+StringUtils.cutBetweenStringNext(oldString,begin,endNull));
		System.out.println("新增功能：oldString,begin为null情况测试："+StringUtils.cutBetweenStringNext(oldStringNull,beginNull,end));
		System.out.println("新增功能：oldString,end为null情况测试："+StringUtils.cutBetweenStringNext(oldStringNull,begin,endNull));
		System.out.println("新增功能：begin,end为null情况测试："+StringUtils.cutBetweenStringNext(oldString,beginNull,endNull));
		System.out.println("新增功能：oldString,begin,end为null情况测试："+StringUtils.cutBetweenStringNext(oldStringNull,beginNull,endNull));
	}
}
