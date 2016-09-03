package cn.jxnu.dao;

import java.util.List;

import cn.jxnu.model.User;

public interface UserExtendMapper {
	User selectByUsername(String username);

	List<String> getRoles(String username);

	List<String> getPermissions(String username);
}
