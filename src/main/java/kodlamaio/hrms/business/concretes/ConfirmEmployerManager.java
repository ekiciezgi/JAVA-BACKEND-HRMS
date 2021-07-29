package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService{
    private ConfirmEmployerDao confirmEmployerDao;
    
	public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao) {
		super();
		this.confirmEmployerDao = confirmEmployerDao;
	}

	@Override
	public Result add( ConfirmEmployer confirmEmployer) {
		this.confirmEmployerDao.save(confirmEmployer);
		return new SuccessResult("başarılı");
	}

	@Override
	public DataResult<List<ConfirmEmployer>> getAll() {
		
		return  new SuccessDataResult<List<ConfirmEmployer>>(this.confirmEmployerDao.findAll());
	}

	@Override
	public DataResult<ConfirmEmployer> getById(int id) {
		  return new SuccessDataResult<ConfirmEmployer>(this.confirmEmployerDao.getById(id));
	}

	@Override
	public DataResult<List<ConfirmEmployer>> getAllByConfirmFalse() {
		
		return new SuccessDataResult<List<ConfirmEmployer>>(this.confirmEmployerDao.getAllByConfirmFalse());
 
	}

}
