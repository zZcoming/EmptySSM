package cn.jxnu.service;

import cn.jxnu.model.User;

public interface UserService {
	User selectByPK(long id);

	void save(User user);
}