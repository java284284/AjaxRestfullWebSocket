package crm._init.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil_MySQL {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// 由組態檔(hibernate.cfg.xml)內的資訊來建立SessionFactory物件
			// Hibernate 5.x 的寫法
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("crm/_init/mysql/hibernateMySQL.cfg.xml").build();
			                    
			// 以下為Mapping檔的寫法
			MetadataSources sources = new MetadataSources(standardRegistry);
			Metadata metadata = sources.getMetadataBuilder().build();
			// 共同部分
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			System.out.println("SessionFactory Ready...");
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("新建SessionFactory失敗, " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close() {
		getSessionFactory().close();
	}

}