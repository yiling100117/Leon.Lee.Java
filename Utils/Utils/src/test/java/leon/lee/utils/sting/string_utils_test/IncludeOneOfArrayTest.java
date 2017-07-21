package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class IncludeOneOfArrayTest {

	public static void main(String[] args) {
		String str = "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2017/0302/20170302111434768.jpg\" suffix=\"jpg\" title=\"148841948623100_html_7ee2e233\"></p> "
				+ "<p align=\"center\">最近一段时间，在<a href=\"http://country.huanqiu.com/japan\" .gif class=\"linkAbout\" target=\"_blank\" title=\"日本\">日本</a>恐怕没有比森友学园更“出名”的私立教育机构了。</p> "
				+ " <p>　　先是这家教育机构开办的幼儿园被曝发.jpge放含有侮辱、仇恨.JPG<a href=\"http://country.huanqiu.com/china\" class=\"linkAbout\" target=\"_blank\" title=\"中国\">中国</a>人和<a href=\"http://country.huanqiu.com/korea\" class=\"linkAbout\" target=\"_blank\" title=\"韩国\">韩国</a>人言论的材料，紧接着又有消息传出，该机构筹办中的小学曾以“安倍晋三纪念小学”（以下简称“安倍小学”）名义进行办校募捐，并邀请日本第一夫人安倍昭惠出任名誉校长，而为建立该小学而购买的国有土地的价格仅为市场价的14%。</p>"
				+ " <p align=\"center\"><img border=\"0\" name=\"图片 4\" src=\"http://himg2.huanqiu.com/attachment2010/2017/0302/20170302111434531.png\"";
		String strEmpty="";
		String strNull=null;
		
		String[] arr = { ".jpge", ".png", ".jpg", ".gif", ".JPGE", ".PNG",".JPG", ".GIF" };
		String[] arrEmpty = {};
		String[] arrNull = null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("方法基础功能测试结果:"+StringUtils.includeOneOfArray(str, arr));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("参数(\"str\")为空情况测试结果:"+StringUtils.includeOneOfArray(strEmpty, arr));
		System.out.println("参数(\"arr\")为空情况测试结果:"+StringUtils.includeOneOfArray(str, arrEmpty));
		System.out.println("参数(\"str,arr\")为空情况测试结果:"+StringUtils.includeOneOfArray(strEmpty, arrEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("参数(\"str\")为null情况测试结果:"+StringUtils.includeOneOfArray(strNull, arr));
		System.out.println("参数(\"arr\")为null情况测试结果:"+StringUtils.includeOneOfArray(str, arrNull));
		System.out.println("参数(\"str,arr\")为null情况测试结果:"+StringUtils.includeOneOfArray(strNull, arrNull));
		
		System.out.println("----测试性能----");
		long start=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			StringUtils.includeOneOfArray(str, arr);
		}
		System.out.println("完成时间："+(System.currentTimeMillis()-start));
		
		/*System.out.println("----测试性能----");
		String[] strs=new String[10];
		long start1=System.currentTimeMillis();
		for(long i=0;i<10000000000l;i++){
			for(int j=0,len=strs.length;j<strs.length;j++){
				
			}
		}
		System.out.println("完成时间："+(System.currentTimeMillis()-start1)/100);*/
	}

}
