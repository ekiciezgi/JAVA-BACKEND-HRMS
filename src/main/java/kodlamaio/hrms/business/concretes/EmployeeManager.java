package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.IdentityValidation;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;

import kodlamaio.hrms.entities.concretes.Employee;
//import kodlamaio.hrms.entities.concretes.User;
//import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class EmployeeManager implements EmployeeService {

	//dependecy injection
	
		private EmployeeDao employeeDao;
		//private VerificationService emailVerificationService;
	//	private UserService userService;
		
		@Autowired
		public EmployeeManager(EmployeeDao employeeDao,VerificationService emailVerificationService,UserService userService) {
			super();
			this.employeeDao = employeeDao;
			//this.emailVerificationService = emailVerificationService;
			//this.userService = userService;
		}

		
   @Override
	public DataResult<Employee> add(Employee employee) {
		// TODO Auto-generated method stub
		if(!firstNameChecker(employee)) {
			return new ErrorDataResult<Employee>(null,"Ad Bilgisi Doldurulmak Zorundadır");
		}
		else if(!lastNameChecker(employee)) {
			return new ErrorDataResult<Employee>(null,"SoyAdı Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!IdentityValidation.isRealPerson(employee.getNationalityId())) {
			return new ErrorDataResult<Employee>(null,"Kimlik Doğrulanamadı");
		}
		else if(employee.getNationalityId().isBlank()) {
			return new ErrorDataResult<Employee>(null,"Tc Kimlik Bilgisi Boş Bırakılamaz");
		}
		
		else if(!birthDateChecker(employee)) {
			return new ErrorDataResult<Employee>(null,"Doğum Tarihi Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!emailNullChecker(employee)) {
			return new ErrorDataResult<Employee>(null,"Email Bilgisi Doldurulmak Zorundadır");
		}
		else if(!isRealEmail(employee)) {
			return new ErrorDataResult<Employee>(null,"Email Adresiniz Yanlış");
		}
		
		else if(!passwordNullChecker(employee)) {
			return new ErrorDataResult<Employee>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(employeeDao.findAllByEmail(employee.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<Employee>(null,"Email Zaten Kayıtlı");
		}
		else if(employeeDao.findAllByNationalityId(employee.getNationalityId()).stream().count() != 0 ) {
			return new ErrorDataResult<Employee>(null,"TC Numarası Zaten Kayıtlı");
		}
		//User savedUser = this.userService.add(employee);
		//this.emailVerificationService.generateCode(new Verification(),savedUser.getId());
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:"+employee.getId());
		


		
		
		
		
	}
	
	private boolean firstNameChecker(Employee employee) {
		if(employee.getFirstName().isBlank() || employee.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(Employee employee) {
		if(employee.getLastName().isBlank() || employee.getLastName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean birthDateChecker(Employee employee) {
		if(employee.getBirthday().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean emailNullChecker(Employee employee) {
		if(employee.getEmail().isBlank() || employee.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean passwordNullChecker(Employee employee) {
		if(employee.getPassword().isBlank() ||employee.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean isRealEmail(Employee employee) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employee.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     return true;
	     
	}
	


	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Başarılı Şekilde İş Arayanlar Listelendi");
	}
}
