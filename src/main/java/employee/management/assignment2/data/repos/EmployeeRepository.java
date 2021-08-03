package employee.management.assignment2.data.repos;

import employee.management.assignment2.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
