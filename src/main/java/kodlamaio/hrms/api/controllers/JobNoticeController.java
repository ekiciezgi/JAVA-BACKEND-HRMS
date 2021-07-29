package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobNoticeService;
import kodlamaio.hrms.entities.concretes.JobNotice;
import kodlamaio.hrms.entities.dto.JobNoticeDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController //java olmayanlarda beni tanısınf
@RequestMapping("/api/jobNotices/")
@CrossOrigin
public class JobNoticeController {
	
	private JobNoticeService jobNoticeService;

	public JobNoticeController(JobNoticeService jobNoticeService) {
		super();
		this.jobNoticeService = jobNoticeService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobNotice>> getAll(){
		return this.jobNoticeService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody JobNoticeDto jobNoticeDto ) {
		return this.jobNoticeService.add(jobNoticeDto);
	}
	
	@GetMapping("getallActivityStatus")
	 public DataResult<List<JobNotice>>findByActivityStatus(@RequestParam boolean activityStatus){
		 return this.jobNoticeService.findByActivityStatus(activityStatus);
	
	}
	@GetMapping("getallActivityDeadline")
	 public DataResult<List<JobNotice>> findByActivityStatusOrderByApplicationDeadline(boolean activityStatus){
		
		 return this.jobNoticeService.findByActivityStatusOrderByApplicationDeadline(activityStatus);
	 }
	@GetMapping("getallActivityStatusTrueAndEmployerCompanyName")
	public DataResult<List<JobNotice>> findByActivityStatusTrueAndEmployer_CompanyName(boolean activityStatus,String companyName){
		return this.jobNoticeService.findByActivityStatusTrueAndEmployer_CompanyName(activityStatus, companyName);
	}
	@PostMapping("confirmJobAdById")
	public Result confirmJobAd(@RequestParam int id){
		return this.jobNoticeService.confirmJobAd(id);
	}
	
	@GetMapping("/getConfirmedJobNotice")
	public DataResult<List<JobNotice>> getConfirmedJobNotice() {
		return this.jobNoticeService.getIsConfirmedByAdminJobNotice();
	}
	@GetMapping("/getById")
	public DataResult<JobNotice> getById(@RequestParam int id) {
		return this.jobNoticeService.getById(id);
	}
	@GetMapping("/getAllPage")
	public DataResult<List<JobNotice>> getAllPage(@RequestParam int pageNo) {
		return this.jobNoticeService.getAllPage(pageNo);	}
	@GetMapping("/getAllByIsActiveByEmployee")
	public DataResult<List<JobNotice>> getAllByIsActiveByEmployee(int pageNo, int size) {
		return this.jobNoticeService.getAllByIsActiveByEmployee(pageNo, size);
	}
	
}