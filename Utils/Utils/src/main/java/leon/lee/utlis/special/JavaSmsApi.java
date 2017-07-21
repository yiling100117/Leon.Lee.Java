package leon.lee.utlis.special;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * <p>Used for 短信http接口的java代码调用示例 基于Apache HttpClient 4.3
 * @author zhangxj
 * 2015年8月10日 下午5:55:51   
 *
 */
@SuppressWarnings("unused")
public class JavaSmsApi {
	
	private static String	company			= "人人知讯";
	
	private static String	apikey			= "02029f73c4b05fc94eb30b9b097ac421";
	/**
	 * 服务http地址
	 */
	private static String	BASE_URI		= "http://yunpian.com";
	/**
	 * 服务版本号
	 */
	private static String	VERSION			= "v1";
	/**
	 * 通用发送接口的http地址
	 */
	private static String	URI_SEND_SMS	= BASE_URI + "/" + VERSION + "/sms/send.json";
	// 编码格式。发送编码格式统一用UTF-8
	private static String	ENCODING		= "UTF-8";
	
	// /**
	// * 查账户信息的http地址
	// */
	// private static String URI_GET_USER_INFO = BASE_URI + "/" + VERSION +
	// "/user/get.json";
	/**
	 * 模板发送接口的http地址
	 */
	// private static String URI_TPL_SEND_SMS = BASE_URI + "/" + VERSION +
	// "/sms/tpl_send.json";
	/**
	 * 通用接口发短信
	 * @param apikey
	 * @param text    短信内容
	 * @param mobile  接受的手机号
	 * @return json格式字符串
	 */
	/*public static String sendSms(String text, String mobile) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("text", text);
		params.put("mobile", mobile);
		return post(URI_SEND_SMS, params);
	}*/
	public static void main(String[] args) throws IOException, URISyntaxException {
		// 修改为您要发送的手机号
		String mobile = "18435121559";
		String text = "【云片网】您的验证码是1234";
		// 发短信调用示例
		/**************** 使用通用接口发短信(推荐) *****************/
		/*System.out.println(JavaSmsApi.sendSms(text, mobile));*/
		/**************** 查账户信息调用示例 *****************/
		// System.out.println(JavaSmsApi.getUserInfo(apikey));
		
		// 设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
		/**************** 使用模板接口发短信(不推荐，建议使用通用接口) *****************/
		// 设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
		// 设置对应的模板变量值
		// 如果变量名或者变量值中带有#&=%中的任意一个特殊符号，需要先分别进行urlencode编码
		// 如code值是#1234#,需作如下编码转换
		/**
		 * long tpl_id = 1; String codeValue = URLEncoder.encode("#1234#",
		 * ENCODING); String tpl_value = "#code#=" + codeValue +
		 * "&#company#=云片网"; // 模板发送的调用示例
		 * System.out.println(JavaSmsApi.tplSendSms(apikey, tpl_id, tpl_value,
		 * mobile));
		 */
	}
	
	/**
	 * 取账户信息
	 * 
	 * @return json格式字符串
	 * @throws java.io.IOException
	 */
	// public static String getUserInfo(String apikey) throws IOException,
	// URISyntaxException {
	// Map<String, String> params = new HashMap<String, String>();
	// params.put("apikey", apikey);
	// return post(URI_GET_USER_INFO, params);
	// }
	
	/**
	 * 通过模板发送短信(不推荐)
	 * 
	 * @param mobile
	 *            接受的手机号
	 * @param radomStr
	 *            验证码
	 * @return
	 * @throws IOException
	 */
	// public static String tplSendSms(String radomStr, String mobile) throws
	// IOException{
	// //设置模板ID，如使用1号模板:您的验证码是#code#【#company#】
	// long tpl_id=1;
	// //设置对应的模板变量值
	// String tpl_value = "#code#=" + radomStr + "&#company#=" + company;
	// Map<String, String> params = new HashMap<String, String>();
	// params.put("apikey", apikey);
	// params.put("tpl_id", String.valueOf(tpl_id));
	// params.put("tpl_value", tpl_value);
	// params.put("mobile", mobile);
	// return post(URI_TPL_SEND_SMS, params);
	// }
	
	/**
	 * 通过模板发送短信(不推荐)
	 * 
	 * @param apikey
	 *            apikey
	 * @param tpl_id
	 *            　模板id
	 * @param tpl_value
	 *            　模板变量值
	 * @param mobile
	 *            　接受的手机号
	 * @return json格式字符串
	 * @throws IOException
	 */
	// public static String tplSendSms(String apikey, long tpl_id, String
	// tpl_value, String mobile) throws IOException {
	// Map<String, String> params = new HashMap<String, String>();
	// params.put("apikey", apikey);
	// params.put("tpl_id", String.valueOf(tpl_id));
	// params.put("tpl_value", tpl_value);
	// params.put("mobile", mobile);
	// return post(URI_TPL_SEND_SMS, params);
	// }
	
	/**
	 * 基于HttpClient 4.3的通用POST方法
	 * 
	 * @param url
	 *            提交的URL
	 * @param paramsMap
	 *            提交<参数，值>Map
	 * @return 提交响应
	 */
	/*public static String post(String url, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(url);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
			}
			response = client.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}*/
}
