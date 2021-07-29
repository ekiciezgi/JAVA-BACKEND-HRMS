package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class EmployeeSchool {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name = "school_name")
    private String schoolName;
    
    @Column(name = "school_department")
    private String schoolDepartment;
    
    @Column(name = "graduation_year")
    private LocalDate graduationYear;
    
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;
  
   @ManyToOne(targetEntity = EmployeeCv.class)
   @JoinColumn(name="employee_cv_id")
   private EmployeeCv employeeCv;
}
