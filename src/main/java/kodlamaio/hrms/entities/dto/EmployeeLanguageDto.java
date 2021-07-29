package kodlamaio.hrms.entities.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLanguageDto {
	private int id;
	private int employeeCvId;
	private String language;
	private int level;

}
