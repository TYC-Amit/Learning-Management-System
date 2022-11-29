package com.te.leraningmanagementsystem.adminpojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.te.leraningmanagementsystem.converter.StringListConverter;
import com.te.leraningmanagementsystem.employeedto.EmployeePrimaryInfoDto;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "batchId")
public class Batch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String batchId;

	private String batchName;

	@Convert(converter = StringListConverter.class)
	private List<String> technologies;

	private String startDate;

	private String endDate;

	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	private Mentor mentor;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeePrimaryInfo> employeePrimaryInfo;
	
	private boolean deleted;

}