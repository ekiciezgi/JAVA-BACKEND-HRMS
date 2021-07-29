package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployeeSchool;

public interface EmployeeSchoolDao extends JpaRepository<EmployeeSchool,Integer>{
	
	List<EmployeeSchool> getByEmployeeCv_Id(int id);
	
	@Query(value="select * from schools where id =:id ",nativeQuery=true)
	EmployeeSchool getById(int id);
	 List<EmployeeSchool>getAllByEmployeeCv_id(int id);
}
