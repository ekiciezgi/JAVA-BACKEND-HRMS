package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployeeLanguage;

public interface EmployeeLanguageDao extends JpaRepository<EmployeeLanguage,Integer>{
	@Query(value="select * from employee_language where employee_cv_id =:cvId and languages_id=:langId  ",nativeQuery=true)
	EmployeeLanguage getEmployeeCvIdAndEmployeeLanguageId(int cvId, int langId);
	List<EmployeeLanguage>getAllByEmployeeCv_id(int id);
	@Query(value="select * from employee_language where id =:id ",nativeQuery=true)
	EmployeeLanguage getById(int id);
	

}