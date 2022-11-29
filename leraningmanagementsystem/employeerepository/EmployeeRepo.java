package com.te.leraningmanagementsystem.employeerepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.adminpojo.Batch;
import com.te.leraningmanagementsystem.employeepojo.EmployeePrimaryInfo;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeePrimaryInfo, Integer> {

	Optional<EmployeePrimaryInfo> findByEmployeeId(String employeeId);

	List<EmployeePrimaryInfo> findAllByDeleted(boolean deleted);
	
	Page<EmployeePrimaryInfo> findAllByEmployeeNameContainingOrGenderContainingOrEmployeeIdContainingIgnoreCase(
			String str, String str2, String str3, PageRequest of);
	
	Page<EmployeePrimaryInfo> findAllByEmployeeNameContainingIgnoreCase(String str,PageRequest of);
}
