package _01.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _01.dao.MemberDao;
import _01.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SessionFactory factory;

	@Override
	public Member findByPrimaryKey(int key) {
		Session session = factory.getCurrentSession();
		Member member = session.get(Member.class, key);
		return member;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Member findByName(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Member WHERE name=:name";
		Member member = null;
		List<Member> list = session.createQuery(hql).setParameter("name", name).getResultList();
		if (!list.isEmpty())
			member = list.get(0);
		return member;
	}

	@Override
	public int saveMember(Member member) {
		int n = 0;
		boolean exist = isMemberExist(member);
		if (exist) {
			return -1;
		}
		Session session = factory.getCurrentSession();
		try {
			session.save(member);
			n = 1;
		} catch (Exception e) {
			n = -2;
		}
		return n;
	}

	@Override
	public void updateMember(Member member) {
		Session session = factory.getCurrentSession();
		session.update(member);

	}
	
	@Override
	public void evictMember(Member member) {
		Session session = factory.getCurrentSession();
		session.evict(member);

	}

	@Override
	public void deleteMemberByPrimaryKey(int key) {
		Session session = factory.getCurrentSession();
		Member member = new Member();
		member.setPk(key);
		session.delete(member);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findAllMembers() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Member";
		List<Member> list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void deleteAllMembers() {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM Member";
		session.createQuery(hql).executeUpdate();
	}

	@Override
	public boolean isMemberExist(Member member) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		String hql = "FROM Member m WHERE m.id=:id";
		try {
			session.createQuery(hql).setParameter("id", member.getId()).getSingleResult();
			exist = true;
		} catch (NoResultException ex) {
			;
		}
		return exist;
	}

	@Override
	public String checkMemberId(String memberId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Member m WHERE m.id = :id";
		String id = "";
		try {
			Member m = (Member) session.createQuery(hql).setParameter("id", memberId).getSingleResult();
			id = m.getId();
		} catch (NoResultException ex) {
			;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			id = "Error: 資料庫異常，請檢查資料庫";
		}
		return id;
	}
}
