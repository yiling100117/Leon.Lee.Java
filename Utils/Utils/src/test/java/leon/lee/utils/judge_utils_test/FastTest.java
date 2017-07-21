package leon.lee.utils.judge_utils_test;

import java.util.Arrays;
import java.util.Random;

public class FastTest {
	public static void main(String[] args) {
		
		String[] arr=new String[10000];
		Random s = new Random();
		for(int i=0; i< 10000; i++){
			arr[i] = String.valueOf(s.nextInt());
		}
		
		long startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	    	for(int j=0;j<arr.length;j++){
	    		if(arr[j].equals("A")){
	    			break;
	    		}
	    	}
	    }
	    long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println("useLoop:  " + duration / 1000000);
	    
	    startTime = System.nanoTime();
	    for (int i = 0; i < 100000; i++) {
	    	if(Arrays.asList(arr).contains("A")){
	    		break;
	    	}
	    }
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("useList:  " + duration / 1000000);
	}
}
