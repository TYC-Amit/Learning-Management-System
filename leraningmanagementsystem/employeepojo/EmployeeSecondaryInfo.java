package com.te.leraningmanagementsystem.employeepojo;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
public class EmployeeSecondaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeSecondaryInfo;

	@NotBlank(message = "PanNO Is Mandatory")
	@NotNull(message = "PanNo Is Mandatory")
	private String panNo;

	@NotBlank(message = "AddharNo Is Should Not Be Blank")
	@NotNull(message = "AddharNo Is Mandatory")
	private String addharNo;

	@NotBlank(message = "Father Name Is Mandatory")
	@NotNull(message = "Father Name Is Necessary")
	private String fatherName;

	@NotBlank(message = "Mother Name Is Mandatory")
	@NotNull(message = "Mother Name Is Necessaary")
	private String motherName;

	private String spouseName;

	private String passportName;

	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotBlank(message = "Martial Status Is Mandatory") 
	@NotNull(message = "Martial Status IS Mandatory") String> martialStatus;
}
