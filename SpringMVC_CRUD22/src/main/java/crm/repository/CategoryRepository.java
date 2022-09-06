package crm.repository;

import java.util.List;
import crm.model.Category;

public interface CategoryRepository {
	List<Category> getAllCategories();
	Category getCategory(Integer id);
}
