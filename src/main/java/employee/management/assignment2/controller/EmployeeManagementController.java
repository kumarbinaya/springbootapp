package  employee.management.assignment2.controller;

import employee.management.assignment2.domain.Employee;
import employee.management.assignment2.service.EmployeeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeManagementController {
private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementController.class);

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String processAddEmployee(@RequestBody @Validated Employee employee) {
		LOGGER.info("Method - processAddEmployee ");
		Employee emp = employeeManagementService.addNewEmployes(employee);
	    if(emp != null){
			return "success";
		}else{
	    	return "failure";
		}
	}

	@GetMapping
	public List<Employee> processGetEmployees() {
		List<Employee> list = employeeManagementService.getAllEmployees();
		return list;
	}

	@PutMapping("/{id}")
	public Employee processUpdateEmployee(@PathVariable(value = "id") Integer id, @RequestBody Employee newEmployee) {
		return employeeManagementService.updateEmployee(id,newEmployee);
	}

	@DeleteMapping("/{id}")
	public void  deleteEmployee(@PathVariable(value = "id") Integer id) {
		 employeeManagementService.deleteEmployee(id);
	}
}
