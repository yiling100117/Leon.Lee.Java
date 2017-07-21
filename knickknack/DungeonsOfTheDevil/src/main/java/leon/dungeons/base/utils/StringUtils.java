package leon.dungeons.base.utils;

import java.util.UUID;

public class StringUtils {
	
	private StringUtils() {}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
