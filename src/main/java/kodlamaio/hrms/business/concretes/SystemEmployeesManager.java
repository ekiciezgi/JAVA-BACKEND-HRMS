package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeesService;
import kodlamaio.hrms.core.utilities.dtoConvert.DtoConvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeesDao;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.concretes.SystemEmployees;
import kodlamaio.hrms.entities.dto.SystemEmployeesDto;

@Service
public class SystemEmployeesManager implements SystemEmployeesService{
	
	private SystemEmployeesDao systemEmployeesDao;
	private DtoConvertService dtoConvertService;
   @Autowired
	public SystemEmployeesManager(SystemEmployeesDao systemEmployeesDao,DtoConvertService dtoConvertService) {
		super();
		this.systemEmployeesDao = systemEmployeesDao;
		this.dtoConvertService=dtoConvertService;
	}


	@Override
	public DataResult<List<SystemEmployees>> getAll() {
	
		return new SuccessDataResult<List<SystemEmployees>>(systemEmployeesDao.findAll());
	}


	@Override
	public Result add(SystemEmployeesDto systemEmployees) {
		this.systemEmployeesDao.save((SystemEmployees)dtoConvertService.dtoClassConverter(systemEmployees, SystemEmployees.class));
		return new SuccessResult("Başarılı");
	}


	@Override
	public Result update(SystemEmployeesDto systemEmployees) {
		SystemEmployees e=this.systemEmployeesDao.getById(systemEmployees.getId());
		
		e.setFirstName(systemEmployees.getFirstName());
		e.setLastName(systemEmployees.getLastName());
	
		this.systemEmployeesDao.save((SystemEmployees)dtoConvertService.dtoClassConverter(systemEmployees, SystemEmployees.class));
		return new SuccessResult("Başarılı");
	}


	@Override
	public DataResult<SystemEmployees> getByUser_Id(int id) {
		
		return  new SuccessDataResult<SystemEmployees>(this.systemEmployeesDao.getByUser_Id(id));
	}


	@Override
	public DataResult<List<SystemEmployees>> getAllByUser_id(int id) {
		
		return   new SuccessDataResult<List<SystemEmployees>>(this.systemEmployeesDao.getAllByUser_id(id));
	}


	@Override
	public DataResult<SystemEmployees> getById(int id) {
		return new SuccessDataResult<SystemEmployees >(this.systemEmployeesDao.getById(id));
	}



	

}
