package com.te.leraningmanagementsystem.admindto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.te.leraningmanagementsystem.adminpojo.Mentor;
import com.te.leraningmanagementsystem.employeedto.EmployeePrimaryInfoDto;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class BatchDto {
	
	private String batchid;

	private String batchName;

	private int mentorId;

	private String mentorName;

	private List<String> technologies;

	private String startDate;

	private String endDate;

	private String status;
	
	private Mentor mentor;
	
	private List<EmployeePrimaryInfo> employeePrimaryInfo;
}
