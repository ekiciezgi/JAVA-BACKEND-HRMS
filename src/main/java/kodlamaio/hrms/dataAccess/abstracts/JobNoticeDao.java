package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.JobNotice;

public interface JobNoticeDao  extends JpaRepository<JobNotice, Integer>{
	
	
  
	 List<JobNotice>findByActivityStatus(boolean activityStatus);
	 List<JobNotice> findByActivityStatusOrderByApplicationDeadline(boolean activityStatus);
	 List<JobNotice> findByActivityStatusTrueAndEmployer_CompanyName(String companyName);
	 
	 @Query("From JobNotice where is_confirmed_by_admin = true")
		List<JobNotice> getIsConfirmedByAdminJobNotice();
		
		@Query("From JobNotice where isConfirmed = false")
		List<JobNotice> getWaitingJobAdvertisements();
		
		JobNotice findById(int id);
		@Query("From JobNotice where activity_status=true AND is_confirmed_by_admin=true")// iş arayanın göreceği 1.sayfa
		List<JobNotice> getAllByIsActivityStatusByEmployer(Pageable pageable);
	
		
		
		
}
