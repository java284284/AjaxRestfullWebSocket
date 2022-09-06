package _01.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import _01.dao.MemberDao;
import _01.model.Member;
import _01.service.MemberService;

@Service
@Transactional
@EnableTransactionManagement
public class MemberServiceImpl implements MemberService {
    
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member findByPrimaryKey(int key) {
		return memberDao.findByPrimaryKey(key);
	}

	@Override
	public Member findByName(String name) {
		return memberDao.findByName(name);
	}

	@Override
	public int saveMember(Member member) {
		member.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		member.setExtra("測試用");
		int n = memberDao.saveMember(member);
		return n;
	}

	@Override
	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}

	@Override
	public void deleteMemberByPrimaryKey(int key) {
		memberDao.deleteMemberByPrimaryKey(key);
	}

	@Override
	public List<Member> findAllMembers() {
		return memberDao.findAllMembers();
	}

	@Override
	public void deleteAllMembers() {
		memberDao.deleteAllMembers();
	}

	@Override
	public boolean isMemberExist(Member member) {
		return memberDao.isMemberExist(member);
	}

	@Override
	public String checkMemberId(String memberId) {
		return memberDao.checkMemberId(memberId);
	}

}
