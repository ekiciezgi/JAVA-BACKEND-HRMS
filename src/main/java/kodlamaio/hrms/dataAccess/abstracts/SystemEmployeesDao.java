package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployeeCv;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.concretes.SystemEmployees;


public interface SystemEmployeesDao extends JpaRepository<SystemEmployees,Integer>{
	
	
	SystemEmployees getById(int id);
	 List<SystemEmployees>getAllByUser_id(int id);
	 SystemEmployees getByUser_Id(int id);
    
}
