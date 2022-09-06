package crm.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import crm.model.Member;

@Repository
public interface MemberService {
	void save(Member member);
	void delete(Integer id);
	Member get(Integer id);
	void update(Member member);
	List<Member> getAllMembers();
	
}
