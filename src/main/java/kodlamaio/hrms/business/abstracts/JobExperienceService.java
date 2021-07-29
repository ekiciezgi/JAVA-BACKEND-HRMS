package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dto.JobExperianceDto;

public interface JobExperienceService {
	DataResult<List<JobExperience>>getAll();
	 Result add(JobExperianceDto jobExperienceDto);
	 Result update(JobExperianceDto jobExperienceDto);

	//	DataResult<List<JobExperience>> orderedEmployeeCvJobExperience(int id);
		//DataResult<List<JobExperience>> getById(int id);
	 DataResult<List<JobExperience>>getAllByEmployeeCv_id(int id);
	 
}
