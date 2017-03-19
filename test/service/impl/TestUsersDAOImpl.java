package service.impl;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import service.UsersDAO;
import entity.Users;

public class TestUsersDAOImpl {

	@Ignore
	public void testUserLogin() {
		Users u = new Users(1,"yh","123456");
		UsersDAO udao = new UsersDAOImpl();
		//¶ÏÑÔ»úÖÆ
		Assert.assertEquals(true,udao.userLogin(u));
		
	}
	@Test
	public void testUserRegiste() {
		Users u = new Users(0,"zz","123456");
		UsersDAO udao = new UsersDAOImpl();
		udao.userRegiste(u);
	}
}
