package com.te.leraningmanagementsystem.employeeservice;

import java.util.List;
import java.util.Optional;

import com.te.leraningmanagementsystem.employeedto.EmployeePrimaryInfoDto;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;
import com.te.leraningmanagementsystem.mentormodulepageresponse.PageResponse;

public interface EmployeeService {

	public EmployeePrimaryInfo addAllDeatilsEmp(EmployeePrimaryInfoDto employeedto);

	public Optional<EmployeePrimaryInfo> findByEmployeeId(String employeeId);

	public EmployeePrimaryInfo updateEmployeeInfo(String employeeId, EmployeePrimaryInfoDto employeedto);
	
	public List<EmployeePrimaryInfo> findAllEmployeePrimaryInfo();

	public PageResponse getAllEmployeeDetails(int pageNumber, int pageSize, String employeeName);
}
