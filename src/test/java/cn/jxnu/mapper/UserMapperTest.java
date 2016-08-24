package cn.jxnu.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxnu.base.BaseTest;
import cn.jxnu.dao.UserMapper;

public class UserMapperTest extends BaseTest{

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelect() {
		System.out.println(userMapper.selectByPrimaryKey(1l));
	}
}
