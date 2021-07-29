package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.GenerateRandomCode;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;
@Service
public class VerificationManager implements  VerificationService{
private VerificationDao verificationDao;
	
    @Autowired
	public VerificationManager(VerificationDao emailVerificationDao) {
		super();
		this.verificationDao = emailVerificationDao;
	}

    @Override
	public void generateCode(Verification code,Integer id) {
		// TODO Auto-generated method stub
				Verification code_ = code;
				code.setCode(null);
				code.setVerified(false);
				if(code.isVerified() == false) {
					GenerateRandomCode generator = new GenerateRandomCode();
					String code_create = generator.create();
					code.setCode(code_create);
					code.setUserId(id);
			
					verificationDao.save(code_);
					
				}
				return ;
	}
	
	@Override
	public Result verify(String verificationCode,Integer id) {
		// TODO Auto-generated method stub
		Verification ref = verificationDao.findByUserId(id).stream().findFirst().get();
		if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
			ref.setVerified(true);
			return  new SuccessDataResult<Verification>(this.verificationDao.save(ref),"Doğrulama Başarılı");
		}
		else if(ref.isVerified() == true) {
			return  new ErrorDataResult<Verification>(null," Hesabınız Doğrulanmış");
		}
		return  new ErrorDataResult<Verification>(null,"Doğrulama Kodunuz Geçersiz ,Lütfen tekrar deneyin.");
		
		
		
		
		
		
	}


	

}
