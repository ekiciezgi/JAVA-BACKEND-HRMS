package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCvDto {
 private int id;
 private int employeeCvId;
 private String githubAddress;
 private String linkedinAddress;
 private String coverLetter;
 private String abilities;
 private LocalDate createdDate;
 
}
