package crm.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import crm.model.Member;
import crm.repository.MemberRepository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	SessionFactory factory;

	@Autowired
	public MemberRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(Member member) {
		Session session = getSession();
		session.save(member);
	}

	@Override
	public void delete(Integer id) {
		Session session = getSession();
		Member member = get(id);
		if (member != null) {
			member.setCategory(null);
			member.setHobby(null);
			session.delete(member);
		}
	}

	@Override
	public void update(Member member) {
		if (member != null && member.getId() != null) 	{
			Session session = getSession();
			session.saveOrUpdate(member);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> getAll() {
		String hql = "FROM Member";
		Session session = getSession();
		List<Member> list = session.createQuery(hql).getResultList();
		return list;
	}

	public Session getSession() {
        return factory.getCurrentSession();			
	}

	@Override
	public Member get(Integer id) {
		return factory.getCurrentSession().get(Member.class, id);
	}
}
