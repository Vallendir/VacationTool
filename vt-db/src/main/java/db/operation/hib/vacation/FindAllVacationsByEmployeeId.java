package db.operation.hib.vacation;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import db.entity.Vacation;
import db.exception.ExceptionDescription;
import db.operation.hib.VacationListOperation;
import db.util.HibernateUtil;

/**
 * Class to find all vacations in database belong to specific employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllVacationsByEmployeeId implements VacationListOperation {
	private Integer employeeId;

	/**
	 * Constructor to set identificator of employee to search vacations from
	 * there.
	 * 
	 * @param id
	 *            identificator of employee to research
	 */
	public FindAllVacationsByEmployeeId(Integer id) {
		this.employeeId = id;
	}

	@Override
	public List<Vacation> run() {
		Session session = null;
		List<Vacation> vacations = new ArrayList<Vacation>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Vacation> criteria = builder.createQuery(Vacation.class);
			Root<Vacation> root = criteria.from(Vacation.class);

			criteria.where(builder.equal(root.get("employeeId"), employeeId));
			vacations = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(FindAllVacationsByEmployeeId.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return (vacations != null) ? vacations : new ArrayList<Vacation>();
	}

}