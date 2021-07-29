package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.FavoriJob;

public interface FavoriJobDao extends JpaRepository<FavoriJob,Integer>{
 FavoriJob getById(int id);
 List<FavoriJob>getByEmployee_Id(int employeeId);
 List<FavoriJob>getByEmployer_Id(int employerId);
 //FavoriJob getByEmployee_IdAndByEmployer_Id(int employeeId,int employerId);

}
