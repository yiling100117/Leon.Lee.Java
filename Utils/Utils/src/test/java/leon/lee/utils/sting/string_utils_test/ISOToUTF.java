package leon.lee.utils.sting.string_utils_test;

import java.io.UnsupportedEncodingException;

import leon.lee.utlis.string.StringUtils;


public class ISOToUTF {
	public static void main(String[] args) {
		byte[] a=null;
		try {
			a="你好".getBytes("utf-8");
			for (int i = 0; i < a.length; i++) {
				System.out.print(i+"  ");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String string="";
		try {
			string = new String(a, "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("string:"+string);
		String iso = StringUtils.ISOToUTF(string);
		System.out.println(iso);
	}
}
