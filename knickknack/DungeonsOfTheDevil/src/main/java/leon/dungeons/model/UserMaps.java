package leon.dungeons.model;

/**
 * 
 **************************************************
 *
 * @deprecated:		用户所有的三张地图
 *
 *
 * @author:			Leon
 * @version:		1.0
 * @date:			2017年7月17日 上午11:07:44
 * 
 **************************************************
 *
 */
public class UserMaps {

	private String	userMap1;

	private String	userMap2;

	private String	userMap3;

	public String getUserMap1() {
		return userMap1;
	}

	public void setUserMap1(String userMap1) {
		this.userMap1 = userMap1;
	}

	public String getUserMap2() {
		return userMap2;
	}

	public void setUserMap2(String userMap2) {
		this.userMap2 = userMap2;
	}

	public String getUserMap3() {
		return userMap3;
	}

	public void setUserMap3(String userMap3) {
		this.userMap3 = userMap3;
	}

	@Override
	public String toString() {
		return "UserMaps [userMap1=" + userMap1 + ", userMap2=" + userMap2
				+ ", userMap3=" + userMap3 + "]";
	}

}
