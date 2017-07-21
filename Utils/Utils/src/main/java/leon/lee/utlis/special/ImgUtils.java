package leon.lee.utlis.special;

import leon.lee.utlis.string.StringUtils;

/**
 * <p>特殊情况使用的工具类，待通用化
 * 
 * @author LeonLee
 *
 */
public class ImgUtils {
	
	private ImgUtils(){
		
	}
	
	/**
	 * <p>从信息中取出第一张图片，如果没有图片则返回字符串“null”
	 * 
	 * <p>若任一参数为空参数(空字符串或空数组)则返回null
	 * 
	 * <p>若任一参数为null则返回null
	 * 
	 * @param oldString
	 *            原字符串
	 * @param index
	 *            带去除的特殊字符
	 * @return 处理后的字符串
	 *
	 * @author ly
	 * @date 2017年2月3日 下午6:13:26
	 */
	public static String cutImgWithIntrod(String introduction,String[] imgType){
		if(introduction!=null&&imgType!=null){
			String include = StringUtils.includeOneOfArray(introduction, imgType);
			int index = introduction.indexOf("<img src=\"http://");
			if(include!=null&&index>-1){
				String result = introduction.substring(
						index,
						introduction.indexOf(include));
				return (result+include).replace("<img src=\"", "");
			}
		}
		return "null";
	}
	
	
	/*private boolean flag=false;//addBrBeforImg方法使用的标记
	
	*//**
	 * <p>详细信息设置添加标签和样式
	 * 
	 * @param introduction
	 *            （详细内容）
	 * @return
	 *//*
	public String addBrBeforImg(String introduction) {
		String result="";
		//默认图片
		String img="";
		if(introduction.indexOf("<img src=\"http://")!=-1){
			flag=true;
			String a1 = introduction.substring(0,introduction.indexOf("<img src=\"http://"));
			String a2 = introduction.substring(introduction.indexOf("<img src=\"http://"),introduction.indexOf("\"/>"));
			a2+="?imageView2"+"\">";
			String a3 = introduction.substring(introduction.indexOf("\"/>")+3);
			if(a1.indexOf("<br/>")==-1){
				result=a1+"<br/><div align=\"center\" style=\"margin-right:3%\">"+a2+"</div>"+addBrBeforImg(a3);
			}
		}
		//没有图片时末尾添加默认图片
		if(introduction.indexOf("<img src=\"http://")<0 && !flag){
			result=introduction+"<br/><div align=\"center\" style=\"margin-right:3%\">"+img+"</div>";
		}
		flag=false;
		return result;
	}
	
	
	

	*//**
	 * <p>去除html标签
	 * @param htmlStr
	 * @return
	 *//*
	 public String delHTMLTag(String htmlStr){ 
	        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
	        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
	        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
	        String regEx_img="http:(\\s|\\S)*.(jpg|gif|png|jpge)[1-9]?[0-9]?";
	         
	        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
	        Matcher m_script=p_script.matcher(htmlStr); 
	        htmlStr=m_script.replaceAll(""); //过滤script标签 
	         
	        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
	        Matcher m_style=p_style.matcher(htmlStr); 
	        htmlStr=m_style.replaceAll(""); //过滤style标签 
	         
	        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
	        Matcher m_html=p_html.matcher(htmlStr); 
	        htmlStr=m_html.replaceAll(""); //过滤html标签 
	        Pattern p_img=Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE); 
	        Matcher m_img=p_img.matcher(htmlStr); 
	        htmlStr=m_img.replaceAll(""); //过滤html标签 

	        return htmlStr.trim(); //返回文本字符串 
	 } 
	 
	 *//**
	  * <p>图片防盗链替换
	  *//*
	 public String tiHuan(String text){
		 String text1=text.replaceAll("src=\"http:([\\s|\\S]{0,221})urlString=", "src=\"");
		 return text1;
	 }
	 
	 
	 public String telChange(String tel){
		 tel=tel.replaceAll("-", "").replaceAll("—", "");
		 return tel;
	 }*/
}
