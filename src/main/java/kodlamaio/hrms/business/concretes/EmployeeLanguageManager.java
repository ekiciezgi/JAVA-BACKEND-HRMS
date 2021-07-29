package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeLanguageService;
import kodlamaio.hrms.core.utilities.dtoConvert.DtoConvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeLanguageDao;
import kodlamaio.hrms.entities.concretes.EmployeeLanguage;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeLanguageDto;

@Service
public class EmployeeLanguageManager implements EmployeeLanguageService{
 private EmployeeLanguageDao employeeLanguageDao;
	private DtoConvertService dtoConvertService;
	public EmployeeLanguageManager(EmployeeLanguageDao employeeLanguageDao,DtoConvertService dtoConvertService) {
	super();
	this.employeeLanguageDao = employeeLanguageDao;

	this.dtoConvertService=dtoConvertService;
}

	@Override
	public DataResult<List<EmployeeLanguage>> getAll() {
		
		return new SuccessDataResult<List<EmployeeLanguage>>(this.employeeLanguageDao.findAll());
	}



	@Override
	public DataResult<List<EmployeeLanguage>> getAllByEmployeeCv_id(int id) {
	
		return  new SuccessDataResult<List<EmployeeLanguage>>(this.employeeLanguageDao.getAllByEmployeeCv_id(id));
	}

	@Override
	public Result add(EmployeeLanguageDto employeeLanguageDto) {
		
		this.employeeLanguageDao.save((EmployeeLanguage)dtoConvertService.dtoClassConverter(employeeLanguageDto, EmployeeLanguage.class));
		return new SuccessResult("Başarılı");
	}

	@Override
	public Result update(EmployeeLanguageDto employeeLanguageDto) {
	    EmployeeLanguage cf=this.employeeLanguageDao.getById(employeeLanguageDto.getId());
	     cf.setLevel(employeeLanguageDto.getLevel());
         cf.setLanguage(employeeLanguageDto.getLanguage());
		this.employeeLanguageDao.save((EmployeeLanguage)dtoConvertService.dtoClassConverter(cf, EmployeeLanguage.class));
		return new SuccessResult("Başarılı");
	}
	
	
	}



	


