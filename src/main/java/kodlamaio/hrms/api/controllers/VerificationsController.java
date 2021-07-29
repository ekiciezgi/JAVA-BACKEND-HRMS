package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
@RestController
@RequestMapping("/api/verifications")
@CrossOrigin
public class VerificationsController {

private VerificationService emailVerificationService;
	
	
	@Autowired
	public VerificationsController(VerificationService emailVerificationService) {
		super();
		this.emailVerificationService = emailVerificationService;
	}



	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
			return emailVerificationService.verify(verificationCode,id);
	}
}
