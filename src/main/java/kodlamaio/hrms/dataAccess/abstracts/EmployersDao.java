package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employers;
public interface EmployersDao extends JpaRepository<Employers,Integer>{
	List<Employers> findAllByEmail(String email);
	boolean existsById(int id);
	Employers getById(int Id);
	@Query("From Employers where is_confirm=false")
	List<Employers> getAllByIsConfirm();
	
}
