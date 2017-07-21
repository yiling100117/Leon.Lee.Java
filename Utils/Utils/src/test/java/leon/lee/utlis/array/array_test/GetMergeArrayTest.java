package leon.lee.utlis.array.array_test;

import leon.lee.utlis.array.ArrayUtils;


public class GetMergeArrayTest {
	public static void main(String[] args) {
		Integer[] a1={1,2,3};
		Integer[] a2={4};
		Integer[] mergeArray1 = ArrayUtils.getMergeArray(a1, a2);
		for (int string : mergeArray1) {
			System.out.print(string+",");
		}
		
		Integer[] a3={1,2,3};
		Integer[] a4={4};
		Integer[] a5={5};
		Integer[] a6={6};
		Integer[][] b1={a3,a4};
		Integer[][] b2={a5,a6};
		Integer[][] mergeArray2 = ArrayUtils.getMergeArray(b1, b2);
		for (Integer[] integers : mergeArray2) {
			for (Integer integer : integers) {
				System.out.println(integer+",");
			}
		}
	}
}
