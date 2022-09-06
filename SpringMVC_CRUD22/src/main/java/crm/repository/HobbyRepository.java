package crm.repository;

import java.util.List;
import crm.model.Hobby;

public interface HobbyRepository {
	List<Hobby> getAllHobbies();
	Hobby getHobby(Integer id);
}
