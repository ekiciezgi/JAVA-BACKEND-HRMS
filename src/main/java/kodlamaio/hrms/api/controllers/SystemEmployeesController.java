package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployees;
import kodlamaio.hrms.entities.dto.SystemEmployeesDto;
@RestController
@RequestMapping("/api/systemEmployees")
@CrossOrigin
public class SystemEmployeesController {
	
	private SystemEmployeesService systemEmployerService;
   @Autowired
	public SystemEmployeesController(SystemEmployeesService systemEmployerService) {
		super();
		this.systemEmployerService = systemEmployerService;
	}
   @GetMapping("getAll")
   @ResponseBody
	public DataResult<List<SystemEmployees>> getAll(){
		return this.systemEmployerService.getAll();
	}
   
   @PostMapping("add")
   public Result add(@RequestBody SystemEmployeesDto systemEmployees) {
	   return this.systemEmployerService.add(systemEmployees);	   
   }
   @PostMapping("update")
   public Result update(@RequestBody SystemEmployeesDto systemEmployees) {
	   return this.systemEmployerService.update(systemEmployees);	   
   }
   @GetMapping("getByUser_Id")
   public DataResult<SystemEmployees> getByUser_Id(@RequestParam int id) {
	   return this.systemEmployerService.getByUser_Id(id);
	   }
   @GetMapping("getAllByUser_Id")
   public DataResult<List<SystemEmployees>> getAllByUser_id(int id) {
	   return this.systemEmployerService.getAllByUser_id(id);
   }
   @GetMapping("getById")
	public DataResult<SystemEmployees> getById(int id) {
	   return this.systemEmployerService.getById(id);   }
}
