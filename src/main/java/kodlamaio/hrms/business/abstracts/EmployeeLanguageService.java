package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeLanguage;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeLanguageDto;
public interface EmployeeLanguageService {
	
 DataResult<List<EmployeeLanguage>>getAll();
Result add(EmployeeLanguageDto employeeLanguageDto);
Result update(EmployeeLanguageDto employeeLanguageDto);
 DataResult<List<EmployeeLanguage>>getAllByEmployeeCv_id(int id);

}
