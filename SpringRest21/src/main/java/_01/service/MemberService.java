package _01.service;

import java.util.List;

import _01.model.Member;

public interface MemberService {
	Member findByPrimaryKey(int key);

	Member findByName(String name);

	int saveMember(Member member);

	void updateMember(Member member);

	void deleteMemberByPrimaryKey(int key);

	List<Member> findAllMembers();

	void deleteAllMembers();

	public boolean isMemberExist(Member member);
	
	String checkMemberId(String memberId);

}
