package ch04._02.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch04._02.dao.MemberDao;
import ch04._02.model.Member;
import ch04._02.service.MemberService;

@Service
public class  MemberServiceImpl implements MemberService {
	
	@Autowired
    MemberDao dao;
    
	public MemberServiceImpl() {
	
	}
	@Transactional
	@Override
	public String checkMemberId(String id) {
		return dao.checkMemberId(id);
	}
	@Transactional
	@Override
	public int saveMember(Member bean) {
		
		String id = checkMemberId(bean.getId());
		if (id.length() > 0) {
			return -1;
		}
		return dao.saveMember(bean);
	}
	

}
