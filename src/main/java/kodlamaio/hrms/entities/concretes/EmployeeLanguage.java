package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_language")
public class EmployeeLanguage {
	
	    @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="id")
	   private int id;
	
	  
	    
	   @Column(name = "language")
	   private String language;
	 
	 
	    @Min(value=1)
	    @Max(value=5)
	    @Column(name = "level")
	    private int level;
	    
	    @ManyToOne()
	    @JoinColumn(name="employee_cv_id")
	    private EmployeeCv employeeCv;
}
