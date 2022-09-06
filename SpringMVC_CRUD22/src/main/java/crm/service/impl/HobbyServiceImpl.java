package crm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.model.Hobby;
import crm.repository.HobbyRepository;
import crm.service.HobbyService;
import java.util.List;
@Service
@Transactional
public class HobbyServiceImpl implements HobbyService {

	HobbyRepository hobbyDao;
	
	@Autowired
	public HobbyServiceImpl(HobbyRepository hobbyDao) {
		this.hobbyDao = hobbyDao;
	}

	@Override
	public List<Hobby> getAllHobbies() {
		return hobbyDao.getAllHobbies();
	}

	@Override
	public Hobby getHobby(Integer id) {
		return hobbyDao.getHobby(id);
	}

}
