package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import kodlamaio.hrms.business.abstracts.EmployeeSchoolService;
import kodlamaio.hrms.core.utilities.dtoConvert.DtoConvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeSchoolDao;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeSchoolDto;
@Service
public class EmployeeSchoolManager implements EmployeeSchoolService{
	private EmployeeSchoolDao employeeSchoolDao;

	private DtoConvertService dtoConvertService;
	
	@Autowired
	public EmployeeSchoolManager(EmployeeSchoolDao employeeSchoolDao,
			DtoConvertService dtoConvertService) {
		super();
		this.employeeSchoolDao = employeeSchoolDao;
	
		this.dtoConvertService=dtoConvertService;
	}


	@Override
	public DataResult<List<EmployeeSchool>> getAll() {
		
		return new SuccessDataResult<List<EmployeeSchool>>(this.employeeSchoolDao.findAll());
	}


	
	@Override
	public DataResult<EmployeeSchool> getById(int id) {
		return new SuccessDataResult<EmployeeSchool >(this.employeeSchoolDao.getById(id));
	}

	


	@Override
	public Result delete(int id) {
		this.employeeSchoolDao.deleteById(id);
		return new SuccessResult("");
	}


	@Override
	public DataResult<List<EmployeeSchool>> getAllByEmployeeCvId(int id) {
		
		return  new SuccessDataResult<List<EmployeeSchool>>(this.employeeSchoolDao.getAllByEmployeeCv_id(id));
	}


	@Override
	public Result add(EmployeeSchoolDto employeeSchoolDto) {
		// TODO Auto-generated method stub
		this.employeeSchoolDao.save((EmployeeSchool)dtoConvertService.dtoClassConverter(employeeSchoolDto, EmployeeSchool.class));
		return new SuccessResult("Başarılı");
	}


	@Override
	public Result update(EmployeeSchoolDto employeeSchoolDto) {
		EmployeeSchool school=this.employeeSchoolDao.getById(employeeSchoolDto.getId());
		school.setGraduationYear(employeeSchoolDto.getGraduationYear());
		school.setFinishDate(employeeSchoolDto.getFinishDate());
		school.setSchoolDepartment(employeeSchoolDto.getSchooldepartment());
		school.setSchoolName(employeeSchoolDto.getSchoolName());
		this.employeeSchoolDao.save((EmployeeSchool)dtoConvertService.dtoClassConverter(employeeSchoolDto, EmployeeSchool.class));

		return new SuccessResult("başarılı");
	}



}
