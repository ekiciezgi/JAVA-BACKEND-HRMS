package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobNotices"})
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name="user_id")
public class Employers extends User{
	 
	  
	  @Column(name="company_name")
      private String companyName;
	  
	  @Column(name="web_address")
      private String webAddress; 
	  
	  @Column(name="phone_number")
      private String phone;
	  
	  @Column(name = "is_confirm", columnDefinition = "boolean default true")
		private boolean isConfirm = true;
	  
	  @JsonIgnore
	  @OneToMany(mappedBy="employer")
	  private List<JobNotice>jobNotice;
	  
	   @OneToMany(mappedBy = "employer")
	    @JsonIgnore
	    private List<FavoriJob>javoriJob;
}
