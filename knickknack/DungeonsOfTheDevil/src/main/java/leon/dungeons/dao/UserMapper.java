package leon.dungeons.dao;

import java.util.List;

import leon.dungeons.model.User;
import leon.dungeons.model.abst.MapAbst;

public interface UserMapper {

	//创建(注册)用户
	void createUser(User user);

	//读取用户所属地图
	List<MapAbst> lodingUserMap(String userId);

}
