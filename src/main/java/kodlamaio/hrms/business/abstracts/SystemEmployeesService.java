package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.concretes.SystemEmployees;
import kodlamaio.hrms.entities.dto.SystemEmployeesDto;

public interface SystemEmployeesService {
	
	 DataResult<List<SystemEmployees>>getAll();
     Result add(SystemEmployeesDto systemEmployees);
     Result update(SystemEmployeesDto systemEmployees);
     DataResult<SystemEmployees>getByUser_Id(int id);;
     DataResult<List<SystemEmployees>>getAllByUser_id(int id);
     DataResult<SystemEmployees>getById(int id);
}
