package cn.jxnu.realm;

import java.util.HashSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.jxnu.dao.UserExtendMapper;
import cn.jxnu.model.User;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserExtendMapper userExtendMapper;

	/**
	 * 登录之后用于授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(new HashSet<>(userExtendMapper.getRoles(username)));
		authorizationInfo.setStringPermissions(new HashSet<>(userExtendMapper.getPermissions(username)));
		return authorizationInfo;
	}

	/**
	 * 用于验证身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userExtendMapper.selectByUsername(username);
		if (null != user) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "xx");
			return info; 
		}
		return null;
	}

}
