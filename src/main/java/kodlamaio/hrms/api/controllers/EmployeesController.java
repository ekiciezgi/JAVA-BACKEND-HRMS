package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeesController {
	
	private EmployeeService employeeService;
   
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/getall")
	@ResponseBody
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
		
	}
    @PostMapping("/add")
    public DataResult<Employee>  add(@RequestBody Employee employee) {
    	return this.employeeService.add(employee);
    	
    }
}
