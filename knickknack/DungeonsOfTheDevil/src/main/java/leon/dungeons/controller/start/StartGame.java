package leon.dungeons.controller.start;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import leon.base.utils.BaseUtils;
import leon.base.utils.string.StringUtils;
import leon.dungeons.base.constant.BaseConstant;
import leon.dungeons.base.constant.InitConstant;
import leon.dungeons.model.User;
import leon.dungeons.model.UserMaps;
import leon.dungeons.model.abst.MapAbst;
import leon.dungeons.model.game.GameMap;
import leon.dungeons.model.game.Trap;
import leon.dungeons.service.UserService;
import leon.dungeons.test.Traps;
import leon.special.instance.factory.BaseFactoryMethod;

@Controller
@RequestMapping("start")
public class StartGame {

	private ModelAndView	mv		= new ModelAndView();

	private StartUtils		utils	= new StartUtils();

	@Resource
	private UserService		userService;

	@RequestMapping("startGame")
	public ModelAndView startGame() {
		mv.clear();

		// 此处判断登录
		User user = null;
		try {
			Map<String, Object> argMap1 = new HashMap<String, Object>();
			argMap1.put("userId", "2db394e8ed6d4fe5b04b4596cff87ed2");
			Map<String, Object> argMap2 = new HashMap<String, Object>();
			argMap2.put("userMap1", "1");
			UserMaps userMaps = BaseFactoryMethod.getInstance(
					Class.forName("leon.dungeons.model.UserMaps"), argMap2);
			argMap1.put("userMaps", userMaps);
			user = BaseFactoryMethod
					.getInstance(Class.forName("leon.dungeons.model.User"), argMap1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 判断用户登录完成

		// 读取用户的地图，并将其存放在缓存中
		lodingMaps(user.getUserId());

		// 将用户主地图返回页面显示
		MapAbst map = utils.getCacheMap(user.getUserMaps().getUserMap1());
		mv.addObject("map", new Gson().toJson(map));
		mv.setViewName("jsp/GameMap");
		return mv;
	}

	@ResponseBody
	@RequestMapping("getTrap")
	public String getTrap(HttpServletRequest request) {
		mv.clear();
		String mapNo = request.getParameter("mapNo");
		System.out.println(mapNo);

		// 这里应该从数据库中查出对应地图的陷阱json，没有返回空
		Traps traps = new Traps(2);
		Trap[] trapArr = traps.getTraps();
		for (int i = 0; i < trapArr.length; i++) {
			System.out.println("x:" + trapArr[i].getX() + ";y:" + trapArr[i].getY());
		}
		// 这里应该从数据库中查出对应地图的陷阱json，没有返回空

		return new Gson().toJson(traps);
	}

	private void lodingMaps(String userId) {
		// 读取用户地图
		List<MapAbst> mapList = userService.lodingUserMap(userId);

		boolean flag = false;// 用来判断是用户是否一张地图都没有

		// 将非空地图置入缓存
		for (MapAbst gameMap : mapList) {
			if (!BaseUtils.isEmpty(gameMap)) {
				utils.cacheMap(gameMap);
				flag = true;
			}
		}

		// 用户一张地图都没有
		if (!flag) {
			GameMap map = null;
			// 创建地图
			try {
				map = BaseFactoryMethod
						.getInstance(Class.forName(InitConstant.GAME_MAP_CLZ),
								GameMap.getArgMap(BaseConstant.MAP_HEIGHT,
										BaseConstant.MAP_WIDTH,
										StringUtils.getUUID32()));
			} catch (ClassNotFoundException e) {
				// 返回错误信息
				e.printStackTrace();
			}
			System.out.println(map);
			// 插入数据库

		}
	}
}
