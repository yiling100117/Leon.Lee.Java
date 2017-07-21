package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class CheckZipcodeTest {
	public static void main(String[] args) {
		String zipcode="030012";
		String zipcodeEmpty="";
		String zipcodeNull=null;
		
		System.out.println("功能测试："+StringUtils.checkZipcode(zipcode));
		System.out.println("参数为空测试："+StringUtils.checkZipcode(zipcodeEmpty));
		System.out.println("参数为null测试："+StringUtils.checkZipcode(zipcodeNull));
	}
}
