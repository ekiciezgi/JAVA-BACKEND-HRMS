package kodlamaio.hrms.entities.dto;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperianceDto {
	
	private int id;
	private String jobplaceName;
	private LocalDate startDate;
	private LocalDate finishDate;
	private LocalDate createDate;
	private String position;
	private int employeecvId;
	private String jobDetail;
}
