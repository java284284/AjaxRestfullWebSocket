package ch04._02.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch04._02.dao.MemberDao;
import ch04._02.model.Member;

@Repository
public class MemberDaoImpl_Hibernate implements MemberDao {
	
	@Autowired
	SessionFactory factory;
	
	public MemberDaoImpl_Hibernate() throws NamingException, SQLException { 
	
	}
	@SuppressWarnings("unchecked")
	@Override
	public String checkMemberId(String memberId) {
		String hql = "FROM Member m WHERE m.id = :id";
		String id = ""; 
		
		Session session = factory.getCurrentSession();
		
		List<Member> list = session.createQuery(hql)
								   .setParameter("id", memberId)
								   .getResultList();
		if (!list.isEmpty()) {
			id = list.get(0).getId();
		}
		
		return id;
	}
	@Override
	public int saveMember(Member member) {
		Session session = factory.getCurrentSession();
		session.save(member);
		return 1;
	}
}
