package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_cv")
public class EmployeeCv  {
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)     
	@Column(name = "id")    
    private int id;
	
	    @ManyToOne()
	    @JoinColumn(name = "employee_id")
	    private Employee employee;
	    
	    @Column(name = "github_address")
	    private String githubAddress;

	    @Column(name = "linkedin_address")
	    private String linkedinAddress;

	    @Column(name = "cover_letter")
	    private String coverLetter;
	    
	    @Column(name = "abilities")
	    private String abilities;
	    
	    @Column(name = "image_url")
	    private String imageUrl;
	    
	    @JsonIgnore //GÖRÜNMESİNİ İSTEMİYORUZ
	    @Column(name = "created_Date")
	    private LocalDate createdDate = LocalDate.now();
	    
	    @OneToMany(mappedBy = "employeeCv",fetch = FetchType.LAZY)
	    @JsonIgnore
	    private List<EmployeeLanguage> employeeLanguages;
	    
	    
	    @OneToMany(mappedBy = "employeeCv",fetch = FetchType.LAZY)
	    @JsonIgnore
	    private List<EmployeeSchool> employeeSchools;
	    
	    @OneToMany(mappedBy = "employeeCv",fetch = FetchType.LAZY)
	    @JsonIgnore
	    private List<JobExperience> jobExperience;
	    
       
	    

}
