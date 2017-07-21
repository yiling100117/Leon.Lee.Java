package leon.lee.utlis.match;

import java.text.DecimalFormat;

public class MatchUtlis {
	
	private MatchUtlis(){
		
	}
	
	/**
	 * <p>转换成三位小数点的浮点数
	 * 
	 * @param num 被计算的数
	 * @return
	 */
	public static double intToFloat(double num) {
		DecimalFormat df = new DecimalFormat("0.000");
		return Double.parseDouble(df.format(num));
	}

}
