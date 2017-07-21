package leon.lee.utils.judge_utils_test;

import java.util.HashMap;
import java.util.Map;

import leon.lee.utlis.JudgeUtils;

public class InMapTest {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("1", "一");
		map.put("2", "二");
		map.put("3", "三");
		Map<String, String> mapEmpty=new HashMap<String, String>();
		Map<String, String> mapNull=null;
		String str="2";
		String strEmpty="";
		String strNull=null;
		
		System.out.println("----方法基础功能测试----");
		System.out.println("map,str:"+JudgeUtils.inMap(map, str));
		
		System.out.println("----参数为空情况测试----");
		System.out.println("map为空:"+JudgeUtils.inMap(mapEmpty, str));
		System.out.println("str为空:"+JudgeUtils.inMap(map, strEmpty));
		System.out.println("map和str为空:"+JudgeUtils.inMap(mapEmpty, strEmpty));
		
		System.out.println("----参数为null情况测试----");
		System.out.println("map为null:"+JudgeUtils.inMap(mapNull, str));
		System.out.println("str为null:"+JudgeUtils.inMap(map, strNull));
		System.out.println("map和str为null:"+JudgeUtils.inMap(mapNull, strNull));
	}
}
