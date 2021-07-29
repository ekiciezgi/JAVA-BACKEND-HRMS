package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriJobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriJob;

@RestController
@RequestMapping("api/favoriJob")
@CrossOrigin
public class FavoriJobController {
	
  /* private FavoriJobService favoriJobService;
   
    @Autowired
    public FavoriJobController(FavoriJobService favoriJobService) {
	super();
	this.favoriJobService = favoriJobService;
    }
   @PostMapping("add")
    public Result add(@RequestBody FavoriJob favoriJob) {
	   
	return this.favoriJobService.add(favoriJob);
	}
   
   @GetMapping("getAll")
	public DataResult<List<FavoriJob>>getAll() {
		return this.favoriJobService.getAll();
	}
	public Result delete(int id) {
			return this.favoriJobService.delete(id);
		}

	 @GetMapping("getById")
		public DataResult<FavoriJob> getById(int id) {
			return this.favoriJobService.getById(id);
			
		} @GetMapping("getByEmployee_Id")
			public DataResult<List<FavoriJob>> getByEmployee_Id(int employeeId) {
				return this.favoriJobService.getByEmployee_Id(employeeId);				
			}
		 @GetMapping("getByEmployer_Id")
				public DataResult<List<FavoriJob>> getByEmployer_Id(int employerId) {
					return this.favoriJobService.getByEmployer_Id(employerId);
				}
*/
}
