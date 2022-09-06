package ch04._02.dao.impl;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch04.Employee;
import ch04._02.service.impl.EmployeeDao;

@Repository
public class EmployeeDaoImpl_Hibernate implements EmployeeDao {
	
	@Autowired
	SessionFactory factory;
	
	public EmployeeDaoImpl_Hibernate(){ 
	
	}
	
	@Override
	public void save(Employee e) {
		Session session = factory.getCurrentSession();
		session.save(e);
		
	}
}
