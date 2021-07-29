package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.EmployeeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeLanguage;
import kodlamaio.hrms.entities.dto.EmployeeLanguageDto;

@RestController
@RequestMapping("api/employeeLanguage")
@CrossOrigin
public class EmployeeLanguageController {
	
	private EmployeeLanguageService employeeLanguageService ;

	public EmployeeLanguageController(EmployeeLanguageService employeeLanguageService) {
		super();
		this.employeeLanguageService = employeeLanguageService;
	}
	  @GetMapping("getAll")
	public  DataResult<List<EmployeeLanguage>>getAll(){
		 return this.employeeLanguageService.getAll();
		 }
	   @PostMapping("add")
	 public Result add(@RequestBody EmployeeLanguageDto employeeLanguageDto){
		   return this.employeeLanguageService.add(employeeLanguageDto);
	   }
	   @GetMapping("getAllByEmployeeCv_id")
	   DataResult<List<EmployeeLanguage>> getAllByEmployeeCv_id(int id) {
	   return this.employeeLanguageService.getAllByEmployeeCv_id(id);
	   }
	
	   @PostMapping("update")
		public Result update(@RequestBody EmployeeLanguageDto employeeLanguageDto) {
		   return this.employeeLanguageService.update(employeeLanguageDto);
	   }
}
