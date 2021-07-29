package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployeeLanguage;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer>{
	//@Query("From CandidateJobExperience c where employee_cv_id =:id ORDER BY finish_date, is_continue DESC")
	//List<JobExperience> getJobExperienceOrderByExitDateDesc(int id);
	//List<JobExperience> getById(int id);
	List<JobExperience>getAllByEmployeeCv_id(int id);
	@Query(value="select * from job_experiences where id =:id ",nativeQuery=true)
	JobExperience getById(int id);
	
	
}
