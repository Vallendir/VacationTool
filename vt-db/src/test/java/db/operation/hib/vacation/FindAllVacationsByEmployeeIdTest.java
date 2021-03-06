package db.operation.hib.vacation;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import db.entity.Vacation;
import db.operation.hib.HibernateOperation;
import db.operation.hib.VacationListOperation;

/**
 * Class to test finding vacation list for specific employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllVacationsByEmployeeIdTest {
	private final int employeeId = 14;

	/**
	 * Method to test find vacation list for specific employee by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllVacationsByEmployeeId find = new FindAllVacationsByEmployeeId(employeeId);

		assertNotNull(find);

		List<Vacation> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find vacation list for specific employee by using
	 * interface of VacationListOperation.
	 */
	@Test
	public void runTestForInstantiateByVacationInterface() {
		VacationListOperation find = new FindAllVacationsByEmployeeId(employeeId);

		assertNotNull(find);

		List<Vacation> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find vacation list for specific employee by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Collection<Vacation>> find = new FindAllVacationsByEmployeeId(employeeId);

		assertNotNull(find);

		List<Vacation> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
