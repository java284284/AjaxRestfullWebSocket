package _01.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import _01.model.Member;

@Repository
public interface MemberDao {
	Member findByPrimaryKey(int key);

	Member findByName(String name);

	int saveMember(Member member);

	void updateMember(Member member);

	void deleteMemberByPrimaryKey(int key);

	List<Member> findAllMembers();

	void deleteAllMembers();

	public boolean isMemberExist(Member member);
	
	public String checkMemberId(String memberId);

	void evictMember(Member member);
}
