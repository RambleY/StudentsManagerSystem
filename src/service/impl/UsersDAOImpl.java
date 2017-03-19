package service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.MyHibernateSessionFactory;
import entity.HibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	/* (non-Javadoc)
	 * @see service.UsersDAO#userLogin(entity.Users)
	 * 用户登陆验证
	 */
	@Override
	public boolean userLogin(Users u) {

		// 事物对象
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();//开启事务
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setString(0, u.getUsername());
			query.setString(1, u.getPassword());
			
			
			List list = query.list();
			tx.commit();//提交事务
			// 如果在数据库中查询不到用户名和密码返回false
			if (list.isEmpty())
				return false;
			else
				return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			if (tx != null) {
				
				tx = null;
			}
		}
	}

	/* (non-Javadoc)
	 * @see service.UsersDAO#userRegiste(entity.Users)
	 * 用户注册
	 */
	@Override
	public boolean userRegiste(Users u) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		return true;
		
	}

}
