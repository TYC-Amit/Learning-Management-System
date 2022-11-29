package com.te.leraningmanagementsystem.employeepojo;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.leraningmanagementsystem.converter.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceId;
	
	@NotNull(message = "Company Name Should Not Be Null")
	@NotEmpty(message = "Comapany Mode Is Mandatory")
	private String companyName;
	
	
	private int yearOfExperience;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotEmpty(message = "Date Of Joining Is Not Be Empty")
	@NotNull(message = "Date Of Joining Not Be Null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy ")
	private String dateOfJoining;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotEmpty(message = "Date Of Relieving Is Not Be Empty")
	@NotNull(message = "Date Of Relieving Not Be Null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy ")
	private String dateOfRelieving;
	
    @Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotEmpty(message = "Designation Is Not Be Empty")
	@NotNull(message = "Designation Not Be Null")String> designation;
	
	@NotEmpty(message = "Location Is Not Be Empty")
	@NotNull(message = "Location Not Be Null")
	private String location;
}
