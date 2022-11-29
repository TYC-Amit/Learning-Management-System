package com.te.leraningmanagementsystem.employeepojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class EmployeePrimaryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeePrimaryId;

	private String employeeId;

	private String employeeName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy ")
	private String dateOfJoining;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy ")
	private String dateOfBirth;

	private String emailId;

	private String bloodGroup;

	@Convert(converter = StringListConverter.class)
	private List<String> designation;

	private String gender;

	@Convert(converter = StringListConverter.class)
	private List<String> nationality;

	@Convert(converter = StringListConverter.class)
	private List<String> employeeStatus;

	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeSecondaryInfo employeeSecondaryInfo;

	@OneToOne(cascade = CascadeType.ALL)
	private EducationDetails educationDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<AddressDetails> addressDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TechanicalSkills> techanicalSkills;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> experience;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contacts> contacts;
	
	private boolean deleted;
}
