package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Verification;

public interface VerificationService {
	void generateCode(Verification code, Integer id);
	Result verify(String verificationCode,Integer id);
}
