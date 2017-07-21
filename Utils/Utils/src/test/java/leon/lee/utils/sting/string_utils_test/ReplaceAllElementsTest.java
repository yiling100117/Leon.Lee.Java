package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;



public class ReplaceAllElementsTest {
	public static void main(String[] args) {
		String[] arr={"11111","2","322","4111","5","6","7"};
		String[] replaceElements = StringUtils.replaceAllElements(arr, null, "2");
		for (String string : replaceElements) {
			System.out.println(string);
		}
	}
}
