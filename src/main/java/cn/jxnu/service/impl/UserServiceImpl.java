package cn.jxnu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxnu.dao.UserMapper;
import cn.jxnu.model.User;
import cn.jxnu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByPK(long id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public void save(User user) {
		userMapper.insertSelective(user);
	}

}
