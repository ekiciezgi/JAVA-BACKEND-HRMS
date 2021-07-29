package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.abstracts.FavoriJobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriJobDao;
import kodlamaio.hrms.entities.concretes.FavoriJob;

public class FavoriJobManager implements FavoriJobService{
   private FavoriJobDao favoriJobDao;

   public FavoriJobManager(FavoriJobDao favoriJobDao) {
	super();
	this.favoriJobDao = favoriJobDao;
    }

@Override
public DataResult<FavoriJob> getById(int id) {
	
	return  new SuccessDataResult<FavoriJob>(this.favoriJobDao.getById(id));
}

@Override
public DataResult<List<FavoriJob>> getByEmployee_Id(int employeeId) {
	
	return  new SuccessDataResult<List<FavoriJob>>(this.favoriJobDao.getByEmployee_Id(employeeId));
}

@Override
public DataResult<List<FavoriJob>> getByEmployer_Id(int employerId) {
	// TODO Auto-generated method stub
	return  new SuccessDataResult<List<FavoriJob>>(this.favoriJobDao.getByEmployee_Id(employerId));
}

@Override
public Result add(FavoriJob favoriJob) {
	this.favoriJobDao.save(favoriJob);
	return new SuccessResult("yes");
}

@Override
public Result update(FavoriJob favoriJob) {
	this.favoriJobDao.save(favoriJob);
	return new SuccessResult("update");
}

@Override
public DataResult<List<FavoriJob>> getAll() {
	
	return  new SuccessDataResult<List<FavoriJob>>(this.favoriJobDao.findAll());

}

@Override
public Result delete(int id) {
	// TODO Auto-generated method stub
	return null;
}
   
}
