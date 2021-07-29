package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriJob;

public interface FavoriJobService {

	Result add(FavoriJob favoriJob);
	Result update(FavoriJob favoriJob);
	DataResult<List<FavoriJob>> getAll();
	Result delete(int id);
	 DataResult<FavoriJob> getById(int id);
	 DataResult<List<FavoriJob>>getByEmployee_Id(int employeeId);
	 DataResult<List<FavoriJob>>getByEmployer_Id(int employerId);
}
