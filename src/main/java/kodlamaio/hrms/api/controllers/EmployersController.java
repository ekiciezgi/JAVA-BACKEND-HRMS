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

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Employers;
@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployersService employersService;
	
        @Autowired
		public EmployersController(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}


	@GetMapping("/getAll")

    public DataResult<List<Employers>> getAll(){
		return this.employersService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody Employers employers) {
    	return this.employersService.add(employers);
    }
	@GetMapping("/getById")
	public DataResult<Employers> getById(@RequestParam int id) {
		return this.employersService.getById(id);
	}
	@GetMapping("/getAllByVerify")
		public DataResult<List<Employers>> getAllByVerify() {
		return this.employersService.getAllByVerify();
	}
	@PostMapping("/changeIsVerifiedByEmployee")
	public Result changeIsVerifiedByEmployee(@RequestParam int id) {
		return this.employersService.changeIsVerifiedByEmployee(id);
	}
	@PostMapping("/update")
	public Result update( @RequestBody Employers employers) {
	
		return this.employersService.update(employers);
		    
	}
	//@PostMapping("/delete")
	//public Result delete(int id) {
	//	return this.employersService.delete(id);
	//}
}