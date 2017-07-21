package leon.dungeons.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leon.dungeons.base.constant.InitConstant;
import leon.dungeons.dao.UserMapper;
import leon.dungeons.model.User;
import leon.dungeons.model.abst.MapAbst;
import leon.dungeons.service.UserService;
import leon.special.instance.factory.BaseFactoryMethod;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	// 创建(注册)用户
	@Override
	public User createUser(Map<String, Object> argMap) {
		User user = null;
		try {
			// 工厂模式创建用户
			user = BaseFactoryMethod
					.getInstance(Class.forName(InitConstant.USER_CLZ), argMap);
		} catch (ClassNotFoundException e) {
			// 此处返回错误信息
			e.printStackTrace();
		}

		// 用户数据插入数据库
		userMapper.createUser(user);

		// 返回的用户对象用于保存登录信息
		return user;
	}

	// 读取用户所有的地图
	@Override
	public List<MapAbst> lodingUserMap(String userId) {
		return userMapper.lodingUserMap(userId);
	}

}
