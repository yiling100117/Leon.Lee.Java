package leon.lee.utlis.special;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Used for 七牛云存储相关类
 * 
 * @author Zhangxj
 * @date 2016年6月24日 上午9:31:28
 */
@SuppressWarnings("unused")
public class QiNiuUtils {
	
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private static final String		ACCESS_KEY			= "_EHy7--rWPVgc_GFaQ_Cta7DHaLYVGNd3iAVh_zY";
	private static final String		SECRET_KEY			= "TAbDejfgL6SDIKWV-Xg29-V5IgqRd8Y3y6KVX3cf";
	// 要上传的空间
	private static final String		BUCKET_NAME			= "renrenzhixun";
	// 七牛默认空间
	private static final String		QINIU_DEFAULT_ZONE	= "http://7xp64v.com1.z0.glb.clouddn.com/";
	// http://7xp64v.com2.z0.glb.qiniucdn.com/
	// 密钥配置
	/*private static Auth				auth				= Auth.create(ACCESS_KEY, SECRET_KEY);
	// 创建上传对象
	private static UploadManager	uploadManager		= new UploadManager();
	// 实例化一个BucketManager对象
	private static BucketManager	bucketManager		= new BucketManager(auth);*/
	
	/**
	 * Used for 获取Token
	 * 
	 * @author Zhangxj
	 * @return
	 * @date 2016年6月24日 上午10:57:52
	 */
	/*public static String getUpToken() {
		return auth.uploadToken(BUCKET_NAME);
	}*/
	
	/**
	 * Used for 上传
	 * 
	 * @author Zhangxj
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @date 2016年6月24日 上午10:58:01
	 */
	/*public static String qiniuUploadPic(String filePath) throws IOException {
		String baseUrl = "";
		// 获取源文件后缀
		String suffix = filePath.substring(filePath.lastIndexOf("."));
		// key值设置
		String timekey = StringUtil1.getSimpleDateFormatYyyyMMddHHmmssS() + StringUtil1.randomInt(6);
		timekey = timekey + suffix;
		try {
			// 调用put方法上传
			Response response = uploadManager.put(filePath, timekey, getUpToken());
			// 成功，返回自定义外链
			if (response.isOK()) {
				baseUrl = QINIU_DEFAULT_ZONE + timekey;
				//				System.out.println("baseUrl-->>" + baseUrl);
			}
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return baseUrl;
	}*/
	
	/**
	 * delete方法删除文件
	 * 
	 * @author Zhangxj
	 * @param key
	 * @return
	 * @date 2016年6月24日 上午11:30:44
	 */
	/*public static boolean delete(String key) {
		try {
			bucketManager.delete(BUCKET_NAME, key);
			return true;
		} catch (QiniuException e) {
			// 捕获异常信息
			Response r = e.response;
			System.out.println(r.toString());
			return false;
		}
	}*/
	
	// <option label="7xp64v.com1.z0.glb.clouddn.com"
	// <option label="7xp64v.com2.z0.glb.clouddn.com"
	// <option label="7xp64v.com2.z0.glb.qiniucdn.com"
	/**
	 * 替换资讯内容里面七牛图片的质量比
	 * 
	 * @param currentDate
	 * @param endDate
	 * @return String
	 */
	public static String InfoImg(String infoconcent, String ImgManage) {
		String re1 = "<img[^>]+src=\"([^\"]+)\"[^>]*>";
		Pattern p = Pattern.compile(re1, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(infoconcent);
		while (m.find()) {
			String url = m.group(1);
			if (!url.contains("7xp64v.com1.z0.glb.clouddn.com") && !url.contains("7xp64v.com2.z0.glb.clouddn.com")
					&& !url.contains("7xp64v.com2.z0.glb.qiniucdn.com") && !url.contains("7wy43g.com2.z0.glb.qiniucdn.com")) {
				continue;
			} else {
				if (url.contains(ImgManage)) {
					continue;
				} else {
					String urlnew = url + ImgManage;
					infoconcent = infoconcent.replace(url, urlnew);
					m = p.matcher(infoconcent);
				}
			}
		}
		return infoconcent;
	}
	
	/**
	 * 替换资讯内容里面七牛图片的质量比
	 * 
	 * @param currentDate
	 * @param endDate
	 * @return String
	 */
	public static String InfoImgNew(String infoconcent, String ImgManage) {
		//		String re1 = "<img\\Ssrc=\"([^\"]+)\"[^>]*>";
		//		String re1 = "<img.{0,}src=\"([^\"]+)\".{0,}\\/>";
		String re1 = "<img([^(/>)].){0,}src=\"([^\"]+)\"([^(/>)].){0,}/>";
		Pattern p = Pattern.compile(re1, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(infoconcent);
		while (m.find()) {
			String url = m.group(2);
			//			if(!url.contains("7xp64v.com1.z0.glb.clouddn.com")&&!url.contains("7xp64v.com2.z0.glb.clouddn.com")&&!url.contains("7xp64v.com2.z0.glb.qiniucdn.com")&&!url.contains("7wy43g.com2.z0.glb.qiniucdn.com")){
			//				continue;
			//			}else{
			
			//				if(url.contains(ImgManage)){
			//					continue;
			//				}else{
			String urlnew = "<p>" + url + "<p>";
			infoconcent = infoconcent.replace(m.group(0), urlnew);
			m = p.matcher(infoconcent);
			//				}
			//			}
		}
		return infoconcent;
	}
	
	public QiNiuUtils() {
		super();
	}
	
	public static void main(String args[]) throws IOException {
		//		QiNiuUtils.qiniuUploadPic("E:\\cm.jpg");
		//		System.out.println("Token-->> " + QiNiuUtils.getUpToken());
		//		System.out.println(QiNiuUtils.delete("20160624113719870727096.jpg"));
	}
	
}
