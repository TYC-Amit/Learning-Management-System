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
public class BankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankDeatilsId;
	
	@NotNull(message = "Account No Should Not Be Null")
	@NotEmpty(message = "Account No Is Mandatory")
	private String accountNo;
	
	@NotNull(message = "Bank Name Should Not Be Null")
	@NotEmpty(message = "Bank Name Is Mandatory")
	private String bankName;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "Account Type Should Not Be Null")
	@NotEmpty(message = "Account Type Is Mandatory")String> accountType;
	
	@NotNull(message = "IFSC Code Must Be Filled")
	@NotEmpty(message = "IFSC Code Is Mandatory")
	private String ifcsCode;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "Branch Should Not Be Null")
	@NotEmpty(message = "Branch Is Mandatory")String> branch;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "State Should Not Be Null")
	@NotEmpty(message = "State Is Mandatory")String> state;
}
