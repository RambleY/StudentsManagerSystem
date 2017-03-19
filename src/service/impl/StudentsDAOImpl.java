package service.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.MyHibernateSessionFactory;
import entity.HibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;
/**
 * @author Administrator
 * ѧ����ҵ���߼��ӿ�ʵ����
 */
public class StudentsDAOImpl implements StudentsDAO {

	
	/* (non-Javadoc)
	 * @see service.StudentsDAO#queryAllStudents()
	 * ��ѯ����ѧ��
	 */
	@Override
	public List<Students> queryAllStudents() {
		Transaction tx = null;
		String hql = "";
		List<Students> list = null;
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();//��������
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();//�ύ����
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if(tx != null)
				tx = null;
		}
	}

	@Override
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see service.StudentsDAO#addStudents(entity.Students)
	 * ����һ����¼
	 */
	@Override
	public boolean addStudents(Students s) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();//��������
			hql = "Delete from Students where sid=?";
			Query query = session.createQuery(hql);
			query.setString(0, sid);
			query.executeUpdate();
			tx.commit();//�ύ����
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if(tx != null)
				tx = null;
		}
	}
}
