package crm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.model.Category;
import crm.repository.CategoryRepository;
import crm.service.CategoryService;
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
	CategoryRepository categoryDao;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	public Category getCategory(Integer id) {
		return categoryDao.getCategory(id);
	}

}
