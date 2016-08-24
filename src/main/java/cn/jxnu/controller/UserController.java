package cn.jxnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.jxnu.model.User;
import cn.jxnu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/home")
	public ModelAndView home(Long id) {
		ModelAndView mav = new ModelAndView("user/home");
		mav.addObject("user", userService.selectByPK(null == id ? 1l : id));
		return mav;
	}

	@RequestMapping("/save")
	public ModelAndView save(User user) {
		ModelAndView mav = new ModelAndView("user/detail");
		userService.save(user);
		mav.addObject("user", userService.selectByPK(user.getId()));
		return mav;
	}

}
