package com.te.leraningmanagementsystem.mentordto;

import java.util.List;

import javax.persistence.Entity;

import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalBatchDto {

	private int batchNo;

	private String batchId;

	private String batchName;

	private List<String> technologies;

	private String startDate;

	private String endDate;

	private List<EmployeePrimaryInfo> employeePrimaryInfo;

	private String batchStatus;

	private int strength;
}