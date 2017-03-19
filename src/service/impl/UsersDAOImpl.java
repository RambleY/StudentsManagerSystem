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
	 * �û���½��֤
	 */
	@Override
	public boolean userLogin(Users u) {

		// �������
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();//��������
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setString(0, u.getUsername());
			query.setString(1, u.getPassword());
			
			
			List list = query.list();
			tx.commit();//�ύ����
			// ��������ݿ��в�ѯ�����û��������뷵��false
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
	 * �û�ע��
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
