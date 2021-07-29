package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobNotice;
import kodlamaio.hrms.entities.dto.JobNoticeDto;

public interface JobNoticeService {
	DataResult<JobNotice> getById(int id);
	DataResult<List<JobNotice>>getAllPage(int pageNo);
	DataResult<List<JobNotice>> getAll();
	Result  add(JobNoticeDto jobNoticeDto);
	 DataResult<JobNotice> setJobAdvertisementDisabled(int id);
	 DataResult<List<JobNotice>>findByActivityStatus(boolean activityStatus);
	 DataResult<List<JobNotice>> findByActivityStatusOrderByApplicationDeadline(boolean activityStatus);
	 DataResult<List<JobNotice>> findByActivityStatusTrueAndEmployer_CompanyName(boolean activityStatus,String companyName);
     DataResult<List<JobNotice>> getAllByIsActiveByEmployee(int pageNo,int size);
     DataResult<List<JobNotice>> getIsConfirmedByAdminJobNotice();
	 Result confirmJobAd(int id);
}

