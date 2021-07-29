package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	
	DataResult<List<Employers>>getAll();
	Result add(Employers employers);
	Result update(Employers employers);
	Result delete(int id);
	DataResult<Employers> getById(int id);
	DataResult<List<Employers>> getAllByVerify();
	Result changeIsVerifiedByEmployee(int id);

}
