package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class CutBetweenStringNextWithOutBegin {
	public static void main(String[] args) {
		String oldString="<p align=\"center\"><img src=\"http://inews.gtimg.com/newsapp_bt/0/1219280237/641\" style=\"display:block;\"></p>";
		String begin="<img src=\"";
		String end="\"";
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin(oldString, begin, end));
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin("", begin, end));
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin(oldString, "", end));
		System.out.println("111:"+StringUtils.cutBetweenStringNextWithOutBegin(oldString, begin, ""));
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin("", "", end));
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin("", begin, ""));
		System.out.println(StringUtils.cutBetweenStringNextWithOutBegin(oldString, "", ""));
	}
}
