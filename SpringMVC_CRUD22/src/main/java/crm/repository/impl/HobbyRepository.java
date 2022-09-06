package crm.repository.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.model.Hobby;

@Repository
public class HobbyRepository implements crm.repository.HobbyRepository {

	SessionFactory factory;

	@Autowired
	public HobbyRepository(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hobby> getAllHobbies() {
		String hql = "FROM Hobby";
		Session session = getSession();
		return session.createQuery(hql).getResultList();
	}

	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Hobby getHobby(Integer id) {
		Session session = getSession();
		return session.get(Hobby.class, id);
	}
}
