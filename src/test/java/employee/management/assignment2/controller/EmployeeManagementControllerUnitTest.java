package employee.management.assignment2.controller;

import employee.management.assignment2.domain.Employee;
import employee.management.assignment2.service.EmployeeManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeManagementController.class)
public class EmployeeManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeManagementService employeeManagementService;
    @InjectMocks
    private EmployeeManagementController employeeManagementController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee() throws Exception
    {
        Employee mockEmployee = new Employee();
        mockEmployee.setFirstName("Jenny");

        when(employeeManagementService.addNewEmployes(any(Employee.class))).thenReturn(mockEmployee);

        Employee aEmployee = new Employee();
        aEmployee.setFirstName("Jenny");
        mockMvc.perform(post("/employees",aEmployee)).andExpect(status().isOk()).andReturn();

    }
}
