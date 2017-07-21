package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.special.ImgUtils;

public class CutImgWithIntrodTest {
	public static void main(String[] args) {
		String str = "<div class=\"text\" id=\"text\"> <p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2017/0301/20170301112052897.jpg\"></p> <p align=\"center\">制毒现场 警方供图</p> <p>　　 一名90后女孩，如花的年纪，却在金钱的诱惑下，以经营化学品为掩护制贩毒品。近日，在山东省公安厅禁毒总队统一协调指挥下，济南市公";
		String strEmpty="";
		String strNull=null;
		String[] imgType = { ".jpge", ".png", ".jpg", ".gif", ".JPGE", ".PNG",".JPG", ".GIF" };
		String[] imgTypeEmpty={};
		String[] imgNull=null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("方法基础功能测试结果:"+ImgUtils.cutImgWithIntrod(str, imgType));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("参数(\"str\")为空情况测试结果:"+ImgUtils.cutImgWithIntrod(strEmpty, imgType));
		System.out.println("参数(\"imgType\")为空情况测试结果:"+ImgUtils.cutImgWithIntrod(str, imgTypeEmpty));
		System.out.println("参数(\"str,imgType\")为空情况测试结果:"+ImgUtils.cutImgWithIntrod(strEmpty, imgTypeEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("参数(\"str\")为null情况测试结果:"+ImgUtils.cutImgWithIntrod(strNull, imgType));
		System.out.println("参数(\"imgType\")为null情况测试结果:"+ImgUtils.cutImgWithIntrod(str, imgNull));
		System.out.println("参数(\"str,imgType\")为null情况测试结果:"+ImgUtils.cutImgWithIntrod(strNull, imgNull));
	}
}
