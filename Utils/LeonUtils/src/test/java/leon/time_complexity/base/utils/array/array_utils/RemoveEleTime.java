package leon.time_complexity.base.utils.array.array_utils;

import java.lang.reflect.Array;

/**
 * *******************************************************************************
 * <p>结论，泛型不会降低程序的运行效率，但是也不会提升效率
 * 
 * @author LeonLee
 * @date 2017年6月14日 下午4:28:14 
 * *******************************************************************************
 */
public class RemoveEleTime {
	
	private static String[] arr = { "1", "2", "3", "4"};
			
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			removeEle1(arr, "1");
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			removeEle2(arr, "1");
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static <T> T[] removeEle1(T[] arr, T ele) {
		int len = arr.length;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) Array.newInstance(arr.getClass().getComponentType(), len);
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (!ele.equals(arr[i])) {
				temp[index] = arr[i];
				index++;
			}
		}
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(temp.getClass().getComponentType(), index);
		System.arraycopy(temp, 0, result, 0, index);
		return result;
	}
	
	public static String[] removeEle2(String[] arr, String ele) {
		int len = arr.length;
		String[] temp = (String[]) Array.newInstance(arr.getClass().getComponentType(), len);
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (!ele.equals(arr[i])) {
				temp[index] = arr[i];
				index++;
			}
		}
		String[] result = (String[]) Array.newInstance(temp.getClass().getComponentType(), index);
		System.arraycopy(temp, 0, result, 0, index);
		return result;
	}
}
