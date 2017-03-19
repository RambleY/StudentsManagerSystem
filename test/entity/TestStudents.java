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
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// 创建Session对象
		// Session session = sessionFactory.getCurrentSession();

		// 创建SchemExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}

	@Test
	public void testSaveStudents() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建SessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// 创建Session对象
		Session session = sessionFactory.getCurrentSession();
		// 创建事务
		Transaction tx = session.beginTransaction();
		
		Students stu1 = new Students("S0000001","张三丰","男",new Date(),"武当山");
		Students stu2 = new Students("S0000002","郭靖","男",new Date(),"桃花岛");
		Students stu3 = new Students("S0000003","黄蓉","女",new Date(),"桃花岛");
		
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		
		tx.commit();
		sessionFactory.close();
		
	}
}
