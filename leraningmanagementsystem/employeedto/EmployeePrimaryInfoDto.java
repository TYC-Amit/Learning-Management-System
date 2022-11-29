package com.te.leraningmanagementsystem.employeedto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.te.leraningmanagementsystem.employeepojo.AddressDetails;
import com.te.leraningmanagementsystem.employeepojo.BankDetails;
import com.te.leraningmanagementsystem.employeepojo.Contacts;
import com.te.leraningmanagementsystem.employeepojo.EducationDetails;
import com.te.leraningmanagementsystem.employeepojo.EmployeeSecondaryInfo;
import com.te.leraningmanagementsystem.employeepojo.Experience;
import com.te.leraningmanagementsystem.employeepojo.TechanicalSkills;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeePrimaryInfoDto {

	private String employeeId;

	@NotBlank(message = "Employee Must Not Be Blank")
	@NotNull(message = "Employee Must Not Be Null")
	@Size(min = 3)
	@Size(max = 24)
	private String employeeName;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotEmpty(message = "Joining Date Is Mandatory")
	private String dateOfJoining;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotEmpty(message = " Date Of Birth Is Mandatory")
	private String dateOfBirth;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String emailId;

	private String bloodGroup;

	@NotNull(message = "Designation Is Mandatory")
	private List<@NotBlank(message = "Filled This Field Designation") String> designation;

	private String gender;

	@NotNull(message = "Nationality Is Mandatory")
	private List<@NotBlank(message = "Filled This Field Nationality") String> nationality;

	@NotNull(message = "Filled Employee Status Is Mandatory")
	private List<@NotBlank(message = "Filled This Field Employee Status") String> employeeStatus;

	@Valid
	private EmployeeSecondaryInfo employeeSecondaryInfo;

	@Valid
	private EducationDetails educationDetails;

	@Valid
	private List<AddressDetails> addressDetails;

	@Valid
	private BankDetails bankDetails;

	@Valid
	private List<TechanicalSkills> techanicalSkills;

	@Valid
	private List<Experience> experience;

	@Valid
	private List<Contacts> contacts;
	
	private String mockRate;
}
