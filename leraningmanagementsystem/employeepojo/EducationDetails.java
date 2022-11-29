package com.te.leraningmanagementsystem.employeepojo;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationDetailsId;

	private String educationType;

	private int yearOfPassing;

	@NotNull(message = "Percentage Is Mandatory")
	private double percentage;

	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotEmpty(message = "University Should Not Be Empty") String> universityName;

	@NotBlank(message = "Institute Name Is Mandatory")
	@NotNull(message = "Institute Name Should Not Be Null")
	private String instituteName;

	@NotBlank(message = "Specialization Is Mandatory")
	@NotNull(message = "Specilalization Should Not Be Null")
	private String specialization;

	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotEmpty(message = "State Should Not Be Empty") @NotNull(message = "State Is Mandatory") String> state;
}
