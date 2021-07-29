package kodlamaio.hrms.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemEmployeesDto {
    private int id;
	private String firstName;
	private String lastName;
    private int userId;
  
}
