package leon.dungeons.service;

import java.util.List;
import java.util.Map;

import leon.dungeons.model.User;
import leon.dungeons.model.abst.MapAbst;

public interface UserService {

	// 创建(注册)用户
	User createUser(Map<String,Object> argMap);

	// 读取用户所有的地图
	List<MapAbst> lodingUserMap(String string);

}
