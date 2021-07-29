package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="cities")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobNotices"})
@AllArgsConstructor
@NoArgsConstructor
public class City {
	

		@Id
		@Column(name="city_id")
		private int cityId;
		
		@Column(name="city_name")
		private String cityName;
		
		@JsonIgnore
		@OneToMany(mappedBy = "city")
		private List<JobNotice> jobNotices;
}
