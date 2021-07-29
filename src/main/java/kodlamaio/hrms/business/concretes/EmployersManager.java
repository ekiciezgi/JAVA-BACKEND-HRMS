package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kodlamaio.hrms.business.abstracts.EmployersService;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;
@Service
public class EmployersManager implements EmployersService{

	
	private EmployersDao employersDao;

	
	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	
	}

	@Override
	public DataResult<List<Employers>> getAll() {

		return new SuccessDataResult<List<Employers>>(employersDao.findAll());
	}
	
	@Override
	public Result add(Employers employers) {
		if(!companyNameChecker(employers)) {
			return new ErrorDataResult<Employers>(null,"Şirket Adı Boş Kalamaz!");
		}
		else if(!emailAdressChecker(employers)) {
			return new ErrorDataResult<Employers>(null,"Email Adres Boş Kalamaz!");
		}
		else  if(!passwordChecker(employers)) {
			return new ErrorDataResult<Employers>(null,"Password  Boş Kalamaz!");
		}
		else  if(!websiteAdresChecker(employers)) {
			return new ErrorDataResult<Employers>(null,"Website Adresiniz Boş Kalamaz!");
		}
		else  if(!phoneNumberChecker(employers)) {
			return new ErrorDataResult<Employers>(null,"Telefon Numaranız Boş Kalamaz!");
		}
		else if(!isRealPhoneNumber(employers)) {
			return new ErrorDataResult<Employers>(null,"Telefon Numarası Geçersiz");
	    }
		else if(employersDao.findAllByEmail(employers.getEmail()).stream().count()!=0) {
			return new ErrorDataResult<Employers>(null,"Email Adresiniz Kayıtlı.");
		}
			
	
		this.employersDao.save(employers);
		return new SuccessResult("İş veren eklendi. Mail yollandı");
	}
	
	
	

	private boolean isRealPhoneNumber(Employers employers) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employers.getPhone());
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}

	private boolean phoneNumberChecker(Employers employers) {
		if(employers.getPhone().isBlank()||employers.getPhone().equals(null)) {
			return false;
			}
			else return true;
	}

	private boolean websiteAdresChecker(Employers employers) {
		if(employers.getWebAddress().isBlank()||employers.getWebAddress().equals(null)) {
			return false;
			}
			else return true;
	}

	private boolean passwordChecker(Employers employers) {
		if(employers.getPassword().isBlank()||employers.getPassword().equals(null)) {
			return false;
			}
			else return true;
	}

	private boolean emailAdressChecker(Employers employers) {
		if(employers.getEmail().isBlank()||employers.getEmail().equals(null)) {
			return false;
			}else {
				return true;
			}
	}

	private boolean companyNameChecker(Employers employers) {
	  if(employers.getCompanyName().isBlank()||employers.getCompanyName().equals(null)) {

			return false;
	  }
	  else {
		return true;}
	}

	@Override
	public DataResult<Employers> getById(int id) {
		return new SuccessDataResult<Employers>(this.employersDao.getOne(id));
	}

	@Override
	public DataResult<List<Employers>> getAllByVerify() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.getAllByIsConfirm());
	}

	@Override
	public Result changeIsVerifiedByEmployee(int id) {
		Employers employer = this.employersDao.getById(id);
		employer.setConfirm(true);
		this.employersDao.save(employer);
		return new SuccessResult("Şirketin confirm durumu değiştirildi");	}

	@Override
	public Result update(Employers employers) {
	
		this.employersDao.save(employers);
		return new SuccessResult("İş veren eklendi.");
	}

	@Override
	public Result delete(int id) {
		this.employersDao.deleteById(id);
		return new SuccessResult("İş veren eklendi.");
	}

}
