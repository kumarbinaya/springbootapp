package employee.management.assignment2.service;

import employee.management.assignment2.data.repos.EmployeeRepository;
import employee.management.assignment2.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementService.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee  addNewEmployes(Employee employee) {
		LOGGER.info("Create a new Employee "+ employee.getFirstName());
		Employee emp = null;
		if (employee.getFirstName() != null) {
			emp = employeeRepository.save(employee);
		}
		return emp;
	}
    public List<Employee> getAllEmployees() {
		LOGGER.info("Get all  Employees ");
		return (List<Employee>) employeeRepository.findAll();
    }

	public Employee updateEmployee(int id , Employee newEmployee) {
		LOGGER.info("Update Employee for id  "+ id);
		return verifyUpdateEmployee(id, newEmployee);

	}
	public Employee verifyUpdateEmployee(int id , Employee newEmployee){
		return employeeRepository.findById((long) id).map(employee -> processEmployee(employee,newEmployee)).orElseGet(() -> employeeRepository.save(newEmployee));
	}

	private Employee processEmployee(Employee existingEmp , Employee newEmp) {
		{
			existingEmp.setFirstName(newEmp.getFirstName());
			existingEmp.setLastName(newEmp.getLastName());
			existingEmp.setEmail(newEmp.getEmail());
			return employeeRepository.save(existingEmp);
		}
	}

	public void deleteEmployee(int id){
		LOGGER.info("Delete Employees for Id  " + id);
	  employeeRepository.deleteById((long) id);

	}

}
