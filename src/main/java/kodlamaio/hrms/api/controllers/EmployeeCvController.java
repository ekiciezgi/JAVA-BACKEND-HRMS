package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import kodlamaio.hrms.entities.dto.EmployeeCvDto;
@RestController
@RequestMapping("api/employeeCv")
@CrossOrigin
public class EmployeeCvController {
  
	
	private EmployeeCvService employeeCvService ;
	
	   @Autowired
	public EmployeeCvController(EmployeeCvService employeeCvService) {
		super();
		this.employeeCvService = employeeCvService;
		
	}
       
	   @GetMapping("getAll")
	   public DataResult<List<EmployeeCv>> getAll(){
		   return this.employeeCvService.getAll();
	   }
	   @PostMapping("add")
	   public Result add(@RequestBody EmployeeCvDto employeeCv){
		    return this.employeeCvService.add(employeeCv);
	
	   }
	   @GetMapping("findByEmployeeCvId")
	   public DataResult<List<EmployeeCv>>findByEmployeeCvId(@RequestParam int id){
		   return this.employeeCvService.findByEmployeeCvId(id);
	   }
		@PostMapping("/addcvphoto")
		public Result uploadCvPhoto(@RequestParam int employee, @RequestParam MultipartFile multipartFile) throws IOException{
			return this.employeeCvService.uploadCvPhoto(employee, multipartFile);
		}
		@PostMapping("/updatecv")
		 Result update(@RequestBody EmployeeCvDto employeeCv) {
			return this.employeeCvService.update(employeeCv);
		}
		  @GetMapping("/getById")
		public DataResult<EmployeeCv> getById(@RequestParam int id) {
			  return this.employeeCvService.getById(id);
		  }
		
}
