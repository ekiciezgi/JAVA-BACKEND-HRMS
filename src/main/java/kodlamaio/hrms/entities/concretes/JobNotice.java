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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_notices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","employer"})
@Entity
public class JobNotice {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_notices_id")
	private int id;
    
   @Column(name="company_name")
    private String companyName;
    
    @Column(name="max_pay")
	private Double maxPay;
    
    @Column(name="min_pay")
	private Double minPay;
    
    @Column(name="description")
	private String description;

	@Column(name="add_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate addDate=LocalDate.now();
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="active_position_number")
	private int activePositionNumber;
	
	@Column(name="activity_status",columnDefinition = "boolean default true")
	private boolean activityStatus=true;
	
	@Column(name="is_confirmed_by_admin",columnDefinition = "boolean default false")
	private boolean isConfirmedByAdmin=false;
	
	@ManyToOne
	@JoinColumn(name="position_title_id")
	private Position jobPosition;

	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;


	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employers employer;
	
	
	@ManyToOne()
	@JoinColumn(name="work_place_id")
	private WorkPlace workPlace;


	@ManyToOne()
	@JoinColumn(name="work_time_id")
	private WorkTime workTime;
   
	
}
