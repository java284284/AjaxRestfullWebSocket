package crm.service;

import java.util.List;

import crm.model.Category;

public interface CategoryService {
	List<Category> getAllCategories();
	Category getCategory(Integer id);
}
