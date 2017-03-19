package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Ignore;
import org.junit.Test;

public class TestStudents {

	@Ignore
	public void testSchemExport() {
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// ����SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// ����Session����
		// Session session = sessionFactory.getCurrentSession();

		// ����SchemExport����
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}

	@Test
	public void testSaveStudents() {
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// ����SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// ����Session����
		Session session = sessionFactory.getCurrentSession();
		// ��������
		Transaction tx = session.beginTransaction();
		
		Students stu1 = new Students("S0000001","������","��",new Date(),"�䵱ɽ");
		Students stu2 = new Students("S0000002","����","��",new Date(),"�һ���");
		Students stu3 = new Students("S0000003","����","Ů",new Date(),"�һ���");
		
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		
		tx.commit();
		sessionFactory.close();
		
	}
}
