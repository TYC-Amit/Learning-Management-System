package com.te.leraningmanagementsystem.employeepojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AddressDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressDeatilsId;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private PrimaryAddress primaryAddress;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private CorrespondenceAddress correspondenceAddress;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;
}
