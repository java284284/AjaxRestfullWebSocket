package ch04._02.service;

import ch04.Employee;
import ch04._02.model.Member;

public interface MemberService {
	String checkMemberId(String memberId);

	int saveMember(Member cb);
	
}
