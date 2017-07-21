package leon.lee.utlis.special;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * 工具函数
 * 
 * @author zhangxj
 */
public class StringUtil1 {
	
	/***
	 * main函数
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		//		System.out.println("天数--》》 "+ daysBetween("2016-01-14",getCurrentTime("yyyy-MM-dd HH:mm:ss")));
		System.out.println("--" + getYesterday());
		//		int day = StringUtil.daysBetween(user.getCreateTime(),new Date());
	}
	
	/**
	 * 构造函数
	 */
	public StringUtil1() {
		super();
	}
	
	/**
	 * Used for 邮编验证
	 */
	public static boolean checkZipcode(String zipcode) {
		if (zipcode.matches("[1-9]\\d{5}(?!\\d)")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 获取异常的详细信息
	 * 
	 * @param e
	 *            异常
	 * @return 异常的详细信息
	 */
	public static String getExceptionDetail(Exception e) {
		StringBuffer sb = new StringBuffer();
		if (null != e) {
			StackTraceElement[] ste = e.getStackTrace();
			sb.append(e.getMessage() + "\n");
			for (int i = 0; i < ste.length; i++) {
				sb.append(ste[i].toString() + "\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * passwordToMD5把密码加密
	 * 
	 * @param password
	 *            输入的密码
	 * @return
	 */
	public static String passwordToMD5(String password) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return (buf.toString());
	}
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str) {
			return false;
		} else {
			if ("null".equals(str.trim()) || "".equals(str.trim())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	/*public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}*/
	
	/**
	 * 获得不带时分秒的系统当前时间
	 * 
	 * @return
	 */
	public static Long systemDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Long.parseLong(sdf.format(new Date()));
	}
	
	/**
	 * 获得系统带时分秒的系统当前时间
	 * 
	 * @return
	 */
	public static Long systemTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(sdf.format(new Date()));
	}
	
	/**
	 * 获得当前月的第一天
	 * 
	 * @return
	 */
	public static Long firstDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance(Locale.CANADA);
		c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
		return Long.parseLong(sdf.format(c.getTime()));
	}
	
	/**
	 * 获得昨天
	 * 
	 * @return
	 */
	public static Date getYesterday() {
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dBefore);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); //设置为前一天
		dBefore = calendar.getTime(); //得到前一天的时间
		return dBefore;
	}
	
	/**
	 * 获得当前年的一月一号
	 * 
	 * @return
	 */
	public static Long yearFirstDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance(Locale.CANADA);
		c.set(Calendar.DAY_OF_YEAR, c.getMinimum(Calendar.DAY_OF_YEAR));
		return Long.parseLong(sdf.format(c.getTime()));
	}
	
	/**
	 * 获取文件的扩展名
	 * 
	 * @param fileName
	 *            文件的名称
	 * @return
	 */
	public static String getExtension(String fileName) {
		return fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	/**
	 * 转换成三位小数点的浮点数
	 * 
	 * @param num
	 *            被计算的数
	 * @return
	 */
	public static float intToFloat(float num) {
		// 格式化小数
		DecimalFormat df = new DecimalFormat("0.000");
		return Float.parseFloat(df.format(num));
	}
	
	/**
	 * 电话
	 */
	public static Boolean checkPhone(String phone) {
		Pattern p = Pattern.compile("^[1][3-8]+\\d{9}");
		if (null == phone) {
			return false;
		} else {
			Matcher m = p.matcher(phone);
			Boolean b = m.matches();
			return b;
		}
	}
	
	/**
	 * UUID
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * string数组转int数组
	 * 
	 * @return int数组
	 * */
	public static Integer[] strToInt(String[] str) {
		Integer[] order_int = new Integer[str.length];
		for (int i = 0; i < str.length; i++) {
			order_int[i] = Integer.parseInt(str[i]);
		}
		return order_int;
	}
	
	/***
	 * String 转成Date
	 * 
	 * @throws ParseException
	 */
	public static Date strToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		return date;
	}
	
	/**
	 * 随机生成数字字符串 六位数验证码
	 * 
	 * @param length
	 * @return
	 */
	public static String randomInt(int length) {
		StringBuffer buff = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			buff.append(random.nextInt(10));
		}
		return buff.toString();
	}
	
	/**
	 * 13位时间戳
	 * 
	 * @return str
	 */
	public static String getOrderCode() {
		String currentTime = Long.toString(System.currentTimeMillis());
		return currentTime;
	}
	
	/**
	 * 17位时间字符串
	 * @return str
	 */
	public static String getSimpleDateFormatYyyyMMddHHmmssS() {
		String str = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date());// 使用时间作为要保存的文件名
		return str;
	}
	
	/**
	 * 获取format格式的时间
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}
	
	/**
	 * 两个字符串之间的间隔天数
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String currentDate, String endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(currentDate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(endDate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 获取两个日期之前有多少天
	 * 
	 * @param currentDate
	 * @param endDate
	 * @return
	 */
	public static int daysBetween(Date currentDate, Date endDate) {
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long between_days = 0;
		if (null == endDate) {
			return 10000;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endDate);
		long time2 = cal.getTimeInMillis();
		between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 新闻时间计算
	 * 
	 * @param newsTime
	 *            Rules 1分内 1分前...59分前 1小时前...23小时前 昨天 2天前 3天前...N天前
	 * @return String
	 */
	public static String newsTimeRulesForRrzx(String newsTime) {
		// 开始时间
		String timeStr = "";
		String formatStr = "yyyy-MM-dd HH:mm:ss";
		String currentTime = getCurrentTime(formatStr);
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(formatStr);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		float diff;
		float day = 0;
		float hour = 0;
		float min = 0;
		float sec = 0;
		// 获得两个时间的毫秒时间差异
		try {
			diff = sd.parse(currentTime).getTime() - sd.parse(newsTime).getTime();
			sec = diff / ns;// 计算相差多少秒
			if (sec < 59) {
				timeStr = "1分内";
			} else {
				min = diff / nm;// 计算差多少分钟
				if (min < 59) {
					timeStr = (int) min + "分前";
				} else {
					hour = diff / nh;// 计算差多少小时
					if (hour < 23) {
						timeStr = (int) hour + "小时前";
					} else {
						day = diff / nd;// 计算差多少天
						if (day < 2) {
							timeStr = "昨天";
						} else {
							timeStr = (int) day + "天前";
						}
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeStr;
	}
	
	/** 
	 * 随机指定范围内N个不重复的数 
	 * 最简单最基本的方法 
	 * @param min 指定范围最小值 
	 * @param max 指定范围最大值 
	 * @param n 随机数个数 
	 */
	public static int[] randomCommon(int min, int max, int n) {
		if (n > (max - min + 1) || max < min) {
			return null;
		}
		int[] result = new int[n];
		int count = 0;
		while (count < n) {
			int num = (int) (Math.random() * (max - min)) + min;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (num == result[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result[count] = num;
				count++;
			}
		}
		return result;
	}
	
}
