package employee.management.assignment2.service;

import employee.management.assignment2.data.repos.EmployeeRepository;
import employee.management.assignment2.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class EmployeeManagementServiceUnitTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeManagementService employeeManagementService;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddEmployee(){
        //create a Employee
        Employee aMockEmployee = new Employee();
        aMockEmployee.setFirstName("Jenny");
        aMockEmployee.setLastName("Johnson");
        when(employeeRepository.save(any(Employee.class))).thenReturn(aMockEmployee);
        //save the Employee
        Employee newEmployee = employeeManagementService.addNewEmployes(new Employee());

        //verify the save

        assertEquals("Jenny", newEmployee.getFirstName());
    }
}
