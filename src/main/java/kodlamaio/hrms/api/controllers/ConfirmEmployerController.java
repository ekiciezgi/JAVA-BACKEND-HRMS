package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

@RestController
@RequestMapping("api/confirimEmployer")
@CrossOrigin
public class ConfirmEmployerController {
	
 private ConfirmEmployerService cinfirmEmployerService;

public ConfirmEmployerController(ConfirmEmployerService cinfirmEmployerService) {
	super();
	this.cinfirmEmployerService = cinfirmEmployerService;
}
    @PostMapping("/add")
       public Result add(@RequestBody ConfirmEmployer confirmEmployer) {
    	return this.cinfirmEmployerService.add(confirmEmployer);
    }
    @GetMapping("/getAll")
	public DataResult<List<ConfirmEmployer>> getAll() {
		return this.cinfirmEmployerService.getAll();	}
    @GetMapping("/getById")
		public DataResult<ConfirmEmployer> getById(@RequestParam int id) {
			return this.cinfirmEmployerService.getById(id);
		}
		@GetMapping("/getAllByConfirmFalse")
		public DataResult<List<ConfirmEmployer>> getAllByConfirmFalse() {
			return this.cinfirmEmployerService.getAllByConfirmFalse();
		}
			
}
