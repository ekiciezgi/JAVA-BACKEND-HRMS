package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

public interface ConfirmEmployerService {
	 Result add(ConfirmEmployer confirmEmployer);
	 DataResult<List<ConfirmEmployer>> getAll();
		
		DataResult<ConfirmEmployer> getById(int id);
		
		DataResult<List<ConfirmEmployer>> getAllByConfirmFalse();

	 
}
