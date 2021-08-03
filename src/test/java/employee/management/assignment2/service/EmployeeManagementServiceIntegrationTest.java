package employee.management.assignment2.service;

import employee.management.assignment2.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class EmployeeManagementServiceIntegrationTest {
    @Autowired
    private EmployeeManagementService employeeManagementService;

    @Test
    public void testAddEmployee(){
        //Create a contact
        Employee employee = new Employee();
        employee.setFirstName("matt");
        employee.setLastName("utku");
        // Testing Adding the contact
        Employee newEmployee = employeeManagementService.addNewEmployes(employee);
        //verify the addition
        assertNotNull(newEmployee);
        assertNotNull(newEmployee.getId());
        assertEquals("matt",newEmployee.getFirstName());

    }
}
