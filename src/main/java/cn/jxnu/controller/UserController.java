package cn.jxnu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.jxnu.model.User;
import cn.jxnu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查询id=1的user
	 * @param id
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView home(Long id) {
		ModelAndView mav = new ModelAndView("user/home");
		mav.addObject("user", userService.selectByPK(null == id ? 1l : id));
		return mav;
	}

	/**
	 * 新增一个user
	 * @param user
	 * @return
	 */
	@RequestMapping("/save")
	public ModelAndView save(User user) {
		ModelAndView mav = new ModelAndView("user/detail");
		userService.save(user);
		mav.addObject("user", userService.selectByPK(user.getId()));
		return mav;
	}

	/**
	 * 跳转到登录页面
	 * @param msg 用来传递消息
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(String msg, Model model) {
		model.addAttribute("msg", msg);
		return "login";
	}

	/**
	 * 登录功能
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Model model) {
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			model.addAttribute("errorMsg", "登录失败");
			return "login";
		}
	}
}
