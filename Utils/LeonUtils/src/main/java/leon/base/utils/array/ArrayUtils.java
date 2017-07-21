package leon.base.utils.array;

import java.lang.reflect.Array;

import leon.base.constant.ExInfoConstant;
import leon.base.utils.BaseUtils;

/**
 * *******************************************************************************
 * <p>数组相关的基础、通用工具类
 * 
 * @author LeonLee
 * @date 2017年6月15日 下午3:02:34 
 * *******************************************************************************
 */
public class ArrayUtils {
	
	private ArrayUtils() {}
	
	/**
	 * *******************************************************************************
	 * <p>KW:两个数组融合
	 *
	 * <p>将两个指定的数组融合为一个
	 * 
	 * <p>基本类型数组必须转换为包装类数组才能使用此方法
	 * 
	 * <p>该方法不会去除重复的元素，并且返回的数组顺序为第一个参数<code>(arr1)</code>后为第二个参数<code>(arr2)</code>
	 * 
	 * <p>即：<code>(arr2)</code>的第一个元素在返回的数组内下标为<code>([arr1.length-1])</code>
	 *
	 * @param arr1 待融合的字符串1
	 * @param arr2 待融合的字符串2
	 * @return 一个新的数组，该数组的内容为<code>(arr1)</code>的所有元素和<code>(arr2)</code>的所有元素
	 * @author LeonLee
	 * @date 2017年6月13日 上午11:46:26 
	 * *******************************************************************************
	 */
	public static <T> T[] getMergeArray(T[] arr1, T[] arr2) {
		if (arr1 != null && arr2 != null) {
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Array.newInstance(arr1.getClass().getComponentType(),
					arr1.length + arr2.length);
			System.arraycopy(arr1, 0, result, 0, arr1.length);
			System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
			return result;
		} else {
			return arr1 != null ? arr1 : arr2;
		}
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:
	 *
	 * <p>KW:数组输出
	 *
	 * <p>用于便捷的输出数组，格式[ 1 2 3 4 5 6 ]
	 * 
	 * <p>当参数为<code>(null)</code>时,会抛出<code>({@link ExInfoConstant #ARG_NON_NULL_INFO})</code>异常
	 * 
	 * @param arr 待输出的数组
	 * @author LeonLee
	 * @date 2017年6月13日 下午2:34:29 
	 * 
	 * *******************************************************************************
	 */
	public static <T> void prnArray(T[] arr) {
		if (arr != null) {
			System.out.print("[ ");
			for (T t : arr) {
				System.out.print(t + " ");
			}
			System.out.println("]");
		} else {
			throw new RuntimeException(ExInfoConstant.ARG_NON_NULL_INFO);
		}
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:替换数组中的指定元素
	 *
	 * <p>将给定的数组<code>(arr)</code>中的指定元素<code>(oldEle)</code>替换为新的元素<code>(newEle)</code>
	 * 
	 * <p>若给定的数组<code>(arr)</code>为空或指定的元素为空则返回给定数组
	 * 
	 * <p>若新元素<code>(newEle)</code>为空则将指定元素从数组中移除
	 * 
	 * <p>移除元素内联调用了<code>({@link #removeEle(Object[], Object)})</code>
	 * 
	 * <p>由<code>({@link BaseUtils #isEmpty(Object)})</code>判断是否为空
	 * 
	 * @param arr 给定的待替换元素的数组
	 * @param oldEle 给定数组<code>(arr)</code>内待替换的旧元素
	 * @param newEle 将要替换旧元素<code>(oldEle)</code>的新元素
	 * @return 返回替换元素后数组
	 * @author LeonLee
	 * @date 2017年6月14日 上午10:58:52 
	 * *******************************************************************************
	 */
	
	public static <T> T[] replaceAllEle(T[] arr, T oldEle, T newEle) {
		if (arr != null && !BaseUtils.isEmpty(oldEle)) {
			if (BaseUtils.isEmpty(newEle)) {
				arr = removeEle(arr, oldEle);
			} else {
				for (int i = 0, len = arr.length; i < len; i++) {
					if (oldEle.equals(arr[i])) {
						arr[i] = newEle;
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * *******************************************************************************
	 * <p>KW:移除数组中所有的指定元素
	 *
	 * <p>移除给定数组<code>(arr)</code>中所有的指定元素<code>(ele)</code>
	 * 
	 * <p>给定数组移除元素后的长度是决定该方法效率的最大因素，因此当给定数组很长且其中指定元素较少时
	 * 该方法效率可能不尽人意。
	 * 
	 * @param arr 给定的待移除元素的数组
	 * @param ele 数组<code>(arr)</code>中待移除的元素
	 * @return 返回移除元素后的数组
	 * @author LeonLee
	 * @date 2017年6月14日 下午3:57:56 
	 * *******************************************************************************
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] removeEle(T[] arr, T ele) {
		T[] temp = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!ele.equals(arr[i])) {
				temp[index] = arr[i];
				index++;
			}
		}
		T[] result = (T[]) Array.newInstance(temp.getClass().getComponentType(), index);
		System.arraycopy(temp, 0, result, 0, index);
		return result;
	}
}
