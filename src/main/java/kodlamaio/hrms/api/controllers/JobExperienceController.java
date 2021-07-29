package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dto.JobExperianceDto;
@RestController
@RequestMapping("/api/jobExperience")
@CrossOrigin
public class JobExperienceController {
	
	private  JobExperienceService jobExperienceService;
	
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	/*@GetMapping("/getJobExperiencesswithordered")
	public DataResult<List<JobExperience>> orderedCandidateCvSchools(@RequestParam int id){
		return this.jobExperienceService.orderedEmployeeCvJobExperience(id);
	}*/
	   @GetMapping("getAll")
	DataResult<List<JobExperience>>getAll(){
		return this.jobExperienceService.getAll();
		} 
	@PostMapping("add")
	public Result add(@RequestBody JobExperianceDto jobExperienceDto){
		return this.jobExperienceService.add(jobExperienceDto); 
	 }
	 @GetMapping("getAllByEmployeeCv_id")
	DataResult<List<JobExperience>> getAllByEmployeeCv_id(int id) {
		 return this.jobExperienceService.getAllByEmployeeCv_id(id);
	 }

@PostMapping("update")
public Result update(@RequestBody JobExperianceDto jobExperienceDto){
	return this.jobExperienceService.update(jobExperienceDto); 
 }

}
