package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class CutOutBetweenStringTest {
	public static void main(String[] args) {
		
		String str = "这是开始<!-- Ad Survey 广告位代码  文章页 视频广告-->关新闻上方合作 end--> <!--相关新闻 begain--> </p><div class=\"reTopics\"> <div class=\"tit\">相关新闻<!--版权印 end-->这是结束";
		String strEmpty="";
		String strNull=null;
		String begin="<!-- Ad Survey 广告位代码  文章页 视频广告-->";
		String beginEmpty="";
		String beginNull=null;
		String end="<!--版权印 end-->";
		String endEmpty="";
		String endNull=null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("两参从(\""+begin+"\")截取到最后的结果："+StringUtils.cutOutBetweenString(str, begin));
		System.out.println("三参从(\""+begin+"\")截取到(\""+end+"\")的结果："+StringUtils.cutOutBetweenString(str,begin,end));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("两参从(\"str\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty, begin));
		System.out.println("两参从(\"begin\")为空的结果："+StringUtils.cutOutBetweenString(str, beginEmpty));
		System.out.println("两参从(\"str,begin\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty, beginEmpty));
		
		System.out.println("三参从(\"str\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty,begin,end));
		System.out.println("三参从(\"begin\")为空的结果："+StringUtils.cutOutBetweenString(str,beginEmpty,end));
		System.out.println("三参从(\"end\")为空的结果："+StringUtils.cutOutBetweenString(str,begin,endEmpty));
		System.out.println("三参从(\"str,begin\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty,beginEmpty,end));
		System.out.println("三参从(\"str,end\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty,begin,endEmpty));
		System.out.println("三参从(\"begin,end\")为空的结果："+StringUtils.cutOutBetweenString(str,beginEmpty,endEmpty));
		System.out.println("三参从(\"str,begin,end\")为空的结果："+StringUtils.cutOutBetweenString(strEmpty,beginEmpty,endEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("两参从(\"str\")为null的结果："+StringUtils.cutOutBetweenString(strNull, begin));
		System.out.println("两参从(\"begin\")为null的结果："+StringUtils.cutOutBetweenString(str, beginNull));
		System.out.println("两参从(\"str,begin\")为null的结果："+StringUtils.cutOutBetweenString(strNull, beginNull));
		
		System.out.println("三参从(\"str\")为null的结果："+StringUtils.cutOutBetweenString(strNull,begin,end));
		System.out.println("三参从(\"begin\")为null的结果："+StringUtils.cutOutBetweenString(str,beginNull,end));
		System.out.println("三参从(\"end\")为null的结果："+StringUtils.cutOutBetweenString(str,begin,endNull));
		System.out.println("三参从(\"str,begin\")为null的结果："+StringUtils.cutOutBetweenString(strNull,beginNull,end));
		System.out.println("三参从(\"str,end\")为null的结果："+StringUtils.cutOutBetweenString(strNull,begin,endNull));
		System.out.println("三参从(\"begin,end\")为null的结果："+StringUtils.cutOutBetweenString(str,beginNull,endNull));
		System.out.println("三参从(\"str,begin,end\")为null的结果："+StringUtils.cutOutBetweenString(strNull,beginNull,endNull));
		
		System.out.println("----测试性能----");
		long start=System.currentTimeMillis();
		for(int i=0;i<100000000;i++){
			StringUtils.cutOutBetweenString(str,begin,end);
		}
		System.out.println("完成时间："+(System.currentTimeMillis()-start)/100);
		
	}
}
