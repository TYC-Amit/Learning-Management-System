package com.te.leraningmanagementsystem.mentorpojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.te.leraningmanagementsystem.converter.StringListConverter;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
public class FinalBatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int finalBatchNo;

	private int batchNo;

	@Column(name = "batch_Id")
	private String batchId;

	private String batchName;

	@Convert(converter = StringListConverter.class)
	private List<String> technologies;

	private String startDate;

	private String endDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "finalBatchNo")
	private List<EmployeePrimaryInfo> employeePrimaryInfo;

	private String batchStatus;

	private int strength;
}