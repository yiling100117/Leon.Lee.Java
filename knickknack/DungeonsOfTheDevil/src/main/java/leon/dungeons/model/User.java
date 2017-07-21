package leon.dungeons.model;

public class User {

	private String		userId;

	private String		userName;

	private String		userNickname;

	private String		userPassword;

	private int			userLevel;		// 用户等级

	private UserTalents	userTalent;		// 用户的地图设置(陷阱)

	private UserMaps	userMaps;		// 用户拥有的地图

	public UserMaps getUserMaps() {
		return userMaps;
	}

	public void setUserMaps(UserMaps userMaps) {
		this.userMaps = userMaps;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public UserTalents getUserTalent() {
		return userTalent;
	}

	public void setUserTalent(UserTalents userTalent) {
		this.userTalent = userTalent;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	//是否为同一用户根据用户的id(userId)判断
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userNickname=" + userNickname + ", userPassword=" + userPassword
				+ ", userLevel=" + userLevel + ", userTalent=" + userTalent
				+ ", userMaps=" + userMaps + "]";
	}

}
