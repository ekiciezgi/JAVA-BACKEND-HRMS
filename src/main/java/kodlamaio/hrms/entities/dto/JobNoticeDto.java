package kodlamaio.hrms.entities.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobNoticeDto {
	private int positionId;
    private int employerId;
    private String description;
    private int cityId;
    private double minSalary;
    private double maxSalary;
    private int openPositionCount;
    private LocalDate applicationDeadLine;
    @JsonIgnore
    private boolean isActive;
    private int workPlaceId;
    private int workTimeId;
}
