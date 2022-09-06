package crm.service;

import java.util.List;
import crm.model.Hobby;

public interface HobbyService {
	List<Hobby> getAllHobbies();
	Hobby getHobby(Integer id);
}

