package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="id")
public class Employee extends User {
	  
	
	
	  @Column(name="first_name")
      private String FirstName;
	  
	  @Column(name="last_name")
      private String LastName; 
	  
	  @Column(name="nationality_id")
      private String nationalityId;
	  
	  @Column(name="birth_date")
      private Date Birthday;
      
	  
	    @OneToMany(mappedBy = "employee")
	    @JsonIgnore
	    private List<EmployeeCv>employeeCv;

	    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
	    @JsonIgnore
	    private List<FavoriJob>javoriJob;
	
 
}
