package action;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	
	private static final long serialVersionUID = 1L;
	private Users users = new Users();
	
	/**
	 * @return
	 * 用户登陆验证
	 */
	public String login() {
		UsersDAO udao = new UsersDAOImpl();
		if(udao.userLogin(users)) {
			//在session中保存登陆成功的用户名
			session.setAttribute("loginUserName", users.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	public String registe() {
		
		UsersDAO udao = new UsersDAOImpl();
		udao.userRegiste(users);
		return SUCCESS;
	}
	
	@Override
	public Users getModel() {
		
		return this.users;
	}
}
