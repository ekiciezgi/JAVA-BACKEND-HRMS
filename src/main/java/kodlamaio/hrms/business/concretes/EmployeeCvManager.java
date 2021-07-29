package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.business.abstracts.EmployeeSchoolService;
import kodlamaio.hrms.core.utilities.dtoConvert.DtoConvertService;
import kodlamaio.hrms.core.utilities.image.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeCvDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import kodlamaio.hrms.entities.concretes.EmployeeSchool;
import kodlamaio.hrms.entities.dto.EmployeeCvDto;
@Service
public class EmployeeCvManager implements EmployeeCvService{

	private EmployeeCvDao employeeCvDao;
	private ImageService imageService;
   private DtoConvertService dtoConvertService;
    
	@Autowired
	public EmployeeCvManager(EmployeeCvDao employeeCvDao,ImageService imageService,DtoConvertService dtoConvertService
		   ) {
		super();
		this.employeeCvDao = employeeCvDao;
		this.imageService = imageService;
		this.dtoConvertService=dtoConvertService;
	}

    


	@Override
	public DataResult<List<EmployeeCv>> getAll() {
		
		return  new SuccessDataResult<List<EmployeeCv>>(this.employeeCvDao.findAll(),"iş arayanların cv listelendi.");
	}

	

	@Override
	public DataResult<List<EmployeeCv>> findByEmployeeCvId(int id) {
		return  new SuccessDataResult<List<EmployeeCv>>(this.employeeCvDao.findById(id));
	}

	public Result uploadCvPhoto( int employee, MultipartFile multipartFile) throws IOException {
		
		
		
		 /* Map<String,String>image=this.imageService.upload(multipartFile).getData();
		  var url=image.get("url");
		  EmployeeCv cv=this.employeeCvDao.getById(employee);
		  cv.setImageUrl(url);
		  this.employeeCvDao.save(cv);*/
		  
		var result = this.imageService.upload(multipartFile);
	      var url = result.getData().get("url");
	      
	      EmployeeCv ref = this.employeeCvDao.getOne(employee); 
	      ref.setImageUrl(url.toString());
	      this.employeeCvDao.save(ref);
	      
	        return new SuccessResult("Başarılı");
	}
	

	@Override
	public DataResult<EmployeeCv> getById(int id) {
		// TODO Auto-generated method stub
		return  new SuccessDataResult<EmployeeCv>(this.employeeCvDao.getById(id));
	}


	@Override
	public Result add(EmployeeCvDto employeeCv) {
		// TODO Auto-generated method stub
				this.employeeCvDao.save((EmployeeCv)dtoConvertService.dtoClassConverter(employeeCv, EmployeeCv.class));
				return new SuccessResult("Başarılı");
	}


	@Override
	public Result update(EmployeeCvDto employeeCv) {
		EmployeeCv cv=this.employeeCvDao.getById(employeeCv.getId());
		cv.setAbilities(employeeCv.getAbilities());
	  cv.setCoverLetter(employeeCv.getCoverLetter());
	  cv.setCreatedDate(employeeCv.getCreatedDate());
	  cv.setGithubAddress(employeeCv.getGithubAddress());
	  cv.setLinkedinAddress(employeeCv.getLinkedinAddress());
		this.employeeCvDao.save((EmployeeCv)dtoConvertService.dtoClassConverter(cv, EmployeeCv.class));
		return new SuccessResult("Başarılı");
	}


	

}
