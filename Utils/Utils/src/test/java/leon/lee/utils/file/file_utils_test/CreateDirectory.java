package leon.lee.utils.file.file_utils_test;

import leon.lee.utlis.file.FileUtils;


public class CreateDirectory {
	public static void main(String[] args) {
		String path = "E:\\logs\\测试.txt";
		FileUtils.createDirectory(path);
	}
}
