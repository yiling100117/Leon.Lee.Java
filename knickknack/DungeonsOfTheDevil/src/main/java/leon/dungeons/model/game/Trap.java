package leon.dungeons.model.game;

import java.util.Random;

/**
 * 
 **************************************************
 *
 * @deprecated:		表示一个陷阱(用户设置的地物)
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月17日 上午11:16:21
 * 
 **************************************************
 *
 */
public class Trap {

	private int trapType;

	private int x;

	private int y;
	
	public Trap() {
		Random ran=new Random();
		x=ran.nextInt(10);
		y=ran.nextInt(10);
		trapType=0;
	}

	public int getTrapType() {
		return trapType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
