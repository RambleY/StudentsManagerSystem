package service;

import entity.Users;

/**
 * @author Administrator
 * �û�ҵ���߼��ӿ�
 */
public interface UsersDAO {
	
	//�û���½����
	public boolean userLogin(Users u);
	
	//�û�ע��
	public boolean userRegiste(Users u);
}
