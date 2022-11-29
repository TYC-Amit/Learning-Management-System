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
public class CorrespondenceAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int correspondenceAddressId;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotBlank(message = "Address Type Is Mandatory") String> addressType;
	
	@NotNull(message = "Door No Should Not Be Null")
	@NotEmpty(message = "Door No Is Mandatory")
	private String doorNo;
	
	@NotEmpty(message = "Street Is Mandatory")
	private String street;
	
	@NotNull(message = "Locality Should Not Be Null")
	@NotEmpty(message = "Locality Is Mandatory")
	private String locality;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "City Should Not Be Null") 
	@NotEmpty(message = "City Should Not Be Empty") String> city;
	
	@Valid
	@Convert(converter = StringListConverter.class)
	private List<@NotNull(message = "State IS Mandatory")
	@NotEmpty(message = "State IS Not BE Empty") String> state;
	
	@NotNull(message = "Pincode Should Not Be Null")
	private long pincode;
	
	@NotNull(message = "Landmark Should Not Be Null")
	@NotEmpty(message = "Landmark Is Mandatory")
	private String landmark;
	
}
