package leon.lee.utlis.array;

import java.lang.reflect.Array;

import leon.lee.utlis.JudgeUtils;
import leon.lee.utlis.string.StringUtils;

public class ArrayUtils {
	
	private ArrayUtils() {
		
	}
	
	/**
	 * <p>将两个指定的数组融合为一个
	 * 
	 * <p>基本类型数组必须转换为包装类数组才能使用此方法
	 * 
	 * <p>该方法不会去除重复的元素，并且返回的数组顺序为第一个参数arr1后为第二个参数arr2
	 * 
	 * <p>即：arr2的第一个元素在返回的数组内下标为[arr1.length-1]
	 *
	 * @param al
	 * @param bl
	 * @return
	 * @author ly
	 * @date 2017年4月20日 下午2:47:13
	 */
	public static <T> T[] getMergeArray(T[] arr1, T[] arr2) {
		if (arr1 != null && arr2 != null) {
			@SuppressWarnings("unchecked")
			T[] c = (T[]) Array.newInstance(arr1.getClass().getComponentType(), arr1.length + arr2.length);
			System.arraycopy(arr1, 0, c, 0, arr1.length);
			System.arraycopy(arr2, 0, c, arr1.length, arr2.length);
			return c;
		} else {
			return arr1 != null ? arr1 : arr2;
		}
	}
	
	/**
	 * <p>将一个数组中的每个指定元素oldElement替换为新的元素newElement
	 *
	 * <p>如果为字符串将会调用leon.lee.utlis.string.StringUtils.replaceAllElements(String[], String, String)方法
	 * 
	 * @param arr
	 * @param oldElement
	 * @param newElement
	 * @return
	 * @author ly
	 * @date 2017年4月20日 下午4:31:50
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] replaceAllElements(T[] arr, T oldElement, T newElement) {
		if (arr != null) {
			if (JudgeUtils.isClass(arr, String[].class)) {
				arr = (T[]) StringUtils.replaceAllElements((String[]) arr, (String) oldElement, (String) newElement);
			} else {
				for (int i = 0, j = arr.length; i < j; i++) {
					if (oldElement.equals(arr[i])) {
						arr[i] = newElement;
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * <p>返回数组中最大的一个元素
	 * 
	 * <p>这个素组中的元素必须实现comparable接口才能使用，比较的结果与compareTo的结果相同
	 * 
	 * @param i
	 * @return
	 * @author ly
	 * @date 2017年4月22日 下午2:36:51
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable> T compareMax(T[] i) {
		int size = i.length;
		for (int a = 1; a < size; a++) {
			for (int b = 0; b < size - a; b++) {
				if (i[b].compareTo(i[b + 1]) > 0) {//大的放后面
					T temp = i[b];
					i[b] = i[b + 1];
					i[b + 1] = temp;
				}
			}
		}
		return i[size - 1];
	}
}
