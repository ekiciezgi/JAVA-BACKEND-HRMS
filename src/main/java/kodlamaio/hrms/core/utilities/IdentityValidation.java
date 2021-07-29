package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.utilities.mernis.Mernis;

public class IdentityValidation {
	public static boolean isRealPerson(String tcno) {
		
		Mernis mmernis = new Mernis();
		return 	mmernis.validate(tcno);
	}
}
