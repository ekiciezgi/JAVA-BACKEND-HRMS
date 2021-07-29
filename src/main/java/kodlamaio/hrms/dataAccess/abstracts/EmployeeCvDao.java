package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.EmployeeCv;

public interface EmployeeCvDao extends JpaRepository<EmployeeCv,Integer> {

	List<EmployeeCv>findById(int id);
	boolean existsById(int id);
    EmployeeCv getById(int id);
	
}
