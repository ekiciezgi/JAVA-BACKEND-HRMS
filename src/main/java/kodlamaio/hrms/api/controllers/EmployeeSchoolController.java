package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeSchoolDto;

@RestController
@RequestMapping("api/employeSchool")
@CrossOrigin
public class EmployeeSchoolController {
   private EmployeeSchoolService employeeSchoolService ;

   public EmployeeSchoolController(EmployeeSchoolService employeeSchoolService) {
	super();
	this.employeeSchoolService = employeeSchoolService;
  }
   
   @GetMapping("getAll")
   DataResult<List<EmployeeSchool>>getAll(){
	   return this.employeeSchoolService.getAll();
	   }
   @PostMapping("add")
	public Result add(@RequestBody EmployeeSchoolDto employeeSchoolDto) {
	   return this.employeeSchoolService.add(employeeSchoolDto);
	   
   }
   @PostMapping("update")
 	public Result update(@RequestBody EmployeeSchoolDto employeeSchoolDto) {
 	   return this.employeeSchoolService.add(employeeSchoolDto);
 	   
    }
	   @GetMapping("get")
	   DataResult<List<EmployeeSchool>> getAllByEmployeeCvId(@RequestParam int id) {
		   return this.employeeSchoolService.getAllByEmployeeCvId(id);
	   }
   
}
