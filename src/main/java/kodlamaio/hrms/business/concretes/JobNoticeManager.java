package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.hrms.business.abstracts.JobNoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.dataAccess.abstracts.JobNoticeDao;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.entities.concretes.JobNotice;
import kodlamaio.hrms.entities.dto.JobNoticeDto;
@Service
public class JobNoticeManager implements JobNoticeService{

    private JobNoticeDao jobNoticeDao;
	private EmployersDao employersDao;
    private CityDao  cityDao;
    private WorkTimeDao workTime; 
    private WorkPlaceDao workPlace;
    private PositionDao positionDao;
   
	
	 @Autowired
	public JobNoticeManager(JobNoticeDao jobNoticeDao, EmployersDao employersDao, CityDao cityDao, WorkTimeDao workTime,
			WorkPlaceDao workPlace, PositionDao positionDao) {
		super();
		this.jobNoticeDao = jobNoticeDao;
		this.employersDao = employersDao;
		this.cityDao = cityDao;
		this.workTime = workTime;
		this.workPlace = workPlace;
		this.positionDao = positionDao;
	}

	 @Override
		public DataResult<List<JobNotice>> getAll() {
			
			return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.findAll()," İş ilanları listelendi.");
		}
	@Override
	public Result add(JobNoticeDto jobNoticeDto) {
		JobNotice jobNotice=new JobNotice();
		LocalDateTime date= LocalDateTime.now();
		
		jobNotice.setCity(this.cityDao.getByCityId(jobNoticeDto.getCityId()));
        jobNotice.setJobPosition(this.positionDao.getById(jobNoticeDto.getPositionId()));
        jobNotice.setWorkTime(this.workTime.getById(jobNoticeDto.getWorkTimeId()));
        jobNotice.setWorkPlace(this.workPlace.getById(jobNoticeDto.getWorkPlaceId()));
        jobNotice.setEmployer(this.employersDao.getById(jobNoticeDto.getEmployerId()));
        jobNotice.setDescription(jobNoticeDto.getDescription());
        jobNotice.setMaxPay(jobNoticeDto.getMaxSalary());
        jobNotice.setMinPay(jobNoticeDto.getMinSalary());
        jobNotice.setActivePositionNumber(jobNoticeDto.getOpenPositionCount());
        jobNotice.setApplicationDeadline(jobNoticeDto.getApplicationDeadLine());
        jobNotice.setActivityStatus(true);
        jobNotice.setAddDate(date.toLocalDate());
        jobNotice.setConfirmedByAdmin(false);
        
        jobNotice.setCompanyName(this.employersDao.getById(jobNoticeDto.getEmployerId()).getCompanyName());
        this.jobNoticeDao.save(jobNotice);
		return new SuccessResult("İş ilanı eklendi. İşlem Başarılı");
	}
	
	@Override
	 public DataResult<List<JobNotice>>
	 findByActivityStatusOrderByApplicationDeadline(boolean activityStatus){
		 if(activityStatus==true) {
		 return  new SuccessDataResult<List<JobNotice>>
		 (this.jobNoticeDao.findByActivityStatusOrderByApplicationDeadline(true),"Tarihine göre iş ilanı listelendi.");
		 }else 
		return new ErrorDataResult<List<JobNotice>>
		 (this.jobNoticeDao.findByActivityStatusOrderByApplicationDeadline(false),"Tarihine göre iş ilanı listelenemedi ,iş başvuruları kapandı."); 
	 }
	 @Override
	 public DataResult<List<JobNotice>>findByActivityStatus(boolean activityStatus){
		 if(activityStatus==true) {
			 return  new SuccessDataResult<List<JobNotice>>
			 (this.jobNoticeDao.findByActivityStatus(true),"Aktif iş ilanı listelendi.");
			 }else 
			 return new ErrorDataResult<List<JobNotice>>
			 (this.jobNoticeDao.findByActivityStatus(false),"İş ilanı listelenemedi ilan aktif değil ,iş başvuruları kapandı."); 
	 }
	 @Override
	 public DataResult<List<JobNotice>>findByActivityStatusTrueAndEmployer_CompanyName(boolean activityStatus,String companyName){
		 if(activityStatus==true) {
			 return  new SuccessDataResult<List<JobNotice>>
			 (this.jobNoticeDao.findByActivityStatusTrueAndEmployer_CompanyName(companyName),"Aktif İş İlanları Şirket Adlarına Göre Listelendi.");
			 }else 
			return new ErrorDataResult<List<JobNotice>>
			 (this.jobNoticeDao.findByActivityStatusTrueAndEmployer_CompanyName(companyName),"İş ilanı aktif değil."); 
		 }

	
	 @Override
		public DataResult<JobNotice> setJobAdvertisementDisabled(int id) {
			// TODO Auto-generated method stub
			if(!this.employersDao.existsById(id)) {
				return new ErrorDataResult<JobNotice>("Hata: İş veren bulunamadı");
			}
			JobNotice ref =  this.jobNoticeDao.getOne(id);
			ref.setActivityStatus(false);
			return new SuccessDataResult <JobNotice>(this.jobNoticeDao.save(ref),"İş İlanı Pasif olarak ayarlandı");
			
		}

	@Override
	public DataResult<List<JobNotice>> getIsConfirmedByAdminJobNotice() {
		return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.getIsConfirmedByAdminJobNotice(),"Başarılı Şekilde Onaylanmış İş İlanlari Listelendi");
	}




	@Override
	public Result confirmJobAd(int id) {

		if(this.jobNoticeDao.existsById(id)) {
			
			JobNotice ref = this.jobNoticeDao.getOne(id);
			
		//	ref.setConfirmed(true);
			
			jobNoticeDao.save(ref);
			
			return  new SuccessResult("Başarılı Şekilde İş İlani  HRMS Personeli Tarafından Onaylandı");
		}
		return new ErrorResult("İş İlani Bulunamadı");
		
	}

	@Override
	public DataResult<JobNotice> getById(int id) {// TODO Auto-generated method stub
		return new SuccessDataResult<JobNotice>(this.jobNoticeDao.findById(id));	}

	@Override
	public DataResult<List<JobNotice>> getAllPage(int pageNo) {
		Pageable pageable = PageRequest.of(pageNo-1, 10);
		return   new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.findAll(pageable).getContent(),"Başarılı");
	}

	@Override
	public DataResult<List<JobNotice>> getAllByIsActiveByEmployee(int pageNo, int size) {
         Pageable pageable = PageRequest.of(pageNo-1, size);
		
		return new SuccessDataResult<List<JobNotice>>(this.jobNoticeDao.getAllByIsActivityStatusByEmployer(pageable));
	}
	
}
