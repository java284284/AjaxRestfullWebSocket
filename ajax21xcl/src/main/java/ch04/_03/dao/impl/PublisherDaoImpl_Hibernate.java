package ch04._03.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch04._03.dao.PublisherDao;
import ch04._03.model.PublisherBean;

@Repository
public class PublisherDaoImpl_Hibernate implements PublisherDao {
	
	@Autowired
	SessionFactory factory;

	public PublisherDaoImpl_Hibernate() { 	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PublisherBean> getAllPublisher() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PublisherBean";
		return session.createQuery(hql).getResultList();
	}

}
