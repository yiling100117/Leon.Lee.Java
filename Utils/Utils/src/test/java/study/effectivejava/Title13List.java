package study.effectivejava;

import java.util.Arrays;
import java.util.List;

/**
 * 用来测试有关Arras.asList(T... a)方法
 * 
 * @author ly
 * @date 2017年4月16日 上午11:10:57
 */
public class Title13List {
	
	public static void main(String[] args) {
		
		//使用基本数据类型数组会有问题
		int[] a = { 1, 2, 3, 4 };
		List<int[]> list1 = Arrays.asList(a);
		System.out.println(list1.size());
		for (int[] is : list1) {
			System.out.println(is);
		}
		
		//多参基本类型会转换成对应包装类集合
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		List<Integer> list2 = Arrays.asList(i1, i2, i3);
		System.out.println(list2.size());
		for (int is : list2) {
			System.out.println(is);
		}
		
		//生成的数组不可变
		list2.add(4);
		System.out.println(list2.size());
		for (int is : list2) {
			System.out.println(is);
		}
	}
}
