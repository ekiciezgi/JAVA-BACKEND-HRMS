package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import kodlamaio.hrms.entities.dto.EmployeeCvDto;


public interface EmployeeCvService {
	 DataResult<List<EmployeeCv>>getAll();
	 Result add(EmployeeCvDto employeeCv);
	 Result update(EmployeeCvDto employeeCv);
	 DataResult<List<EmployeeCv>>findByEmployeeCvId(int id);
	 Result uploadCvPhoto(int employee, MultipartFile multipartFile) throws IOException;
	 DataResult<EmployeeCv>getById(int id);
	


}
