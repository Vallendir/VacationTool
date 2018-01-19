package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import vt.db.controller.dao.interfaces.IEmployee;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Employee;
import vt.db.model.util.HibernateUtil;

public class EmployeeDao extends GenericDao<Employee> implements IEmployee {
	
	
	public EmployeeDao() {
		super();
	}
	
	
	@Override
	public Employee findByLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		Employee employee = null;
		
		try {
			criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("empEvidenceNumber", login));
			
			employee = (Employee) criteria.list().get(0);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return employee;
	}
	
	@Override
	public Employee findByIdNameSurname(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = null;
		
		try {
			List results = session.createCriteria(Employee.class).add(Restrictions.eq("id", id))
					.setProjection(Projections.projectionList()
							.add(Projections.property("empFirstName"), "empFirstName")
							.add(Projections.property("empLastName"), "empLastName"))
					.setResultTransformer(Transformers.aliasToBean(Employee.class)).list();

			employee = (Employee) results.get(0);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return employee;
	}
	
	

	@Override
	public List<Employee> findAllManagers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> managers = new ArrayList<Employee>();
		
		try {
			List results = session.createCriteria(Employee.class).add(Restrictions.eq("empIsManager", 1))
					.setProjection(Projections.projectionList()
							.add(Projections.property("id"), "id")
							.add(Projections.property("empFirstName"), "empFirstName")
							.add(Projections.property("empLastName"), "empLastName")
							.add(Projections.property("empDepartmentId"), "empDepartmentId"))
					.setResultTransformer(Transformers.aliasToBean(Employee.class)).list();

			managers = results;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return managers;
	}
	
}