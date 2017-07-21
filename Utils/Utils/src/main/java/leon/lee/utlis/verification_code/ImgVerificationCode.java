package leon.lee.utlis.verification_code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImgVerificationCode {
	
	// 验证码字符集
	private static final char[]	CODE_CHARS		= { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	// 字符数量
	private static final int	SIZE_NUMBER		= 4;
	// 干扰线数量
	private static final int	LINES_NUMBER	= 5;
	// 宽度
	private static final int	WIDTH			= 80;
	// 高度
	private static final int	HEIGHT			= 40;
	// 字体大小
	private static final int	FONT_SIZE		= 30;
	
	/**
	 * 生成随机验证码及图片
	 */
	public static Object[] createImage() {
		StringBuffer sb = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.LIGHT_GRAY);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE_NUMBER; i++) {
			// 取随机字符索引
			int n = ran.nextInt(CODE_CHARS.length);
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 设置字体大小
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			// 画字符
			graphic.drawString(CODE_CHARS[n] + "", i * WIDTH / LINES_NUMBER, HEIGHT / 2);
			// 记录字符
			sb.append(CODE_CHARS[n]);
		}
		// 6.画干扰线
		for (int i = 0; i < LINES_NUMBER; i++) {
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7.返回验证码和图片
		return new Object[] { sb.toString(), image };
	}
	
	/**
	 * 随机取色
	 */
	private static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
	/*public static void main(String[] args) throws IOException {
		Object[] objs = createImage();
		BufferedImage image = (BufferedImage) objs[1];
		OutputStream os = new FileOutputStream("d:/1.jpg");
		ImageIO.write(image, "jpeg", os);
		os.close();
	}*/
}
