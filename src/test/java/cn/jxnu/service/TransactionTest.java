package cn.jxnu.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxnu.base.BaseTest;
import cn.jxnu.model.User;

public class TransactionTest extends BaseTest{

	@Autowired
	private UserService userService;
	
	@Test
	public void transactionTest() {
		// 在测试前，将 cn.jxnu.service.impl.UserServiceImpl.save(User) 中注释的代码去掉注释
		User user = new User();
		user.setUsername("transaction_test");
		user.setPassword("test");
		user.setAge(10);
		userService.save(user);
		System.out.println(userService.selectByPK(user.getId()));
	}
}
