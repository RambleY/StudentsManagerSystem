package service;

import entity.Users;

/**
 * @author Administrator
 * 用户业务逻辑接口
 */
public interface UsersDAO {
	
	//用户登陆方法
	public boolean userLogin(Users u);
	
	//用户注册
	public boolean userRegiste(Users u);
}
