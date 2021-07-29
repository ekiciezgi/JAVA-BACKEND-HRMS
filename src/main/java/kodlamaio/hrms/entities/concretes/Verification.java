package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor

public class Verification {

	  @Id
	  @GeneratedValue
	  
	  @Column(name="id")	
      private int id;
	
	  @Column(name="code")
      private String code;
	  
	  @Column(name="is_verified")
      private boolean verified; 
	  
	  @Column(name="user_id")
      private int userId;
	  
	 
}
