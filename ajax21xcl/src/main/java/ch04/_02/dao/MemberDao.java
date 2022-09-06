package ch04._02.dao;

import ch04._02.model.Member;

public interface MemberDao {

	String checkMemberId(String memberId);

	int saveMember(Member cb);

}