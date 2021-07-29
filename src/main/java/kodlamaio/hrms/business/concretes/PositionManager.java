package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao=positionDao;
	}
   
	@Override
	public DataResult<List<Position>>getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll());
	}

	@Override
	public Result add(Position position) {
		if(positionDao.findAllByPositionName(position.getPositionName()).stream().count()!=0) {
		return new ErrorDataResult<Position>(null,"Bu isimde iş pozisyonu zaten mevcut.");	
		}else {
		return new SuccessDataResult<Position>(this.positionDao.save(position),"İş pozisyonunuz sisteme başarı ile eklenmiştir.");
		}
	}

}
