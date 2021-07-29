package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

public interface ConfirmEmployerDao  extends JpaRepository<ConfirmEmployer,Integer> {
	ConfirmEmployer getById(int id);
    

@Query("From ConfirmEmployer where is_confirm=false")
    List<ConfirmEmployer> getAllByConfirmFalse();
}
