package crm.repository.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.model.Category;
import crm.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	SessionFactory factory;
	
	@Autowired
	public CategoryRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		String hql = "FROM Category";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}

	@Override
	public Category getCategory(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Category.class, id);
	}
}
