package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class CutOutBetweenStringNext {
	public static void main(String[] args) {
		String oldString="221111222<img 1src=\"1http://inews.gtimg.com/newsapp_bt/0/1212764593/641\" style=\"display:block;\"></p>";
		String oldStringEmpty="";
		String oldStringNull=null;
		String begin="<img 1src=\"";
		String beginEmpty="";
		String beginNull=null;
		String end="1";
		String endEmpty="";
		String endNull=null;
		
		System.out.println("----新增功能：从开始后的第一个结尾单词截取测试----");
		System.out.println("新增功能：从开始后的第一个结尾单词截取测试的结果："+StringUtils.cutOutBetweenStringNext(oldString,begin,end));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("新增功能：oldString为空情况测试："+StringUtils.cutOutBetweenStringNext(oldStringEmpty,begin,end));
		System.out.println("新增功能：begin为空情况测试："+StringUtils.cutOutBetweenStringNext(oldString,beginEmpty,end));
		System.out.println("新增功能：end为空情况测试："+StringUtils.cutOutBetweenStringNext(oldString,begin,endEmpty));
		System.out.println("新增功能：oldString,begin为空情况测试："+StringUtils.cutOutBetweenStringNext(oldStringEmpty,beginEmpty,end));
		System.out.println("新增功能：oldString,end为空情况测试："+StringUtils.cutOutBetweenStringNext(oldStringEmpty,begin,endEmpty));
		System.out.println("新增功能：begin,end为空情况测试："+StringUtils.cutOutBetweenStringNext(oldString,beginEmpty,endEmpty));
		System.out.println("新增功能：oldString,begin,end为空情况测试："+StringUtils.cutOutBetweenStringNext(oldStringEmpty,beginEmpty,endEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("新增功能：oldString为null情况测试："+StringUtils.cutOutBetweenStringNext(oldStringNull,begin,end));
		System.out.println("新增功能：begin为null情况测试："+StringUtils.cutOutBetweenStringNext(oldString,beginNull,end));
		System.out.println("新增功能：end为null情况测试："+StringUtils.cutOutBetweenStringNext(oldString,begin,endNull));
		System.out.println("新增功能：oldString,begin为null情况测试："+StringUtils.cutOutBetweenStringNext(oldStringNull,beginNull,end));
		System.out.println("新增功能：oldString,end为null情况测试："+StringUtils.cutOutBetweenStringNext(oldStringNull,begin,endNull));
		System.out.println("新增功能：begin,end为null情况测试："+StringUtils.cutOutBetweenStringNext(oldString,beginNull,endNull));
		System.out.println("新增功能：oldString,begin,end为null情况测试："+StringUtils.cutOutBetweenStringNext(oldStringNull,beginNull,endNull));
		
		/*System.out.println("----测试性能----");
		long start=System.currentTimeMillis();
		for(int i=0;i<100000000;i++){
			StringUtils.cutOutBetweenStringNext(oldString,begin,end);
		}
		System.out.println("完成时间："+(System.currentTimeMillis()-start)/100);*/
		
	}
}
