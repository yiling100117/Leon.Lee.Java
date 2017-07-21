package leon.lee.utlis.array.array_test;

import leon.lee.utlis.array.ArrayUtils;


public class ReplaceAllElementsTest {
	public static void main(String[] args) {
		Integer[] arr={11111,2,322,4111,5,6,7};
		Integer[] replaceElements = ArrayUtils.replaceAllElements(arr, 11111, 2);
		for (int string : replaceElements) {
			System.out.println(string);
		}
		System.out.println();
		String[] arr1={"11111","2","322","4111","5","6","7"};
		String[] replaceElements1 = ArrayUtils.replaceAllElements(arr1, "11111", "2");
		for (String string : replaceElements1) {
			System.out.println(string);
		}
	}
}
