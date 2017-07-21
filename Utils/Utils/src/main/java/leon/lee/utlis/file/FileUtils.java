package leon.lee.utlis.file;

import java.io.File;
import java.io.IOException;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

public class FileUtils {
	
	private FileUtils() {
	
	}
	
	/**
	 * <p>用于创建文件
	 *
	 * @param path
	 * @return
	 * @author ly
	 * @date 2017年4月24日 上午10:42:00
	 */
	public static File createFile(String path) {
		/*
		 * isFile:
		 * 		public boolean isFile():
		 * 			测试此抽象路径名表示的文件是否是一个标准文件。如果该文件不是一个目录，并且满足其他与系统有关的标准，那么该文件是标准文件。由 Java 应用程序创建的所有非目录文件一定是标准文件。 
		 * 		返回：
		 * 			当且仅当此抽象路径名表示的文件存在且是一个标准文件时，返回 true；否则返回 false 
		 * 		抛出： 
		 * 			SecurityException - 如果存在安全管理器，且其 SecurityManager.checkRead(java.lang.String)方法拒绝对文件进行读访问
		 * exists:
		 * 		public boolean exists():
		 * 			测试此抽象路径名表示的文件或目录是否存在。 
		 * 		返回：
		 * 			当且仅当此抽象路径名表示的文件或目录存在时，返回 true；否则返回 false 
		 * 		抛出： 
		 * 			SecurityException - 如果存在安全管理器，且其 SecurityManager.checkRead(java.lang.String) 方法拒绝对文件或目录进行写访问 
		 * ------------------------------------------------------------------------------------------------------------------
		 * 标准文件就是一个文件，不用太深究。
		 */
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * <p>用于创建文件夹
	 *
	 * @param path
	 * @return
	 * @author ly
	 * @date 2017年4月24日 上午10:42:00
	 */
	public static File createDirectory(String path) {
		/*
		 * boolean mkdir()
		 * 		创建此抽象路径名指定的目录。    
		 * boolean mkdirs()
		 * 		创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。 
		 */
		File file = new File(path);
		if (!file.isFile()) {
			file.mkdirs();
		} else {
			System.out.println("文件存在");
			System.out.println(file.isFile());
			if (file.isFile()) {
				file.mkdir();
			}
		}
		return file;
	}
	
	/**
	 * <p>删除目录下指定的文件
	 * 
	 * <p>未测试
	 *
	 * @param file
	 * @param b
	 * @author ly
	 * @date 2017年4月24日 上午10:41:47
	 */
	public static void deltePic(File file, String b) {
		/*
		 * list():返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。 以C盘为例，返回的是c盘下文件夹名字的字符串数组,如[TEMP, Windows]
		 * listFiles()  返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。以C盘为例返回的是C盘下文件夹目录地址，如[c:\TEMP, c:\Windows]
		 */
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if ((files[i].toString()).contains(b)) {
				if (files[i].isDirectory()) {
					deleteFile(files[i]);
					files[i].delete();
				}
			}
			files[i].getParentFile().delete();
		}
	}
	
	/**
	 * <p>删除文件
	 * 
	 * <p>未测试
	 *
	 * @param file
	 * @author ly
	 * @date 2017年4月24日 上午10:50:38
	 */
	public static void deleteFile(File file) {
		if (file.exists()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteFile(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
	}
	
	/**
	 * <p>用于web项目的附件上传
	 * 
	 * <p>未测试
	 * 
	 * @param path 上传路径
	 * @param request
	 * @return 返回文件保存路径
	 * @throws IOException
	 */
	/*public static String fileUpload(String path, HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("file");
		String fileName = uploadFile.getOriginalFilename();
		new File(path).mkdirs();
		InputStream in = uploadFile.getInputStream();
		OutputStream out = new FileOutputStream(path + "/" + fileName);
		byte[] bt = new byte[1024];
		int len = -1;
		while ((len = in.read(bt)) != -1) {
			out.write(bt, 0, len);
		}
		//关闭流
		out.close();
		in.close();
		return path + "/" + fileName;
	}*/
	
	/**
	 * <p>用于web项目的附件下载
	 *
	 * <p>未测试
	 *
	 * @param fileName
	 * @param response
	 * @author ly
	 * @date 2017年4月24日 上午10:37:02
	 */
	/*public static void download(String fileName, HttpServletResponse response) {
		File file = new File(fileName);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] b = new byte[1024];
		int len = 0;
		try {
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			response.setContentType("application/force-download");
			String filename = file.getName();
			response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
			response.setContentLength((int) file.length());
			while ((len = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			StreamUtils.closeInputStream(inputStream);
			StreamUtils.closeOutputStream(outputStream);
		}
	}*/
}
