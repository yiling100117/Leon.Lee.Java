package leon.dungeons.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import leon.dungeons.base.constant.BaseConstant;
import leon.dungeons.base.constant.InitConstant;
import leon.dungeons.model.User;
import leon.dungeons.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService		userService;

	private ModelAndView	mv	= new ModelAndView();

	@RequestMapping("register")
	public ModelAndView Register(HttpServletRequest request) {
		mv.clear();
		System.out.println("register");

		// 此处用户输入数据的处理

		// 创建用户
		User user = userService.createUser(InitConstant.USER_ARG);

		// 放入session
		request.getSession().setAttribute(BaseConstant.LOGIN_INFO, user);

		//注册完成，返回新手指引
		
		return mv;
	}
}
