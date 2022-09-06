package _01.service;

import _01.model.Member;

public interface MemberServiceForUpdate {
	Member findByPrimaryKey(int key);
	
	void evictMember(Member member);

}
