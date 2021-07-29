package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="confirm_employer")
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmEmployer {
	@Id
    @Column(name="id")
	private int id;
	 @Column(name="company_name")
     private String companyName;
	 
	 @Column(name="email")
     private String email;
	 
	 @Column(name="password")
     private String password;
	 
	  @Column(name="web_address")
     private String webAddress; 
	  
	  @Column(name="phone_number")
     private String phone;
	  
	    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
		@JsonIgnore
		private LocalDate createdAt = LocalDate.now();
	  
	    @Column(name = "is_active", columnDefinition = "boolean default true")
		private boolean isActive = true;

		
	  @Column(name = "is_confirm", columnDefinition = "boolean default false")
		private boolean isConfirm = false;
}
