package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSchoolDto {
	private int id;
	private String schoolName;
	private LocalDate startDate;
	private LocalDate finishDate;
	private LocalDate graduationYear;
	private String schooldepartment;
	private int employeeCvId;
}
