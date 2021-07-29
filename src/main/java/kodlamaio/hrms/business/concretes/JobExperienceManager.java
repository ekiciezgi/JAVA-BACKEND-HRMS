package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.dtoConvert.DtoConvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dto.JobExperianceDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;

	private DtoConvertService dtoConvertService;
	
	
	public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConvertService dtoConvertService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConvertService=dtoConvertService;
	}

	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findAll());
	}

	

	@Override
	public DataResult<List<JobExperience>> getAllByEmployeeCv_id(int id) {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByEmployeeCv_id(id));
	}

	@Override
	public Result add(JobExperianceDto jobExperienceDto) {
		this.jobExperienceDao.save((JobExperience)dtoConvertService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("Başarılı");
	}

	@Override
	public Result update(JobExperianceDto jobExperienceDto) {
		JobExperience cf=this.jobExperienceDao.getById(jobExperienceDto.getId());
		LocalDateTime date= LocalDateTime.now();
		
	    cf.setFinishDate(jobExperienceDto.getFinishDate());
	    cf.setJobplaceName(jobExperienceDto.getJobplaceName());
	    cf.setPosition(jobExperienceDto.getPosition());
	    cf.setStartDate(jobExperienceDto.getStartDate());
	    cf.setJobDetail(jobExperienceDto.getJobDetail());
	    cf.setCreatedDate(date.toLocalDate());
		this.jobExperienceDao.save((JobExperience)dtoConvertService.dtoClassConverter(cf, JobExperience.class));
		return new SuccessResult("Başarılı");
	}

/*	@Override
	public DataResult<List<JobExperience>> orderedEmployeeCvJobExperience(int id) {
		if(!this.employeeCvDao.existsById(id)) {
			return new ErrorDataResult<>("Cv bulunamadı");
		}
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getJobExperienceOrderByExitDateDesc(id),"Başarılı Şekilde İş arayanın tecrübe bilgileri listelendi");
	}

	@Override
	public DataResult<List<JobExperience>> getById(int id) {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getById(id),"başarılı");
	}
*/
}
