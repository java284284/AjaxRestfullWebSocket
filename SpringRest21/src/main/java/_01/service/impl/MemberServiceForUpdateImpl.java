package _01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import _01.dao.MemberDao;
import _01.model.Member;
import _01.service.MemberServiceForUpdate;

@Service
@Transactional
@EnableTransactionManagement
public class MemberServiceForUpdateImpl implements MemberServiceForUpdate {
    
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member findByPrimaryKey(int key) {
		return memberDao.findByPrimaryKey(key);
	}

	@Override
	public void evictMember(Member member) {
		memberDao.evictMember(member);
	}
}
