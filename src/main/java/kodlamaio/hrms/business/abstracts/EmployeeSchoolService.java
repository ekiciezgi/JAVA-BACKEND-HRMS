package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeSchoolDto;

public interface EmployeeSchoolService {
	 DataResult<List<EmployeeSchool>>getAll();
	 Result add(EmployeeSchoolDto employeeSchoolDto);
	   Result update(EmployeeSchoolDto employeeSchoolDto);
	   Result delete(int id);
	   DataResult<EmployeeSchool>getById(int id);
	   DataResult<List<EmployeeSchool>>getAllByEmployeeCvId(int id);
}
