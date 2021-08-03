package employee.management.assignment2.controller;

import employee.management.assignment2.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeManagementControllerIntegrationTest {

    @Autowired
    EmployeeManagementController employeeManagementController;

    @Test
    public void testAddEmployee(){
    Employee emp = new Employee();
    emp.setFirstName("matt");
    emp.setLastName("utku");
     String outCome =  employeeManagementController.processAddEmployee(emp);
    assertEquals("success",outCome);
    }

    @Test
    public void testAddEmployeeWithMissingFirstName(){
        Employee aEmployee = new Employee();
        aEmployee.setLastName("johnson");
        String outCome = employeeManagementController.processAddEmployee(aEmployee);
        assertEquals("failuer",outCome);
    }

}
