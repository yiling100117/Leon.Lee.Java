package leon.lee.utlis.special;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;



public class JDBCUtils {
	
	private JDBCUtils(){
		
	}
	
	/**
	 * <p>判断链接状态
	 * 
	 * @param url：用于打印日志
	 * @param conn：待判断的链接
	 * @return 返回一个boolean值，如果链接状态码为200返回true，否则返回false
	 *
	 * @author ly
	 * @date 2017年2月22日 下午3:46:50
	 */
	public boolean getConStatus(String url, Connection conn){
		try {
			Response response=conn.execute();
			if(response.statusCode()==200){
				return true;
			}
		} catch (IOException e) {
			System.out.println("链接网站：“"+url+"”出现了异常");
			e.printStackTrace();
		}finally{
		}
		return false;		
	}
}
