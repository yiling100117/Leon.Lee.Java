package leon.lee.utils.sting.string_utils_test;

import leon.lee.utlis.string.StringUtils;

public class GetUUIDTest {
	
	public static void main(String[] args) {
		String uuid = StringUtils.getUUID32();
		System.out.println("uuid:"+uuid);
		System.out.println("uuid的长度:"+uuid.length());
	}
	
}
