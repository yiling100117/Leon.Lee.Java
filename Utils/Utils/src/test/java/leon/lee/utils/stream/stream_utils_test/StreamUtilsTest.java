package leon.lee.utils.stream.stream_utils_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import leon.lee.utlis.stream.StreamUtils;


public class StreamUtilsTest {
	public static void main(String[] args) {
		InputStream is=null;
		try {
			is=new  FileInputStream("E:\\logs\\log_2017_04_19.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int read=0;
		try {
			read = is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(read);
		StreamUtils.closeInputStream(is);
		try {
			read = is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(read);
		
		OutputStream ops=null;
		try {
			ops=new FileOutputStream("E:\\logs\\log_2017_04_19.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ops.write(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		StreamUtils.closeOutputStream(ops);
		try {
			ops.write(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
